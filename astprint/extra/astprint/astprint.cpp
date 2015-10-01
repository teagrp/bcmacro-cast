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
  
  //bool VisitCallExpr(CallExpr *cexpr) {
    //FullSourceLoc FullLocation = Context->getFullLoc(cexpr->getLocStart());
  //llvm::outs() << "call, " 
  //	       << last_func << ", " 
  //	       << getFunctionName(cexpr->getCallee()) << ", "
  //	       << FullLocation.getManager().getFilename(FullLocation) << ", " 
  //	       << FullLocation.getSpellingLineNumber() << ", "
  //	       << FullLocation.getSpellingColumnNumber();
  //for (clang::CallExpr::arg_iterator iter = cexpr->arg_begin(); iter != cexpr->arg_end(); ++iter) {
    //llvm::outs() <<  ", \"" << toString(*iter) << "\"";
  //}
  //llvm::outs() << "\n";
  
  //return true;
  //}

  // FunctionDecl
  bool TraverseFunctionDecl(FunctionDecl *Decl) {
    if (linefeedflag == 0) {
      linefeedflag = 1;
    } else {
      llvm::outs() << "\n";
    }
    llvm::outs() << "[";
    RecursiveASTVisitor::TraverseFunctionDecl(Decl);
    llvm::outs() << "]";
    return true; 
  }
  bool VisitFunctionDecl(FunctionDecl *Decl) {
    last_func = Decl->getQualifiedNameAsString();
    std::string functype = Decl->getResultType().getAsString();
    //FullSourceLoc loc[2] = {
    //Context->getFullLoc(Decl->getSourceRange().getBegin()), 
    //Context->getFullLoc(Decl->getSourceRange().getEnd()) };
    llvm::outs() << "{Func :kind "
		 << last_func << " :name "
		 <<functype << " :type}";
    //<< (Decl->getStorageClass() == SC_Static? ",static,": ",global,") 
    //<< loc[0].getManager().getFilename(loc[0]) << ", " 
    // << loc[0].getSpellingLineNumber() << ", "         
    // << loc[1].getSpellingLineNumber();
    return true;
  }

  // ParmVarDecl
  bool VisitParmVarDecl(ParmVarDecl *Decl) {
    std::string varname = Decl->getNameAsString();
    std::string vartype = Decl->getType().getAsString();
    llvm::outs() << "\n{Parm :kind " 
		 << varname << " :name " 
      //<< "local :scope " // 引数はlocalとして扱うため非表示
		 << vartype << " :type}";
    return true;
  }

  // VarDecl
  bool TraverseVarDecl(VarDecl *Decl) {
    if (linefeedflag == 0) {
      linefeedflag = 1;
    } else {
      llvm::outs() << "\n";
    }
    llvm::outs() << "[";
    RecursiveASTVisitor::TraverseVarDecl(Decl);
    llvm::outs() << "]";
    return true;
  }
  bool VisitVarDecl(VarDecl *Decl) {
    if (Decl->getKind() == 50) {
      return true;
    }
    std::string varname = Decl->getNameAsString();
    std::string vartype = Decl->getType().getAsString();
    llvm::outs() << "{Var :kind " 
		 << varname << " :name " 
		 << (Decl->isFileVarDecl() == 1? "global":"local") << " :scope "
		 << vartype << " :type}";
    return true;
  }

  // IntegerLiteral
  bool VisitIntegerLiteral(IntegerLiteral *Int) {
    llvm::outs() << "{INT :kind "
		 << Int->getValue() << " :value}";
    return true;
  }

  // FloatingLiteral
  bool VisitFloatingLiteral(FloatingLiteral *Float) {
    llvm::outs() << "{FLOAT :kind "
		 << Float->getValueAsApproximateDouble() << " :value}";
    return true;
  }

  // CharacterLiteral
  bool VisitCharacterLiteral(CharacterLiteral *Char) {
    llvm::outs() << "{CHAR :kind "
		 << char(Char->getValue()) << " :value}";
    return true;
  }

  // stmt : Binop, ReturnStmt, forstmt, ifstmt, ... etc
  // *Stmt, *Expr をカバーしていると思う
  bool TraverseStmt(Stmt *stmt) {
     if (stmt != NULL){
       //llvm::outs() << "\nenter " << stmt->getStmtClassName() << "\n";
      switch (stmt->getStmtClass()) {
      case Stmt::CompoundStmtClass: 
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::DeclStmtClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
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
      case Stmt::CallExprClass:
	if (linefeedflag == 0) {
	  linefeedflag = 1;
	} else {
	  llvm::outs() << "\n";
	}
	llvm::outs() << "[";	
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::DeclRefExprClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::ImplicitCastExprClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
	//      case Stmt::BinaryOperatorClass:
	//	if (BinaryOperator *binop = dyn_cast<BinaryOperator>(stmt)) {
	//	  TraverseBinaryOperator(binop);
	//	} else {
	//	  RecursiveASTVisitor::TraverseStmt(stmt);
	//	}
	//	break;
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
      case Stmt::IntegerLiteralClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::FloatingLiteralClass:
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::CharacterLiteralClass:
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

  /*
  bool TraverseBinaryOperator(BinaryOperator *Binop) {
    if (linefeedflag == 0) {
      linefeedflag = 1;
    } else {
      llvm::outs() << "\n";
    }
    llvm::outs() << "[";
    VisitBinaryOperator(Binop);
    TraverseStmt(Binop->getLHS());
    TraverseStmt(Binop->getRHS());
    llvm::outs() << "]";
    return true;
  }
  */
  bool VisitBinaryOperator(BinaryOperator *Binop) {
    //llvm::outs() << Binop->getRHS() << ", " << dyn_cast<Stmt>(Binop->getRHS())->getStmtClassName() << ", " << Binop;
    llvm::outs() << "{Binop :kind " 
		 << Binop->getOpcodeStr() << " :op}"; 
    return true;
  }
  
  // DeclRefExpr
  //bool TraverseDeclRefExpr(DeclRefExpr *Declref) {
  //RecursiveASTVisitor::TraverseDeclRefExpr(Declref);
  //return true;
  //}
  bool VisitDeclRefExpr(DeclRefExpr *Declref) {
    ValueDecl *valuedecl = Declref->getDecl();
    VarDecl *vardecl = dyn_cast<VarDecl>(valuedecl);
    FunctionDecl *funcdecl = dyn_cast<FunctionDecl>(valuedecl);
    std::string scope = "";
    if (vardecl) {// 変数の場合
      scope = (vardecl->isFileVarDecl() == 1? "global":"local");
      std::string Declreftype = Declref->getType().getAsString();
      llvm::outs() << "\n{Var :kind " 
		   << Declref->getNameInfo() << " :name "
		   << scope << " :scope "
		   << Declreftype << " :type}";
    } else if (funcdecl) {// 関数の場合
      std::string Declreftype = funcdecl->getResultType().getAsString();
      llvm::outs() << "{CallFunc :kind " 
		   << Declref->getNameInfo() << " :name "
		   << Declreftype << " :type}";
    }
     return true;
  }

  // ReturnStmt
  bool VisitReturnStmt(ReturnStmt *Ret) {
    std::string rettype = (Ret->getRetValue())->getType().getAsString();
    llvm::outs() << "{Ret :kind "
		 << rettype << " :type}";
    return true;
  }

private:
  ASTContext *Context;
  std::string last_func;
  std::string source_file;
  unsigned paramsize;
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
