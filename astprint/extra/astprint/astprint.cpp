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

class MyAstVisitor : public RecursiveASTVisitor<MyAstVisitor>{
public:
  explicit MyAstVisitor(ASTContext *Context, llvm::StringRef InFile) : Context(Context), source_file(InFile) {}
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
  }
  
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
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseDecl(decl);
	llvm::outs() << "]";
	break;
      case Decl::Function:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseDecl(decl);
	llvm::outs() << "]";
	break;
      case Decl::ParmVar:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseDecl(decl);
	llvm::outs() << "]";
	break;
      case Decl::TranslationUnit:
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::Typedef:
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::Record:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseDecl(decl);
	llvm::outs() << "]";
	break;
      case Decl::Var:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseDecl(decl);
	llvm::outs() << "]";
	break;
      default :
	llvm::outs() << decl->getDeclKindName();
	RecursiveASTVisitor::TraverseDecl(decl);
      }
    }
    return true;
  }

  // FieldDecl (Structure Member)
  /*bool TraverseFieldDecl(FieldDecl *field) {
    llvm::outs() << "\n";
    llvm::outs() << "[";
    RecursiveASTVisitor::TraverseFieldDecl(field);
    llvm::outs() << "]";
    return true;
    }*/
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
    llvm::outs() << " :type "<< "\"" << getTypeInfo(fieldtype) << "\"}";
    return true;
  }
  
  // FunctionDecl
  /*bool TraverseFunctionDecl(FunctionDecl *Decl) {
    if (linefeedflag == 0) {
      linefeedflag = 1;
    } else {
      llvm::outs() << "\n";
    }
    llvm::outs() << "[";
    RecursiveASTVisitor::TraverseFunctionDecl(Decl);
    llvm::outs() << "]";
    return true; 
    }*/
  bool VisitFunctionDecl(FunctionDecl *Decl) {
    last_func = Decl->getQualifiedNameAsString();
    QualType functype = Decl->getResultType();
    //FullSourceLoc loc[2] = {
    //Context->getFullLoc(Decl->getSourceRange().getBegin()), 
    //Context->getFullLoc(Decl->getSourceRange().getEnd()) };
    llvm::outs() << "{:kind \"Func\""
		 << " :name " << "\"" << last_func << "\""
		 << " :type " << "\"" << getTypeInfo(functype) << "\"";
    llvm::outs() << "\n :Parm [";
    if (Decl->param_size()) {
      linefeedflag = 0;
      for (int i = 0; i < (int)Decl->param_size(); i++) {
	TraverseDecl(Decl->getParamDecl(i));
      }
    }
    llvm::outs() << "]\n :body [";
    linefeedflag = 0;
    TraverseStmt(Decl->getBody());
    llvm::outs() << "]}";
    //<< (Decl->getStorageClass() == SC_Static? ",static,": ",global,") 
    //<< loc[0].getManager().getFilename(loc[0]) << ", " 
    // << loc[0].getSpellingLineNumber() << ", "         
    // << loc[1].getSpellingLineNumber();
    return false;
  }

  // ParmVarDecl
  bool VisitParmVarDecl(ParmVarDecl *Decl) {
    std::string varname = Decl->getNameAsString();
    QualType vartype = Decl->getType();
    llvm::outs() << "{:kind Parm " 
		 << " :name " << "\"" << varname  << "\""
      //<< "local :scope " // 引数はlocalとして扱うため非表示
		 << " :type " << "\"" << getTypeInfo(vartype) << "\"}";
    return true;
  }

  // RecordDecl (Structure?)
  /*bool TraverseRecordDecl(RecordDecl *record) {
   if (linefeedflag == 0) {
      linefeedflag = 1;
    } else {
      llvm::outs() << "\n";
    }
    llvm::outs() << "[";
    RecursiveASTVisitor::TraverseRecordDecl(record);
    llvm::outs() << "]";
    return true;
    }*/
  bool VisitRecordDecl(RecordDecl *record) {
    llvm::outs() << "{:kind Struct "
		 << " :name" << "\"" << record->getName() << "\"}";
    return true;
  }

  // VarDecl
  /*bool TraverseVarDecl(VarDecl *Decl) {
    if (linefeedflag == 0) {
      linefeedflag = 1;
    } else {
      llvm::outs() << "\n";
    }
    llvm::outs() << "[";
    RecursiveASTVisitor::TraverseVarDecl(Decl);
    llvm::outs() << "]";
    return true;
    }*/
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
    llvm::outs() << " :type" << " \"" << getTypeInfo(vartype) << "\"}";
    return true;
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
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::CaseStmtClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::CompoundStmtClass: 
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::ContinueStmtClass:
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::DeclStmtClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::DefaultStmtClass:
	llvm::outs() << "\n";
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::DoStmtClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::ForStmtClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::GotoStmtClass:
	llvm::outs() << "\n";
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::IfStmtClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::LabelStmtClass:
	llvm::outs() << "\n";
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::SwitchStmtClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::WhileStmtClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::ReturnStmtClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
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
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::CallExprClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	FuncCall = 1;
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::DeclRefExprClass:
	if (FuncCall == 1 || ArraySub == 1) {
	  FuncCall = 0;
	  ArraySub = 0;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
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
      case Stmt::ParenExprClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::UnaryOperatorClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::BinaryOperatorClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::CStyleCastExprClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::MemberExprClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::UnaryExprOrTypeTraitExprClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::IntegerLiteralClass:
	llvm::outs() << "\n";
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::FloatingLiteralClass:
	llvm::outs() << "\n";
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::CharacterLiteralClass:
	llvm::outs() << "\n";
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::StringLiteralClass:
	llvm::outs() << "\n";
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
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
   llvm::outs() << "{:kind \"Break\"}";
    return true;
  }
 
  // CaseStmt
  bool VisitCaseStmt(CaseStmt *Case) {
    llvm::outs() << "{:kind \"Case\"}";
    return true;
  }

  // ContinueStmt
  bool VisitContinueStmt(ContinueStmt *Continue) {
    llvm::outs() << "{:kind \"Continue\"}";
    return true;
  } 
  
  // DefaultStmt
  bool VisitDefaultStmt(DefaultStmt *Default) {
    llvm::outs() << "{:kind \"Default\"}";
    return true;
  }

  // DoStmt
  bool VisitDoStmt(DoStmt *Do) {
    llvm::outs() << "{:kind \"Do\"}";
    return true;
  }

  // ForStmt
  bool VisitForStmt(ForStmt *For) {
    llvm::outs() << "{:kind \"For\""
		 << "\n :init [";
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
    TraverseStmt(For->getBody());
    llvm::outs() << "]}";
    return false;
  }

  // GotoStmt
  bool VisitGotoStmt(GotoStmt *Goto) {
    NamedDecl *label = dyn_cast<NamedDecl>(Goto->getLabel());
    llvm::outs() << "{:kind \"Goto\""
		 << " :label " << "\"" << label->getName() << "\"}";
    return true;
  }

  // IfStmt
  bool VisitIfStmt(IfStmt *If) {
    llvm::outs() << "{:kind \"If\""
		 << "\n :condition ";
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
    llvm::outs() << "{:kind \"Label\""
		 << " :name"<< "\"" << Label->getName() << "\"}";
    return true;
  }

  // SwitchStmt
  bool VisitSwitchStmt(SwitchStmt *Switch) {
    llvm::outs() << "{:kind \"Switch\"}";
    return true;
  }
  
  // WhileStmt
  bool VisitWhileStmt(WhileStmt *While) {
    llvm::outs() << "{:kind \"While\""
		 << "\n :condition ";
    linefeedflag = 0;
    TraverseStmt(While->getCond());
    llvm::outs() << "\n :body [";
    linefeedflag = 0;
    TraverseStmt(While->getBody());
    llvm::outs() << "]}";
    return false;
  }
 
  // ReturnStmt
  bool VisitReturnStmt(ReturnStmt *Ret) {
    // 型情報が不安(void型関数で...)
    if (Ret->getRetValue()) {
      QualType rettype = (Ret->getRetValue())->getType();
      llvm::outs() << "{:kind \"Ret\""
		   << " :type "<< "\"" << getTypeInfo(rettype) << "\"}";
    } else {
      llvm::outs() << "{:kind \"Ret\""
		   << " :type "<< "\"void\"}";
    }
    return true;
  }

  // ArraySubscriptExpr
  bool VisitArraySubscriptExpr(ArraySubscriptExpr *arrsub) {
    TraverseStmt(arrsub->getLHS());
    llvm::outs() << "\n[";
    llvm::outs() << "{:kind \"Index\"}";
    TraverseStmt(arrsub->getRHS()); 
    llvm::outs() << "]";
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
      llvm::outs() << " :type " << "\"" << getTypeInfo(vartype) << "\"}";
    } else if (funcdecl) {// 関数の場合
      QualType functype = funcdecl->getType();
      std::string Declreftype = funcdecl->getResultType().getAsString();
      llvm::outs() << "{:kind \"DRE\"" 
		   << " :name " << "\"" << Declref->getNameInfo() << "\"" 
		   << " :type " << "\"" << getTypeInfo(functype) << "\"";
      llvm::outs() << "\n :Parm [";
      if (funcdecl->param_size()) {
	linefeedflag = 0;
	for (int i = 0; i < (int)funcdecl->param_size(); i++) {
	  TraverseDecl(funcdecl->getParamDecl(i));
	}
      }
      llvm::outs() << "]}";
    }
     return true;
  }

  // MemberExpr
  bool VisitMemberExpr(MemberExpr *mem) {
    Expr *base = mem->getBase();
    ValueDecl *vdecl = mem->getMemberDecl();
    if(mem->isArrow()) {
      llvm::outs() << "{:kind \"Binop\" :op \"->\"}";
      getlhsArrow(base);
      getrhsArrow(vdecl); 
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
	llvm::outs() << "\n[";
	VisitDeclRefExpr(def);
	llvm::outs() << "]";
      }
    }
    return true;
  }
  bool getrhsArrow(ValueDecl *vdecl) {
    QualType vartype = vdecl->getType();
    llvm::outs() << "\n[{:kind \"DRE\""
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
    llvm::outs() << " :type "<< "\"" << getTypeInfo(vartype) << "\"}]";
    return true;
  }
  
  // UnaryOperator
  bool VisitUnaryOperator(UnaryOperator *Unop) {
    UnaryOperator::Opcode opcode = Unop->getOpcode();
    llvm::outs() << "{:kind \"Unop\""
		 << " :op " << "\"" << Unop->getOpcodeStr(opcode) << "\"}";
    return true;
  }

  // BinaryOperator
  bool VisitBinaryOperator(BinaryOperator *Binop) {
    llvm::outs() << "{:kind \"Binop\"" 
		 << " :op " << "\"" << Binop->getOpcodeStr() << "\"}";
    return true;
  }

  // IntegerLiteral
  bool VisitIntegerLiteral(IntegerLiteral *Int) {
    // ここの場合分けを見なおす必要あり, いるとこできえてる(ifの条件のとこにIntegerliteralが現れる場合に変になる場合がある)
    if (ArrayFlag == 1) {
      ArrayFlag = 0;
      return true;
    }
    llvm::outs() << "{:kind \"INT\""
		 << " :value " << "\"" << Int->getValue() << "\"}";
    return true;
  }

  // FloatingLiteral
  bool VisitFloatingLiteral(FloatingLiteral *Float) {
    llvm::outs() << "{:kind \"FLOAT\""
		 << " :value " << "\"" << Float->getValueAsApproximateDouble() << "\"}";
    return true;
  }

  // CharacterLiteral
  bool VisitCharacterLiteral(CharacterLiteral *Char) {
    llvm::outs() << "{:kind \"CHAR\""
		 << " :value " << "\"" << char(Char->getValue()) << "\"}";
    return true;
  }

  // StringLiteral
  bool VisitStringLiteral(StringLiteral *String) {
    llvm::outs() << "{:kind \"STRING\""
		 << " :value " << "\"" << String->getString().str() << "\"}";
    return true;
  }						  
  
private:
  ASTContext *Context;
  std::string last_func;
  std::string source_file;
  unsigned paramsize;
  int linefeedflag;
  int ArrayFlag;
  int FuncCall;
  int ArraySub;
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
