#include <string>
#include <sstream>
#include <iostream>
#include "clang/AST/ASTContext.h"
#include "clang/AST/ASTConsumer.h"
#include "clang/AST/RecursiveASTVisitor.h"
#include "clang/Driver/Options.h"
#include "clang/Frontend/CompilerInstance.h"
#include "clang/Frontend/FrontendAction.h"
#include "clang/Frontend/FrontendActions.h"
#include "llvm/Option/OptTable.h"
#include "llvm/Support/CommandLine.h"
#include "llvm/Support/Path.h"
#include "llvm/Support/Signals.h"
#include "clang/Tooling/CommonOptionsParser.h"
#include "clang/Tooling/Tooling.h"

using namespace clang;
using namespace clang::driver;
using namespace clang::tooling;
using namespace llvm;
using namespace llvm::opt;

class MyAstVisitor : public RecursiveASTVisitor<MyAstVisitor> {
public:
  explicit MyAstVisitor(ASTContext *Context, llvm::StringRef InFile) : Context(Context), source_file(InFile) {}
  /*
    std::string toString(const Stmt *p) {
    std::string s;
    llvm::raw_string_ostream raw(s);
    p->printPretty(raw, NULL, Context->getPrintingPolicy());
    return raw.str();
    }
    
    std::string getMemberName(MemberExpr *mem) {
    Expr *base = mem->getBase();
    ImplicitCastExpr *parent_imp = dyn_cast<ImplicitCastExpr>(base);
    MemberExpr *parent_mem = dyn_cast<MemberExpr>(base);
    DeclRefExpr *parent_def = dyn_cast<DeclRefExpr>(base);
    std::string dot_arrow;
    if(parent_mem){
    Expr *grandpa = parent_mem->getBase();
    ImplicitCastExpr *imp = dyn_cast<ImplicitCastExpr>(grandpa);
    if(imp){    
    return getFunctionName(grandpa) + "->" + mem->getMemberNameInfo().getAsString();
    }else{
    return getMemberName(parent_mem) + "." + mem->getMemberNameInfo().getAsString();
    }
    }
    if(parent_imp){
    llvm::outs() << "This is here!! \n";
    return getFunctionName(base) + "->" + mem->getMemberNameInfo().getAsString();
    }
    if(parent_def){ 
    return std::string(parent_def->getFoundDecl()->getName()) + "." + mem->getMemberNameInfo().getAsString();
    }
    return "";
    }

    std::string getFunctionName(Expr *callee_expr) {
    ImplicitCastExpr *imp = dyn_cast<ImplicitCastExpr>(callee_expr);
    if(!imp){
    ParenExpr *paren = dyn_cast<ParenExpr>(callee_expr);
    if(paren){
    return toString(paren);
    }
    return "unknown";
    }
    Expr *sub = imp->getSubExpr();
    if(!sub){
    return "";
    }
    DeclRefExpr *def = dyn_cast<DeclRefExpr>(sub);
    if(def){
    return def->getFoundDecl()->getName();
    }
    MemberExpr *mem = dyn_cast<MemberExpr>(sub);
    if(mem){ 
    return getMemberName(mem);
    }
    
    ParenExpr *par = dyn_cast<ParenExpr>(sub);
    if(par){  
    return toString(par);
    }
    
    return "";
    }*/
  
  /*
    bool VisitCallExpr(CallExpr *cexpr) {
    FullSourceLoc FullLocation = Context->getFullLoc(cexpr->getLocStart());
    llvm::outs() << "call, " 
    << last_func << ", " 
    << getFunctionName(cexpr->getCallee()) << ", "
    << FullLocation.getManager().getFilename(FullLocation) << ", " 
    << FullLocation.getSpellingLineNumber() << ", "
    << FullLocation.getSpellingColumnNumber();
    for (clang::CallExpr::arg_iterator iter = cexpr->arg_begin(); iter != cexpr->arg_end(); ++iter) {
    llvm::outs() <<  ", \"" << toString(*iter) << "\"";
    }
    llvm::outs() << "\n";
    return true;
    }
  */
  
  // ここから
  // TraverseDecl
  bool TraverseDecl(Decl *decl) {
    if (decl != NULL){
      switch (decl->getKind()) {
      case Decl::Field:
	llvm::outs() << "\n";
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::Function:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::ParmVar:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::TranslationUnit:
	linefeedflag = 0;
	linefeedbody = 0;
	caseflag = 0;
	labelflag = 0;
	caselabel = "";
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::Typedef:
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::Record:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::Var:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      default :
	llvm::outs() << decl->getDeclKindName();
	RecursiveASTVisitor::TraverseDecl(decl);
      }
    }
    return true;
  }

  // FieldDecl (Structure Member) 
  bool VisitFieldDecl(FieldDecl *field) {
    QualType fieldtype = field->getType();
    llvm::outs() << "{:kind Field "
		 << " :name " << "\"" << field->getName() << "\""
		 << " :scope " << "member";
    /* とりあえずTypeは”型”の文字列として扱う
       if (fieldtype->isStructureType()) {
       llvm::outs() << "[";
       getStructInfo(fieldtype);
       llvm::outs() << "]";
       } else if (fieldtype->isArrayType()) {
       ArrayFlag = 1;
       llvm::outs() << "[";
       getArrayInfo(fieldtype);
       llvm::outs() << "]";
       } else if (fieldtype->isPointerType()) {
       llvm::outs() << "[";
       getPointerInfo(fieldtype);
       llvm::outs() << "]";
       } else {
       llvm::outs() << fieldtype.getAsString();
       }*/
    llvm::outs() << " :type "<< "\"" << getTypeInfo(fieldtype) << "\"";
    PrintSourceRange(field->getSourceRange());
    llvm::outs() << "}";
    return true;
  }
  
  // FunctionDecl
  bool VisitFunctionDecl(FunctionDecl *Decl) {
    last_func = Decl->getQualifiedNameAsString();
    QualType functype = Decl->getResultType();
    llvm::outs() << "{:kind \"Funcdef\""
		 << " :name " << "\"" << last_func << "\""
		 << " :type " << "\"" << getTypeInfo(functype) << "\"";
    PrintSourceRange(Decl->getSourceRange());
    llvm::outs() << "\n :Parm [";
    if (Decl->param_size()) {
      linefeedflag = 0;
      for (int i = 0; i < (int)Decl->param_size(); i++) {
	TraverseDecl(Decl->getParamDecl(i));
      }
    }
    llvm::outs() << "]\n :body [";
    linefeedflag = 0;
    linefeedbody = 0;
    TraverseStmt(Decl->getBody());
    llvm::outs() << "]}";
    //<< (Decl->getStorageClass() == SC_Static? ",static,": ",global,") 
    //<< loc[0].getManager().getFilename(loc[0]) << ", " 
    return false;
  }

  // ParmVarDecl
  bool VisitParmVarDecl(ParmVarDecl *Decl) {
    std::string varname = Decl->getNameAsString();
    QualType vartype = Decl->getType();
    llvm::outs() << "{:kind \"Parm\"" 
		 << " :name " << "\"" << varname  << "\""
		 << " :type " << "\"" << getTypeInfo(vartype) << "\"";
    PrintSourceRange(Decl->getSourceRange());
    llvm::outs() << "}";
    return true;
  }

  // RecordDecl (Structure?)
  bool VisitRecordDecl(RecordDecl *record) {
    llvm::outs() << "{:kind \"Structdef\""
		 << " :name " << "\"" << record->getName() << "\"";
    PrintSourceRange(record->getSourceRange()); 
    llvm::outs() << " :Member [";
    if (!(record->field_empty())) {
      RecordDecl::field_iterator itr = record->field_begin();
      while (itr != record->field_end()) {
	TraverseDecl(itr->getCanonicalDecl());
	itr++;
      } 
    }
    llvm::outs() << "]}";
    return false;
  }

  // VarDecl
  bool VisitVarDecl(VarDecl *Decl) {
    if (Decl->getKind() == 50) {
      return true;
    }
    std::string kindname = "Var";
    std::string varname = Decl->getNameAsString();
    QualType vartype = Decl->getType();
    std::string arrsize;
    llvm::outs() << "{" << ":kind "<< "\"" << kindname << "\""  
		 << " :name " << "\"" << varname << "\"" 
		 << " :scope " << (Decl->isFileVarDecl() == 1? "\"global\"":"\"local\"");
    /* とりあえずTypeは...
       if (vartype->isArrayType()) {
       ArrayFlag = 1;
       llvm::outs() << "[";
       getArrayInfo(vartype);
       llvm::outs() << "]";
       } else if (vartype->isPointerType()) {
       llvm::outs() << "[";
       getPointerInfo(vartype);
       llvm::outs() << "]";
       } else {
       llvm::outs() << vartype.getAsString();
       }*/
    llvm::outs() << " :type " << "\"" << getTypeInfo(vartype) << "\"";
    PrintSourceRange(Decl->getSourceRange());
    if (Decl->hasInit()) {
      llvm::outs() << " :init ";
      linefeedflag = 0;
      TraverseStmt(Decl->getInit());
    }
    llvm::outs() << "}";
    return false;
  }
  
  std::string getTypeInfo(QualType typeInfo) {
    std::string str;
    str = typeInfo.getAsString();
    return str;
  }

  void getArrayInfo(QualType arrInfo) {
    llvm::outs() << "{Array :elmkind "
		 << arrInfo->getAsArrayTypeUnsafe()->getElementType().getAsString() << " :elmtype "
		 << arrInfo.getAsString() << " :elmsize}";
  }
  
  void getPointerInfo(QualType ptrInfo) {
    llvm::outs() << "{Pointer :elmkind ";
    if (ptrInfo->getPointeeType()->isStructureType()) {
      getStructInfo(ptrInfo->getPointeeType());
    }
    llvm::outs() << " :elmtype"
		 << "}";
  }

  void getStructInfo(QualType structInfo) {
    llvm::outs() << "{Struct :elmkind "
		 << structInfo->getAsStructureType()->getDecl()->getName() << " :elmname"
		 << "}";
  }

  // Stmt : Binop, ReturnStmt, forstmt, ifstmt, ... etc
  // *Stmt, *Expr をカバーしていると思う
  bool TraverseStmt(Stmt *stmt) {
    if (stmt != NULL){
      //llvm::outs() << "\nenter " << stmt->getStmtClassName() << "\n";
      switch (stmt->getStmtClass()) {
      case Stmt::BreakStmtClass:
	llvm::outs() << "\n";
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::CaseStmtClass:
	caseflag = 1;
	labelflag = 1;
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::CompoundStmtClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::ContinueStmtClass:
	llvm::outs() << "\n";
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::DeclStmtClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::DefaultStmtClass:
	caseflag = 1;
	labelflag = 1;
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::DoStmtClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::ForStmtClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::GotoStmtClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::IfStmtClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::LabelStmtClass:
	caseflag = 1;
	labelflag = 1;
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::SwitchStmtClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::WhileStmtClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::ReturnStmtClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::ArraySubscriptExprClass:
	if (FuncCall == 1) {
	  FuncCall = 0;
	} else if (ArraySub == 1) {
	  RecursiveASTVisitor::TraverseStmt(stmt);
	  break;
	} else {
	  llvm::outs() << "\n";
	}
	ArraySub = 1;
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::CallExprClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	FuncCall = 1;
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::CStyleCastExprClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::DeclRefExprClass:
	if (FuncCall == 1 || ArraySub == 1 || linefeedflag == 0 || linefeedbody == 0) {
	  FuncCall = 0;
	  ArraySub = 0;
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::ImplicitCastExprClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::InitListExprClass:
	llvm::outs() << "\n";
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::MemberExprClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::ParenExprClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::UnaryExprOrTypeTraitExprClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::BinaryOperatorClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::CompoundAssignOperatorClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::UnaryOperatorClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::CharacterLiteralClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  //llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::FloatingLiteralClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::IntegerLiteralClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  //llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::StringLiteralClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      default:
	llvm::outs() << "[" << stmt->getStmtClassName();	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
      }
      //llvm::outs() << "\nleave " << stmt->getStmtClassName() << "\n";
    }
    return true;
  }
  bool shouldUseDataRecursionFor(Stmt* S) const {
    return false;
  }
  
  // BreakStmt
  bool VisitBreakStmt(BreakStmt *Break) {
    llvm::outs()  << "{:kind \"Break\"";
    PrintSourceRange(Break->getSourceRange());
    llvm::outs() << "}";
    return true;
  }
 
  // CaseStmt
  bool VisitCaseStmt(CaseStmt *Case) {
    os << "{:kind \"Case\"";
    PrintSourceRange(Case->getSourceRange());
    os  << " :value ";
    if (labelflag > 1) {
      caselabel += "\n";
    }
    caselabel += os.str();
    os.str("");
    os.clear();
    return true;
  }
  
  // ContinueStmt
  bool VisitContinueStmt(ContinueStmt *Continue) {
    llvm::outs() << "{:kind \"Continue\"";
    PrintSourceRange(Continue->getSourceRange());
    llvm::outs() << "}";
    return true;
  } 
  
  // DefaultStmt
  bool VisitDefaultStmt(DefaultStmt *Default) {
    os << "{:kind \"Default\"";
    PrintSourceRange(Default->getSourceRange());
    os << "}";
    if (labelflag > 1) {
      caselabel += "\n";
    }
    caselabel += os.str();
    os.str("");
    os.clear();
    labelflag = 0;
    return true;
  }

  // DoStmt
  bool VisitDoStmt(DoStmt *Do) {
    llvm::outs() << "{:kind \"Do\"";
    PrintSourceRange(Do->getSourceRange());
    llvm::outs() << "\n :condition ";
    linefeedflag = 0;
    TraverseStmt(Do->getCond());
    llvm::outs() << "\n :body [";
    linefeedflag = 0;
    linefeedbody = 0;
    TraverseStmt(Do->getBody());
    llvm::outs() << "]}";
    return false;
  }

  // ForStmt
  bool VisitForStmt(ForStmt *For) {
    llvm::outs() << "{:kind \"For\"";
    PrintSourceRange(For->getSourceRange());
    llvm::outs() << "\n :init [";
    linefeedflag = 0;
    TraverseStmt(For->getInit());
    llvm::outs() << "]\n :condition ";
    linefeedflag = 0;
    TraverseStmt(For->getCond());
    llvm::outs() << "\n :update [";
    linefeedflag = 0;
    TraverseStmt(For->getInc());
    llvm::outs() << "]\n :body [";
    linefeedflag = 0;
    linefeedbody = 0;
    TraverseStmt(For->getBody());
    llvm::outs() << "]}";
    return false;
  }

  // GotoStmt
  bool VisitGotoStmt(GotoStmt *Goto) {
    NamedDecl *label = dyn_cast<NamedDecl>(Goto->getLabel());
    llvm::outs() << "{:kind \"Goto\"";
    PrintSourceRange(Goto->getSourceRange());
    llvm::outs() << " :label " << "\"" << label->getName() << "\"}";
    return true;
  }

  // IfStmt
  bool VisitIfStmt(IfStmt *If) {
    llvm::outs() << "{:kind \"If\"";
    PrintSourceRange(If->getSourceRange());
    llvm::outs() << "\n :condition ";
    linefeedflag = 0;
    TraverseStmt(If->getCond());
    llvm::outs() << "\n :then [";
    linefeedflag = 0;
    TraverseStmt(If->getThen());
    llvm::outs() << "]";
    if (If->getElse()) {
      llvm::outs() << "\n :else [";
      linefeedflag = 0;
      TraverseStmt(If->getElse());
      llvm::outs() << "]}";
    } else {
      llvm::outs() << "}";
    }
    return false;
  }

  // LabelStmt
  bool VisitLabelStmt(LabelStmt *Label) {
    os << "{:kind \"Label\"";
    PrintSourceRange(Label->getSourceRange());
    os  << " :name " << "\"" << Label->getName() << "\"}";
    if (labelflag > 1) {
      caselabel += "\n";
    }
    caselabel += os.str();
    os.str("");
    os.clear();
    labelflag = 0;
    return true;
  }

  // SwitchStmt
  bool VisitSwitchStmt(SwitchStmt *Switch) {
    llvm::outs() << "{:kind \"Switch\"";
    PrintSourceRange(Switch->getSourceRange());
    llvm::outs() << "\n :condition ";
    linefeedflag = 0;
    TraverseStmt(Switch->getCond());
    llvm::outs() << "\n :body [";
    linefeedflag = 0;
    linefeedbody = 0;
    TraverseStmt(Switch->getBody());
    llvm::outs() << "]}";
    return false;
  }
  
  // WhileStmt
  bool VisitWhileStmt(WhileStmt *While) {
    llvm::outs() << "{:kind \"While\"";
    PrintSourceRange(While->getSourceRange());
    llvm::outs() << "\n :condition ";
    linefeedflag = 0;
    TraverseStmt(While->getCond());
    llvm::outs() << "\n :body [";
    linefeedflag = 0;
    linefeedbody = 0;
    TraverseStmt(While->getBody());
    llvm::outs() << "]}";
    return false;
  }
 
  // ReturnStmt
  bool VisitReturnStmt(ReturnStmt *Ret) {
    // 型情報が不安(void型関数で...)
    llvm::outs() << "{:kind \"Ret\"";
    PrintSourceRange(Ret->getSourceRange());
    if (Ret->getRetValue()) {
      llvm::outs() << " :value ";
      linefeedflag = 0;
      TraverseStmt(Ret->getRetValue());
    } else {
    
    }
    llvm::outs() << "}";
    return false;
  }

  // ArraySubscriptExpr
  bool VisitArraySubscriptExpr(ArraySubscriptExpr *arrsub) {
    llvm::outs() << "{:kind \"ArrayRef\"";
    PrintSourceRange(arrsub->getSourceRange());
    llvm::outs() << "\n :Array ";
    TraverseStmt(arrsub->getLHS());
    llvm::outs() << "\n :Index ";
    linefeedflag = 0;
    TraverseStmt(arrsub->getRHS()); 
    llvm::outs() << "}";
    return false;
  }

  // CallExpr
  bool VisitCallExpr(CallExpr *call) {
    llvm::outs() << "{:kind \"FuncCall\"";
    PrintSourceRange(call->getSourceRange());
    llvm::outs() << " :type \"" << call->getType().getAsString() << "\""
		 << "\n :Func ";
    linefeedflag = 0;
    TraverseStmt(call->getCallee());
    llvm::outs() << "\n :Parm [";
    if (call->getNumArgs() != 0) {
      int argnum = 0;
      linefeedflag = 0;
      while (argnum != (int)call->getNumArgs()) {
	TraverseStmt(call->getArg(argnum));
	argnum++;
      }
    }
    llvm::outs() << "]}";
    return false;
  }

  // DeclRefExpr(DRE)
  bool VisitDeclRefExpr(DeclRefExpr *Declref) {
    ValueDecl *valuedecl = Declref->getDecl();
    VarDecl *vardecl = dyn_cast<VarDecl>(valuedecl);
    FunctionDecl *funcdecl = dyn_cast<FunctionDecl>(valuedecl);
    std::string scope = "";
    if (vardecl) {// 変数の場合
      QualType vartype = vardecl->getType();
      scope = (vardecl->isFileVarDecl() == 1? "global":"local");
      std::string Declreftype = Declref->getType().getAsString();
      llvm::outs() << "{:kind \"DRE\"" 
		   << " :name " << "\"" << Declref->getNameInfo() << "\""
		   << " :scope " << "\"" << scope << "\"";
      /* とりあえずTypeは...
	 if (vartype->isArrayType()) {
	 ArrayFlag = 1;
	 llvm::outs() << "[";
	 getArrayInfo(vartype);
	 llvm::outs() << "]";
	 } else if (vartype->isPointerType()) {
	 llvm::outs() << "[";
	 getPointerInfo(vartype);
	 llvm::outs() << "]";
	 } else {
	 llvm::outs() << vartype.getAsString();
	 }*/
      llvm::outs() << " :type " << "\"" << getTypeInfo(vartype) << "\"";
      PrintSourceRange(Declref->getSourceRange());
      llvm::outs() << "}";
    } else if (funcdecl) {// 関数の場合
      QualType functype = funcdecl->getType();
      std::string Declreftype = funcdecl->getResultType().getAsString();
      llvm::outs() << "{:kind \"DRE\"" 
		   << " :name " << "\"" << Declref->getNameInfo() << "\"" 
		   << " :type " << "\"" << getTypeInfo(functype) << "\"";
      PrintSourceRange(Declref->getSourceRange());
      llvm::outs() << "}";
    }
    return true;
  }

  // MemberExpr
  bool VisitMemberExpr(MemberExpr *mem) {
    Expr *base = mem->getBase();
    ValueDecl *vdecl = mem->getMemberDecl();
    if(mem->isArrow()) {
      llvm::outs() << "{:kind \"Binop\" :op \"->\"";
      PrintSourceRange(mem->getSourceRange());
      llvm::outs() << "\n :LHS ";
      getlhsArrow(base);
      llvm::outs() << "\n :RHS ";
      getrhsArrow(vdecl);
      llvm::outs() << "}"; 
      return false;
    } 
    return true;
  }
  bool getlhsArrow(Expr *base) {
    ImplicitCastExpr *imp = dyn_cast<ImplicitCastExpr>(base);
    if (imp) {
      Expr *sub = imp->getSubExpr();
      DeclRefExpr *def = dyn_cast<DeclRefExpr>(sub);
      if (def) {
	linefeedflag = 0;
	TraverseStmt(def);
      }
    }
    return true;
  }
  bool getrhsArrow(ValueDecl *vdecl) {
    QualType vartype = vdecl->getType();
    llvm::outs() << "{:kind \"DRE\""
		 << " :name " << "\"" << vdecl->getName() << "\"" 
		 << " :scope \"member\"";
    /* とりあえずTypeは...
       if (vartype->isArrayType()) {
       ArrayFlag = 1;
       llvm::outs() << "[";
       getArrayInfo(vartype);
       llvm::outs() << "]";
       } else if (vartype->isPointerType()) {
       llvm::outs() << "[";
       getPointerInfo(vartype);
       llvm::outs() << "]";
       } else {
       llvm::outs() << vartype.getAsString();
       }*/
    llvm::outs() << " :type "<< "\"" << getTypeInfo(vartype) << "\"";
    PrintSourceRange(vdecl->getSourceRange());
    llvm::outs() << "}";
    return true;
  }
  
  // UnaryOperator
  bool VisitUnaryOperator(UnaryOperator *Unop) {
    UnaryOperator::Opcode opcode = Unop->getOpcode();
    llvm::outs() << "{:kind \"Unop\""
		 << " :op " << "\"" << Unop->getOpcodeStr(opcode) << "\"";
    PrintSourceRange(Unop->getSourceRange());
    llvm::outs() << " :HS ";
    linefeedflag = 0;
    TraverseStmt(Unop->getSubExpr());
    llvm::outs() << "}";
    return false;
  }

  // BinaryOperator
  bool VisitBinaryOperator(BinaryOperator *Binop) {
    llvm::outs() << "{:kind \"Binop\"" 
		 << " :op " << "\"" << Binop->getOpcodeStr() << "\"";
    PrintSourceRange(Binop->getSourceRange());
    if (caseflag != 0) {
      llvm::outs() << " :label [" << caselabel << "]";
      caselabel = "";
      caseflag = 0;
    } 
    llvm::outs() << "\n :LHS ";
    linefeedflag = 0;
    TraverseStmt(Binop->getLHS());
    llvm::outs() << "\n :RHS ";
    linefeedflag = 0;
    TraverseStmt(Binop->getRHS());
    llvm::outs() << "}";
      
    return false;
  }
  
  // LabelValue
  void getLabelValue(Expr *literal){
    std::string literalname;
    QualType literaltype = literal->getType();
    if (dyn_cast<IntegerLiteral>(literal)) {
      literalname = "INT";
    } else if (dyn_cast<CharacterLiteral>(literal)) {
      literalname = "CHAR";
    }
    os << "{:kind \"" << literalname << "\""
      //<< " :value " << "\"" << literal->getValue() << "\"" 
       << " :type "<< "\"" << literaltype.getAsString() << "\"";
    PrintSourceRange(literal->getSourceRange());
    os << "}}";
    caselabel += os.str();
    os.str("");
    os.clear();
    labelflag = 0;
    return;
  }

  // IntegerLiteral
  bool VisitIntegerLiteral(IntegerLiteral *Int) {
    QualType vartype = Int->getType();
    // ここの場合分けを見なおす必要あり, いるとこできえてる(ifの条件のとこにIntegerliteralが現れる場合に変になる場合がある)
    if (ArrayFlag == 1) {
      ArrayFlag = 0;
      return true;
    }
    if (labelflag != 0) {
      getLabelValue(Int);
    } else {
      llvm::outs() << "{:kind \"IntegerLiteral\""
		   << " :value " << "\"" << Int->getValue() << "\"" 
		   << " :type "<< "\"" << vartype.getAsString() << "\"";
    PrintSourceRange(Int->getSourceRange());
    llvm::outs() << "}";
    }
    return true;
  }

  // FloatingLiteral
  bool VisitFloatingLiteral(FloatingLiteral *Float) {
    QualType vartype = Float->getType();
    llvm::outs() << "{:kind \"FloatingLiteral\""
		 << " :value " << "\"" << Float->getValueAsApproximateDouble() << "\""
		 << " :type "<< "\"" << vartype.getAsString() << "\"";
    PrintSourceRange(Float->getSourceRange());
    llvm::outs() << "}";
    return true;
  }

  // CharacterLiteral
  bool VisitCharacterLiteral(CharacterLiteral *Char) {
    if (labelflag != 0) {
      getLabelValue(Char);
    } else {
      llvm::outs() << "{:kind \"CharacterLiteral\""
		   << " :value " << "\"" << char(Char->getValue()) << "\""
		   << " :type "<< "\"char\"";
      PrintSourceRange(Char->getSourceRange());
      llvm::outs() << "}";
    }
    return true;
  }

  // StringLiteral
  bool VisitStringLiteral(StringLiteral *String) {
    QualType vartype = String->getType();
    llvm::outs() << "{:kind \"StringLiteral\""
		 << " :value " << "\"" << String->getString().str() << "\""
		 << " :type "<< "\"" << vartype.getAsString() << "\"";
    PrintSourceRange(String->getSourceRange());
    llvm::outs() << "}";
    return true;
  }

  // 出力関係
  void PrintSourceRange(SourceRange range) {
    if (labelflag != 0) {
      os << " :line [" << 
	Context->getFullLoc(range.getBegin()).getSpellingLineNumber() <<
	" " <<
	Context->getFullLoc(range.getEnd()).getSpellingLineNumber() <<
	"]";
      caselabel += os.str();
      os.str("");
      os.clear();
    } else {
      llvm::outs() << " :line [" << 
	Context->getFullLoc(range.getBegin()).getSpellingLineNumber() <<
	" " <<
	Context->getFullLoc(range.getEnd()).getSpellingLineNumber() <<
      "]";
    }
  }
  
private:
  ASTContext *Context;
  std::string last_func;
  std::string source_file;
  std::string caselabel; // 出力したいラベルの属性
  std::ostringstream os;
  unsigned paramsize;
  int ArrayFlag;
  int ArraySub;
  int caseflag; // ラベルが付いている証
  int FuncCall;
  int labelflag; // ラベル(case, default, label)が出現した印
  int linefeedbody;
  int linefeedflag;
};


class MyAstConsumer : public clang::ASTConsumer {
public:
  explicit MyAstConsumer(ASTContext *Context, llvm::StringRef InFile) : Visitor(Context, InFile) {}
  virtual void HandleTranslationUnit(clang::ASTContext &Context) {
    llvm::outs() << "\n[";
    Visitor.TraverseDecl(Context.getTranslationUnitDecl());
    llvm::outs() << "] \n\n";
  }

private:
  MyAstVisitor Visitor;
};

class MyAnalysisAction : public clang::ASTFrontendAction {
public:
  virtual clang::ASTConsumer *CreateASTConsumer(clang::CompilerInstance &Compiler, llvm::StringRef InFile)
  {
    return new MyAstConsumer(&Compiler.getASTContext(), InFile);
  }
};

int main(int argc, const char **argv) {
  CommonOptionsParser OptionsParser(argc, argv);
  ClangTool Tool(OptionsParser.getCompilations(),
                 OptionsParser.getSourcePathList());

  return Tool.run(newFrontendActionFactory<MyAnalysisAction>());
}
