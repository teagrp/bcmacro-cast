#include <stack>
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
  // TraverseDecl
  bool TraverseDecl(Decl *decl) {
    if (decl != NULL){
      //llvm::outs() << " ?Decl? " << decl->getDeclKindName();
      switch (decl->getKind()) {
      case Decl::Field:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
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
	casetoji = 0;
	castflag = 0;
	pointflag = 0;
	firsttype = 0;
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
      case Decl::Enum:
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::EnumConstant:
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
	//以下c++関係のもの
      case Decl::ClassTemplate:
      case Decl::CXXRecord:
      case Decl::CXXMethod:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      case Decl::ClassTemplateSpecialization:
	//RecursiveASTVisitor::TraverseDecl(decl);
	//	llvm::outs() << " ?Decl? " << decl->getDeclKindName();
	break;
      case Decl::ClassTemplatePartialSpecialization:
      case Decl::CXXConstructor:
      case Decl::CXXConversion:
      case Decl::CXXDestructor:
      case Decl::Empty:
      case Decl::FunctionTemplate:
      case Decl::LinkageSpec:
      case Decl::Namespace:
      case Decl::NonTypeTemplateParm:
      case Decl::TemplateTypeParm:
      case Decl::Using:
      case Decl::UsingDirective:
      case Decl::UsingShadow:
	//llvm::outs() << " ?Decl? " << decl->getDeclKindName();
	RecursiveASTVisitor::TraverseDecl(decl);
	break;
      default :
	llvm::outs() << " ?Decl? " << decl->getDeclKindName();
	RecursiveASTVisitor::TraverseDecl(decl);
      }
    }
    return true;
  }
  
  // ClassTemplate
  bool VisitClassTemplateDecl(ClassTemplateDecl *ctdecl) {
    llvm::outs() << "{:kind \"ClassTemplate\"";
    llvm::outs() << " :Template ";
    TraverseDecl(ctdecl->getTemplatedDecl());
    llvm::outs() << "}";
    return false;
  }

  //
  // FieldDecl (Structure Member) 
  bool VisitFieldDecl(FieldDecl *field) {
    QualType fieldtype = field->getType();
    if (labelflag != 0) {
      os << "{:kind \"Field\""
	 << " :name " << "\"" << (std::string)field->getName() << "\""
	 << " :scope " << "\"member\"";
      os << " :type [";
      firsttype = 0;
      PrintTypeInfo(fieldtype);
      checkCast();
      os << "]";
      PrintSourceRange(field->getSourceRange());
      os << "}";
      caselabel += os.str();
      os.str("");
      os.clear();
    } else {
      llvm::outs() << "{:kind \"Field\""
		   << " :name " << "\"" << field->getName() << "\""
		   << " :scope " << "\"member\"";
      llvm::outs() << " :type [";
      firsttype = 0;
      PrintTypeInfo(fieldtype);
      checkCast();
      llvm::outs() << "]";
      PrintSourceRange(field->getSourceRange());
      llvm::outs() << "}";
    }
    return false;
  }
  
  // FunctionDecl
  bool VisitFunctionDecl(FunctionDecl *Decl) {
    if (dyn_cast<CXXMethodDecl>(Decl)) {
      CXXMethodDecl *method = dyn_cast<CXXMethodDecl>(Decl);
      last_func = method->getQualifiedNameAsString();
      QualType functype = method->getResultType();
      llvm::outs() << "{:kind \"Method\""
		   << " :name " << "\"" << last_func << "\"";
      checkSpecifier(method->getStorageClass());
      llvm::outs() << " :type [";
      firsttype = 0;
      PrintTypeInfo(functype);
      checkCast();
      llvm::outs() << "]";
      PrintSourceRange(method->getSourceRange());
      llvm::outs() << "\n :Parm [";
      if (method->param_size()) {
	linefeedflag = 0;
	for (int i = 0; i < (int)method->param_size(); i++) {
	  TraverseDecl(method->getParamDecl(i));
	}
      }
      llvm::outs() << "]\n :body [";
      linefeedflag = 0;
      linefeedbody = 0;
      TraverseStmt(method->getBody());
      llvm::outs() << "]}";
    } else {
      last_func = Decl->getQualifiedNameAsString();
      QualType functype = Decl->getType();
      llvm::outs() << "{:kind \"Funcdef\""
		   << " :name " << "\"" << last_func << "\"";
      checkSpecifier(Decl->getStorageClass());
      llvm::outs() << " :type [";
      firsttype = 0;
      PrintTypeInfo(functype);
      checkCast();
      llvm::outs() << "]";
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
    }
    return false;
  }

  // ParmVarDecl
  bool VisitParmVarDecl(ParmVarDecl *Decl) {
    std::string varname = Decl->getNameAsString();
    QualType vartype = Decl->getType();
    llvm::outs() << "{:kind \"Parm\"" 
		 << " :name " << "\"" << varname  << "\"";
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(vartype);
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(Decl->getSourceRange());
    llvm::outs() << "}";
    return true;
  }

  // RecordDecl (Structure?)
  bool VisitRecordDecl(RecordDecl *record) {
    std::string recordkind;
    if (record->isStruct()) {
      recordkind = "\"Structdef\"";
    } else if (record->isUnion()) {
      recordkind = "\"Uniondef\"";
    } else if (record->isClass()) {//C++
      CXXRecordDecl *cxxrecord = dyn_cast<CXXRecordDecl>(record);
      llvm::outs() << "{:name " << "\"" << (std::string)record->getName() << "\"";
      PrintSourceRange(record->getSourceRange()); 
      llvm::outs() << "\n :Member [";
      linefeedflag = 0;
      if (!(record->field_empty())) {
	RecordDecl::field_iterator itr = record->field_begin();
	while (itr != record->field_end()) {
	  TraverseDecl(itr->getCanonicalDecl());
	  itr++;
	} 
      }
      if (cxxrecord->method_begin() != cxxrecord->method_end()) {
	CXXRecordDecl::method_iterator mitr = cxxrecord->method_begin();
	while (mitr != cxxrecord->method_end()) {
	  TraverseDecl(mitr->getCanonicalDecl());
	  mitr++;
	}
      }
      llvm::outs() << "]}";
    }
    if (!(record->isClass())) {
      llvm::outs() << "{:kind " << recordkind
		   << " :name " << "\"" << (std::string)record->getName() << "\"";
      PrintSourceRange(record->getSourceRange()); 
      llvm::outs() << "\n :Member [";
      linefeedflag = 0;
      if (!(record->field_empty())) {
	RecordDecl::field_iterator itr = record->field_begin();
	while (itr != record->field_end()) {
	  TraverseDecl(itr->getCanonicalDecl());
	  itr++;
	} 
      }
    llvm::outs() << "]}";
    }
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
    checkSpecifier(Decl->getStorageClass());
    PrintDisplayType(vartype);
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(vartype);
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(Decl->getSourceRange());
    if (Decl->hasInit()) {
      llvm::outs() << "\n :init ";
      linefeedflag = 0;
      TraverseStmt(Decl->getInit());
    }
    llvm::outs() << "}";
    return false;
  }
  
  // 指定子:specifire::=(register, static, extern)
  void checkSpecifier(StorageClass SC) {
    if (labelflag != 0) {
      switch(SC) {
      case SC_Extern:
	os << " :Extern true";
	break;
      case SC_Static:
	os << " :Static true";
	break;
      case SC_Auto:
	os << " :Auto true";
	break;
      case SC_Register:
	os << " :Register true";
	break;
      case SC_None:
      case SC_PrivateExtern:
      case SC_OpenCLWorkGroupLocal:
      default:
	break;
      }
      caselabel += os.str();
      os.str("");
      os.clear();
    } else if (castflag != 0) {
      switch(SC) {
      case SC_Extern:
	cast << " :Extern true";
	break;
      case SC_Static:
	cast << " :Static true";
	break;
      case SC_Auto:
	cast << " :Auto true";
	break;
      case SC_Register:
	cast << " :Register true";
	break;
      case SC_None:
      case SC_PrivateExtern:
      case SC_OpenCLWorkGroupLocal:
      default:
	break;
      }
      castlabel += cast.str();
      cast.str("");
      cast.clear();
    } else {
      switch(SC) {
      case SC_Extern:
	llvm::outs() << " :Extern \"true\"";
	break;
      case SC_Static:
	llvm::outs() << " :Static \"true\"";
	break;
      case SC_Auto:
	llvm::outs() << " :Auto \"true\"";
	break;
      case SC_Register:
	llvm::outs() << " :Register \"true\"";
	break;
      case SC_None:
      case SC_PrivateExtern:
      case SC_OpenCLWorkGroupLocal:
      default:
	break;
      }
    }
  }
  
  // typeを文字列として出力
  void PrintDisplayType(QualType typeInfo) {
    if (labelflag != 0 || castflag != 0) {
      os << " :DisplayType " << "\"" << typeInfo.getAsString() << "\"";
    } else {
      llvm::outs() << " :DisplayType " << "\"" << typeInfo.getAsString() << "\"";
    }
  }
 
  
  // :typeの情報を出力
  void PrintTypeInfo(QualType typeInfo) {
    firsttype++;
    std::string Typename;
    int flag = 0; // Unknwonの判定用
    if (dyn_cast<AutoType>(typeInfo)) {//c++{11/14}専用みたい...
      flag = 1;
      if (labelflag != 0) {
	os << " :Auto \"true\"";
	PrintQualifier(typeInfo);
	PrintTypeInfo(dyn_cast<AutoType>(typeInfo)->getDeducedType());
	caselabel += os.str();
	os.str("");
	os.clear();
      } else if (castflag != 0) {
	cast << " :Auto \"true\"";
	PrintQualifier(typeInfo);
	PrintTypeInfo(dyn_cast<AutoType>(typeInfo)->getDeducedType());
	castlabel += cast.str();
	cast.str("");
	cast.clear();
      } else {
	llvm::outs() << " :Auto \"true\"";
	PrintQualifier(typeInfo);
	PrintTypeInfo(dyn_cast<AutoType>(typeInfo)->getDeducedType());
      }
    }
    if (dyn_cast<TypedefType>(typeInfo)) {
      flag = 1;
      TypedefNameDecl *TDtype = dyn_cast<TypedefType>(typeInfo)->getDecl();
      if (labelflag != 0) {
	os << checkPointkey() 
	   << "{:kind \"Typedef-type\"" 
	   << " :typename " << "\"" << (std::string)TDtype->getName() << "\"";
	PrintQualifier(typeInfo);
	PrintTypeInfo(TDtype->getUnderlyingType());
	os << "}";
	caselabel += os.str();
	os.str("");
	os.clear();
      } else if (castflag != 0) {
	cast << checkPointkey() 
	   << "{:kind \"Typedef-type\"" 
	   << " :typename " << "\"" << (std::string)TDtype->getName() << "\"";
	PrintQualifier(typeInfo);
	PrintTypeInfo(TDtype->getUnderlyingType());
	cast << "}";
	castlabel += cast.str();
	cast.str("");
	cast.clear();
      } else {
	llvm::outs() << checkPointkey() 
		     << "{:kind \"Typedef-type\"" 
		     << " :typename " << "\"" << TDtype->getName() << "\"";
	PrintQualifier(typeInfo);
	PrintTypeInfo(TDtype->getUnderlyingType());
	llvm::outs() << "}";
      }
    }
    if (dyn_cast<BuiltinType>(typeInfo)) {
      flag = 1;
      switch (dyn_cast<BuiltinType>(typeInfo)->getKind()) {
      case BuiltinType::Void:
	Typename = "Void";
	break;
      case BuiltinType::Bool:
	Typename = "Bool";
	break;
      case BuiltinType::UChar:
	Typename = "UnsignedChar";
	break;
      case BuiltinType::UShort:
	Typename = "UnsignedShort";
	break;
      case BuiltinType::UInt:
	Typename = "UnsignedInt";
	break;
      case BuiltinType::ULong:
	Typename = "UnsignedLong";
	break;
      case BuiltinType::ULongLong:
	Typename = "UnsigndLongLong";
	break;
      case BuiltinType::Char_S:
	Typename = "Char";
	break;
      case BuiltinType::SChar:
	Typename = "SignedChar";
	break;
      case BuiltinType::Short:
	Typename = "Short";
	break;
      case BuiltinType::Int:
	Typename = "Int";
	break;
      case BuiltinType::Long:
	Typename = "Long";
	break;
      case BuiltinType::LongLong:
	Typename = "LongLong";
	break;
      case BuiltinType::Float:
	Typename = "Float";
	break;
      case BuiltinType::Double:
	Typename = "Double";
	break;
      case BuiltinType::LongDouble:
	Typename = "LongDouble";
	break;
	//以下c++に関するもの
      case BuiltinType::WChar_S:
      case BuiltinType::WChar_U:
	Typename = "WChar_t";
	break;
      case BuiltinType::Dependent:
	Typename = "Dependent";
	break;
      default:
	Typename = "UnKnownError";
	llvm::outs() << "\n \""<< typeInfo.getAsString() << "\"は, 初出です."
		     << " astprint.cppのPrintTypeInfoにcaseを追加して下さい.";
	break;
      }
      if (labelflag != 0) {
	os << checkPointkey()
	   << "{:kind \"" << Typename << "-type\"";
	PrintQualifier(typeInfo);
	os << "}";
	caselabel += os.str();
	os.str("");
	os.clear();
      } else if (castflag != 0) {
	cast << checkPointkey()
	   << "{:kind \"" << Typename << "-type\"";
	PrintQualifier(typeInfo);
	cast << "}";
	castlabel += cast.str();
	cast.str("");
	cast.clear();
      } else {
	llvm::outs() << checkPointkey()
		     << "{:kind \"" << Typename << "-type\"";
	PrintQualifier(typeInfo);
	llvm::outs() << "}";
      }
    }
    if (typeInfo->isFunctionType()) {
      flag = 1;
      if (labelflag != 0) {
	os <<  checkPointkey()
	   << "{:kind \"Func-type\""
	   << " :ParmsType [";
	if (dyn_cast<FunctionProtoType>(typeInfo)) {
	  unsigned parms = dyn_cast<FunctionProtoType>(typeInfo)->getNumArgs();
	  if (parms != 0) {
	    unsigned i = 0;
	    while (i < parms) {
	      firsttype = 0;
	      if (i != 0) {
		os << " ";
	      }
	      PrintTypeInfo(dyn_cast<FunctionProtoType>(typeInfo)->getArgType(i));
	      i++;
	    }
	  }
	}
	os << "]";
	if (dyn_cast<FunctionType>(typeInfo)) {
	  os << " :RetType ";
	  QualType rettype = dyn_cast<FunctionType>(typeInfo)->getResultType();
	  firsttype = 0;
	  PrintTypeInfo(rettype);
	} 
	os << "}";
	caselabel += os.str();
	os.str("");
	os.clear();
      } else if (castflag != 0) {
	cast <<  checkPointkey()
	     << "{:kind \"Func-type\""
	     << " :ParmsType [";
	if (dyn_cast<FunctionProtoType>(typeInfo)) {
	  unsigned parms = dyn_cast<FunctionProtoType>(typeInfo)->getNumArgs();
	  if (parms != 0) {
	    unsigned i = 0;
	    while (i < parms) {
	      firsttype = 0;
	      if (i != 0) {
		cast << " ";
	      }
	      PrintTypeInfo(dyn_cast<FunctionProtoType>(typeInfo)->getArgType(i));
	      i++;
	    }
	  }
	}
	cast << "]";
	if (dyn_cast<FunctionType>(typeInfo)) {
	  cast << " :RetType ";
	  QualType rettype = dyn_cast<FunctionType>(typeInfo)->getResultType();
	  firsttype = 0;
	  PrintTypeInfo(rettype);
	} 
	cast << "}";
	castlabel += cast.str();
	cast.str("");
	cast.clear();
      } else {
	llvm::outs() <<  checkPointkey()
		     << "{:kind \"Func-type\""
		     << " :ParmsType [";
	if (dyn_cast<FunctionProtoType>(typeInfo)) {
	  unsigned parms = dyn_cast<FunctionProtoType>(typeInfo)->getNumArgs();
	  if (parms != 0) {
	    unsigned i = 0;
	    while (i < parms) {
	      firsttype = 0;
	      if (i != 0) {
		llvm::outs() << " ";
	      }
	      PrintTypeInfo(dyn_cast<FunctionProtoType>(typeInfo)->getArgType(i));
	      i++;
	    }
	  }
	}
	llvm::outs() << "]";
	if (dyn_cast<FunctionType>(typeInfo)) {
	  llvm::outs() << " :RetType ";
	  QualType rettype = dyn_cast<FunctionType>(typeInfo)->getResultType();
	  firsttype = 0;
	  PrintTypeInfo(rettype);
	} 
	llvm::outs() << "}";
      }
    }
    if (typeInfo->isArrayType()) {
      flag = 1;
      QualType elmtype;
      if (dyn_cast<ArrayType>(typeInfo)) {
	elmtype = dyn_cast<ArrayType>(typeInfo)->getElementType();
	if (labelflag != 0) {
	  os << checkPointkey()
	     << "{:kind \"Array-type\"";		   
	  if (dyn_cast<ConstantArrayType>(typeInfo)) {
	    os << " :Arraysize \"" 
	       << dyn_cast<ConstantArrayType>(typeInfo)->getSize().toString(10, true) << "\"";
	  }
	  if (dyn_cast<VariableArrayType>(typeInfo)) {
	    Expr *vaexpr = dyn_cast<VariableArrayType>(typeInfo)->getSizeExpr();
	    os << " :ArraySizeExpression ";
	    linefeedflag = 0;
	    TraverseStmt(vaexpr);
	  }
	  PrintQualifier(typeInfo);
	  os << " :type [";
	  PrintTypeInfo(elmtype);
	  os << "]}";
	  caselabel += os.str();
	  os.str("");
	  os.clear();
	} else if (castflag != 0) {
	  cast << checkPointkey()
	     << "{:kind \"Array-type\"";		   
	  if (dyn_cast<ConstantArrayType>(typeInfo)) {
	    cast << " :Arraysize \"" 
	       << dyn_cast<ConstantArrayType>(typeInfo)->getSize().toString(10, true) << "\"";
	  }
	  if (dyn_cast<VariableArrayType>(typeInfo)) {
	    Expr *vaexpr = dyn_cast<VariableArrayType>(typeInfo)->getSizeExpr();
	    cast << " :ArraySizeExpression ";
	    linefeedflag = 0;
	    TraverseStmt(vaexpr);
	  }
	  PrintQualifier(typeInfo);
	  cast << " :type [";
	  PrintTypeInfo(elmtype);
	  cast << "]}";
	  castlabel += cast.str();
	  cast.str("");
	  cast.clear();
	} else {
	  llvm::outs() << checkPointkey()
		       << "{:kind \"Array-type\"";		   
	  if (dyn_cast<ConstantArrayType>(typeInfo)) {
	    llvm::outs() << " :ArraySize \"" 
			 << dyn_cast<ConstantArrayType>(typeInfo)->getSize() << "\"";
	  }
	  if (dyn_cast<VariableArrayType>(typeInfo)) {
	    Expr *vaexpr = dyn_cast<VariableArrayType>(typeInfo)->getSizeExpr();
	    llvm::outs() << " :ArraySizeExpression ";
	    linefeedflag = 0;
	    TraverseStmt(vaexpr);
	  }
	  PrintQualifier(typeInfo);
	  llvm::outs() << " :type [";
	  PrintTypeInfo(elmtype);
	  llvm::outs() << "]}";
	}
      }
      if (dyn_cast<ParenType>(typeInfo)) {
	elmtype = dyn_cast<ParenType>(typeInfo)->getInnerType();
	PrintTypeInfo(elmtype);
      }
    }
    if (typeInfo->isPointerType()) {
      flag = 1;
      if (dyn_cast<PointerType>(typeInfo)) {
	std::string key = checkPointkey();
	pointflag = 1;
	QualType elmtype = dyn_cast<PointerType>(typeInfo)->getPointeeType();
	if (labelflag != 0) {
	  os << key
	     << "{:kind \"Pointer-type\"";
	  PrintQualifier(typeInfo);
	  PrintTypeInfo(elmtype);
	  os << "}";
	  caselabel += os.str();
	  os.str("");
	  os.clear();
	} else if (castflag != 0) {
	  cast << key
	     << "{:kind \"Pointer-type\"";
	  PrintQualifier(typeInfo);
	  PrintTypeInfo(elmtype);
	  cast << "}";
	  castlabel += cast.str();
	  cast.str("");
	  cast.clear();
	} else {
	  llvm::outs() << key
		       << "{:kind \"Pointer-type\"";
	  PrintQualifier(typeInfo);
	  PrintTypeInfo(elmtype);
	  llvm::outs() << "}";
	}
      }
    }
    if (typeInfo->isStructureType()) {
      flag = 1;
      if (labelflag != 0) {
	if (dyn_cast<ElaboratedType>(typeInfo)) {
	  QualType etype = dyn_cast<ElaboratedType>(typeInfo)->getNamedType();
	  PrintTypeInfo(etype);
	} 
	if (dyn_cast<RecordType>(typeInfo)) {
	  RecordDecl *rdecl = dyn_cast<RecordType>(typeInfo)->getDecl();
	  os << checkPointkey()
	     << "{:kind \"Structure-type\"";
	  PrintQualifier(typeInfo);
	  os << " :name" << " \"" << (std::string)rdecl->getName() << "\"";
	  if (rdecl->getName() == "") {
	    os << "\n :member[";
	    linefeedflag = 0;
	    if (!(rdecl->field_empty())) {
	      RecordDecl::field_iterator itr = rdecl->field_begin();
	      while (itr != rdecl->field_end()) {
		TraverseDecl(itr->getCanonicalDecl());
		itr++;
	      } 
	    }
	    os << "]";
	  }
	  os << "}";
	}
	caselabel += os.str();
	os.str("");
	os.clear();
      } else if (castflag != 0) {
	if (dyn_cast<ElaboratedType>(typeInfo)) {
	  QualType etype = dyn_cast<ElaboratedType>(typeInfo)->getNamedType();
	  PrintTypeInfo(etype);
	} 
	if (dyn_cast<RecordType>(typeInfo)) {
	  RecordDecl *rdecl = dyn_cast<RecordType>(typeInfo)->getDecl();
	  cast << checkPointkey()
	     << "{:kind \"Structure-type\"";
	  PrintQualifier(typeInfo);
	  cast << " :name" << " \"" << (std::string)rdecl->getName() << "\"";
	  if (rdecl->getName() == "") {
	    cast << "\n :member[";
	    linefeedflag = 0;
	    if (!(rdecl->field_empty())) {
	      RecordDecl::field_iterator itr = rdecl->field_begin();
	      while (itr != rdecl->field_end()) {
		TraverseDecl(itr->getCanonicalDecl());
		itr++;
	      } 
	    }
	    cast << "]";
	  }
	  cast << "}";
	}
	castlabel += cast.str();
	cast.str("");
	cast.clear();
      } else {
	if (dyn_cast<ElaboratedType>(typeInfo)) {
	  QualType etype = dyn_cast<ElaboratedType>(typeInfo)->getNamedType();
	  if (firsttype == 1) { 
	    firsttype = 0;
	  }
	  PrintTypeInfo(etype);
	} 
	if (dyn_cast<RecordType>(typeInfo)) {
	  llvm::outs() << checkPointkey()
		       << "{:kind \"Structure-type\"";
	  PrintQualifier(typeInfo);
	  RecordDecl *rdecl = dyn_cast<RecordType>(typeInfo)->getDecl();
	  llvm::outs() << " :name" << " \"" << rdecl->getName() << "\"";  
	  if (rdecl->getName() == "") {
	    llvm::outs() << "\n :member[";
	    linefeedflag = 0;
	    if (!(rdecl->field_empty())) {
	      RecordDecl::field_iterator itr = rdecl->field_begin();
	      while (itr != rdecl->field_end()) {
		TraverseDecl(itr->getCanonicalDecl());
		itr++;
	      } 
	    }
	    llvm::outs() << "]";
	  }
	  llvm::outs() << "}";
	}
      }
    }
    if (typeInfo->isUnionType()) {
      flag = 1;
      if (labelflag != 0) {
	if (dyn_cast<ElaboratedType>(typeInfo)) {
	  QualType etype = dyn_cast<ElaboratedType>(typeInfo)->getNamedType();
	  PrintTypeInfo(etype);
	} 
	if (dyn_cast<RecordType>(typeInfo)) {
	  RecordDecl *rdecl = dyn_cast<RecordType>(typeInfo)->getDecl();
	  os << checkPointkey()
	     << "{:kind \"Union-type\"";
	  PrintQualifier(typeInfo);
	  os << " :name" << " \"" << (std::string)rdecl->getName() << "\"";
	  if (rdecl->getName() == "") {
	    os << "\n :member[";
	    linefeedflag = 0;
	    if (!(rdecl->field_empty())) {
	      RecordDecl::field_iterator itr = rdecl->field_begin();
	      while (itr != rdecl->field_end()) {
		TraverseDecl(itr->getCanonicalDecl());
		itr++;
	      } 
	    }
	    os << "]";
	  }
	  os << "}";
	}
	caselabel += os.str();
	os.str("");
	os.clear();
      } else if (castflag != 0) {
	if (dyn_cast<ElaboratedType>(typeInfo)) {
	  QualType etype = dyn_cast<ElaboratedType>(typeInfo)->getNamedType();
	  PrintTypeInfo(etype);
	} 
	if (dyn_cast<RecordType>(typeInfo)) {
	  RecordDecl *rdecl = dyn_cast<RecordType>(typeInfo)->getDecl();
	  cast << checkPointkey()
	       << "{:kind \"Union-type\"";
	  PrintQualifier(typeInfo);
	  cast << " :name" << " \"" << (std::string)rdecl->getName() << "\"";
	  if (rdecl->getName() == "") {
	    cast << "\n :member[";
	    linefeedflag = 0;
	    if (!(rdecl->field_empty())) {
	      RecordDecl::field_iterator itr = rdecl->field_begin();
	      while (itr != rdecl->field_end()) {
		TraverseDecl(itr->getCanonicalDecl());
		itr++;
	      } 
	    }
	    cast << "]";
	  }
	  cast << "}";
	}
	castlabel += cast.str();
	cast.str("");
	cast.clear();
      } else {
	if (dyn_cast<ElaboratedType>(typeInfo)) {
	  QualType etype = dyn_cast<ElaboratedType>(typeInfo)->getNamedType();
	  PrintTypeInfo(etype);
	} 
	if (dyn_cast<RecordType>(typeInfo)) {
	  RecordDecl *rdecl = dyn_cast<RecordType>(typeInfo)->getDecl();
	  llvm::outs() << checkPointkey()
		       << "{:kind \"Union-type\"";
	  PrintQualifier(typeInfo);
	  llvm::outs() << " :name" << " \"" << rdecl->getName() << "\"";
	  if (rdecl->getName() == "") {
	    llvm::outs() << "\n :member [";
	    linefeedflag = 0;
	    if (!(rdecl->field_empty())) {
	      RecordDecl::field_iterator itr = rdecl->field_begin();
	      while (itr != rdecl->field_end()) {
		TraverseDecl(itr->getCanonicalDecl());
		itr++;
	      } 
	    }
	    llvm::outs() << "]";
	  }
	  llvm::outs() << "}";
	}
      }
    }
    if (flag == 0) {
      if (labelflag != 0) {
	os << checkPointkey()
	   << "{:kind \"Unknown-type\""
	   << " :typeString " << "\"" << typeInfo.getAsString() << "\"}";
	caselabel += os.str();
	os.str("");
	os.clear();
      } else if (castflag != 0) {
	cast << checkPointkey()
	   << "{:kind \"Unknown-type\""
	   << " :typeString " << "\"" << typeInfo.getAsString() << "\"}";
	castlabel += cast.str();
	cast.str("");
	cast.clear();
      } else {
	llvm::outs() << checkPointkey()
		     << "{:kind \"Unknown-type\""
		     << " :typeString " << "\"" << typeInfo.getAsString() << "\"}";
      }
    }
    firsttype = 0;
    //llvm::outs()  << " " << typeInfo->getTypeClassName();
  }
  
  std::string checkPointkey() {
    std::string result;
    if (firsttype == 1) {
      return "";
    }
    if (pointflag == 1) {
      result = " :Pointee ";
    } else {
      //result = " :type "; ->
      result = "";
    }
    pointflag = 0;
    return result;
  }

  void PrintQualifier(QualType Qual) {
    if (labelflag != 0) {
      if (Qual.isConstQualified()) {
	os << " :const " << "\"true\"";
      }
      if (Qual.isVolatileQualified()) {
	os << " :volatile " << "\"true\"";
      }
      caselabel += os.str();
      os.str("");
      os.clear();
    } else if (castflag != 0) {
      if (Qual.isConstQualified()) {
	cast << " :const " << "\"true\"";
      }
      if (Qual.isVolatileQualified()) {
	cast << " :volatile " << "\"true\"";
      }
      castlabel += cast.str();
      cast.str("");
      cast.clear();
    } else {
      if (Qual.isConstQualified()) {
	llvm::outs() << " :const " << "\"true\"";
      }
      if (Qual.isVolatileQualified()) {
	llvm::outs() << " :volatile " << "\"true\"";
      }
    }
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
	casetoji = 1;
	labelflag++;
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
	labelflag++;
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
	labelflag++;
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
	} else if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
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
	castflag = 1;
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
	castflag = 1;
	if (dyn_cast<ImplicitCastExpr>(stmt)->getSubExpr()->getStmtClass() == 68) {
	  llvm::outs() << "{:kind \"NULL\" :value \"Null\"}";
	  break;
	}
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      case Stmt::InitListExprClass:
	if (linefeedflag == 0 || linefeedbody == 0) {
	  linefeedflag = 1;
	  linefeedbody = 1;
	} else {
	  llvm::outs() << "\n";
	}
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
      case Stmt::ConditionalOperatorClass:
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
	//以下C++に関係
      case Stmt::CXXNewExprClass:
      case Stmt::CXXUnresolvedConstructExprClass:
      case Stmt::ParenListExprClass:
	llvm::outs() << "[";
	RecursiveASTVisitor::TraverseStmt(stmt);
	llvm::outs() << "]";
	break;
      case Stmt::CXXCatchStmtClass:
      case Stmt::CXXTryStmtClass:
      case Stmt::NullStmtClass:
      case Stmt::AtomicExprClass:
      case Stmt::CXXBindTemporaryExprClass:
      case Stmt::CXXBoolLiteralExprClass:
      case Stmt::CXXConstCastExprClass:
      case Stmt::CXXConstructExprClass:
      case Stmt::CXXDeleteExprClass:
      case Stmt::CXXDependentScopeMemberExprClass:
      case Stmt::CXXDynamicCastExprClass:
      case Stmt::CXXFunctionalCastExprClass:
      case Stmt::CXXMemberCallExprClass:
      case Stmt::CXXOperatorCallExprClass:
      case Stmt::CXXPseudoDestructorExprClass:
      case Stmt::CXXReinterpretCastExprClass:
      case Stmt::CXXScalarValueInitExprClass:
      case Stmt::CXXStaticCastExprClass:
      case Stmt::CXXThisExprClass:
      case Stmt::CXXThrowExprClass:
      case Stmt::DependentScopeDeclRefExprClass:
      case Stmt::GNUNullExprClass:
      case Stmt::MaterializeTemporaryExprClass:
      case Stmt::UnaryTypeTraitExprClass:
      case Stmt::UnresolvedLookupExprClass:
      case Stmt::UnresolvedMemberExprClass:
      case Stmt::ExprWithCleanupsClass:
	//llvm::outs() << "?Stmt? " << stmt->getStmtClassName();	
	RecursiveASTVisitor::TraverseStmt(stmt);
	break;
      default:
	llvm::outs() << "?Stmt? " << stmt->getStmtClassName();	
	RecursiveASTVisitor::TraverseStmt(stmt);
      }
      //llvm::outs() << "\nleave " << stmt->getStmtClassName() << "\n";
    }
    return true;
  }
  bool shouldUseDataRecursionFor(Stmt* S) const {
    return false;
  }
  
  // CXXBoolLiteralExpr
  bool VisitCXXBoolLiteralExpr(CXXBoolLiteralExpr *cxxbool) {
    llvm::outs() << "\"" << cxxbool->getValue() << "\"";
    return true;
  }
  
  // CXXConstructExpr
  bool VisitCXXConstructExpr(CXXConstructExpr *cxxconst) {
    llvm::outs() << "{:kind \"Unknown\"}";
    return false;
  }

  // CXXDependentScopeMemberExpr
  bool VisitCXXDependentScopeMemberExpr(CXXDependentScopeMemberExpr *cxxdsm) {
    llvm::outs() << "{:kind \"Unknown\"}";
    return false;
  }

  // CXXNewExpr
  bool VisitCXXNewExpr(CXXNewExpr *cxxnew) {
    return false;
  }

  // CXXThisExpr
  bool VisitCXXThisExpr(CXXThisExpr *cxxthis) {
    llvm::outs() << "{:kind \"Unknown-Expr\"}";
    return true;
  }

  // DependentScopeDeclRefExpr
  bool VisitDependentScopeDeclRefExpr(DependentScopeDeclRefExpr *dsDRE) {
    llvm::outs() << "{:kind \"Unknown\""
		 << " :name \"" << dsDRE->getDeclName().getAsString() << "\"";
    PrintSourceRange(dsDRE->getSourceRange());
    llvm::outs() << "}";
    return false;
  }
  
  // UnaryTypeTraitExpr
  bool VisitUnaryTypeTraitExpr(UnaryTypeTraitExpr *utte) {
    llvm::outs() << "{:kind \"Unknown\"}";
    return true;
  }
  
  // UnresolvedLookupExpr
  bool VisitUnresolvedLookupExpr(UnresolvedLookupExpr *ulexpr) {
    llvm::outs() << "{:kind \"Unknown\"" 
		 << " :name \"" << ulexpr->getName() << "\"";
    PrintSourceRange(ulexpr->getSourceRange());
    llvm::outs() << "}";
    return false;
  }
  
  // UnresolvedMemberExpr
  bool VisitUnresolvedMemberExpr(UnresolvedMemberExpr *umemexpr) {
    TraverseStmt(umemexpr->getBase());
    return true;
  }

  //
  // BreakStmt
  bool VisitBreakStmt(BreakStmt *Break) {
    llvm::outs()  << "{:kind \"Break\"";
    PrintSourceRange(Break->getSourceRange());
    checkLabel(); 
    llvm::outs() << "}";
    return true;
  }
 
  // CaseStmt
  bool VisitCaseStmt(CaseStmt *Case) {
    os << "{:kind \"Case\"";
    PrintSourceRange(Case->getSourceRange());
    os  << " :value ";
    caselabel += os.str();
    os.str("");
    os.clear();
    return true;
  }
  
  // CompoundStmt
  bool VisitCompoundStmt(CompoundStmt *compound) {
    if (compound->body_empty()) {
      linefeedflag = 1;
      linefeedbody = 1;
    }
    return true;
  }
  // ContinueStmt
  bool VisitContinueStmt(ContinueStmt *Continue) {
    llvm::outs() << "{:kind \"Continue\"";
    PrintSourceRange(Continue->getSourceRange());
    checkLabel(); 
    llvm::outs() << "}";
    return true;
  } 
  
  // DefaultStmt
  bool VisitDefaultStmt(DefaultStmt *Default) {
    os << "{:kind \"Default\"";
    PrintSourceRange(Default->getSourceRange());
    os << "}";
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
    checkLabel(); 
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
    checkLabel(); 
    llvm::outs() << "\n :init [";
    linefeedflag = 0;
    TraverseStmt(For->getInit());
    llvm::outs() << "]\n :condition ";
    linefeedflag = 0;
    if (For->getCond() == NULL) {
      llvm::outs() << "[]";
    } else {
      TraverseStmt(For->getCond());
    }
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
    checkLabel(); 
    llvm::outs() << " :goto " << "\"" << label->getName() << "\"}";
    return true;
  }

  // IfStmt
  bool VisitIfStmt(IfStmt *If) {
    llvm::outs() << "{:kind \"If\"";
    PrintSourceRange(If->getSourceRange());
    checkLabel(); 
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
    checkLabel(); 
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
    checkLabel(); 
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
    llvm::outs() << "{:kind \"Ret\"";
    PrintSourceRange(Ret->getSourceRange());
    checkLabel(); 
    if (Ret->getRetValue()) {
      llvm::outs() << " :value ";
      linefeedflag = 0;
      TraverseStmt(Ret->getRetValue());
    } else {
      
    }
    llvm::outs() << "}";
    return false;
  }

  //
  // ArraySubscriptExpr
  bool VisitArraySubscriptExpr(ArraySubscriptExpr *arrsub) {
    llvm::outs() << "{:kind \"ArrayRef\"";
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(arrsub->getType());
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(arrsub->getSourceRange());
    checkLabel(); 
    llvm::outs() << "\n :Array [";
    TraverseStmt(arrsub->getLHS());
    llvm::outs() << "]\n :Index ";
    linefeedflag = 0;
    TraverseStmt(arrsub->getRHS()); 
    llvm::outs() << "}";
    return false;
  }

  // CallExpr
  bool VisitCallExpr(CallExpr *call) {
    llvm::outs() << "{:kind \"FuncCall\"";
    checkLabel();
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(call->getType());
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(call->getSourceRange());
    llvm::outs() << "\n :Func [";
    linefeedflag = 0;
    TraverseStmt(call->getCallee());
    llvm::outs() << "]\n :Parm [";
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

  // CStyleCastExpr
  bool VisitCStyleCastExpr(CStyleCastExpr *cscast) {
    if (cscast->getCastKind() != 3) {
      QualType casttype = cscast->getType();
      PrintTypeInfo(casttype); 
      ct.push(castlabel);
      castlabel = "";
      cast.str("");
      cast.clear();
    }
    castflag = 0;
    return true;
  }

  // DeclRefExpr(DRE)
  bool VisitDeclRefExpr(DeclRefExpr *Declref) {
    if (Declref->hasTemplateKWAndArgsInfo()) {
      llvm::outs() << Declref->getNameInfo();
    }
    ValueDecl *valuedecl = Declref->getDecl();
    VarDecl *vardecl = dyn_cast<VarDecl>(valuedecl);
    FunctionDecl *funcdecl = dyn_cast<FunctionDecl>(valuedecl);
    std::string scope = "";
    if (labelflag != 0) {
      if (vardecl) {// 変数の場合
	QualType vartype = vardecl->getType();
	scope = (vardecl->isFileVarDecl() == 1? "global":"local");
	std::string Declreftype = Declref->getType().getAsString();
	os << "{:kind \"DRE\"" 
	   << " :name " << "\"" << Declref->getNameInfo().getAsString() << "\""
	   << " :scope " << "\"" << scope << "\"";
	checkSpecifier(vardecl->getStorageClass());
	PrintDisplayType(vartype);
	os << " :type [";
	firsttype = 0;
	PrintTypeInfo(vartype);
	checkCast();
	os << "]";
	PrintSourceRange(Declref->getSourceRange());
	os << "}";
	if (casetoji != 0) {
	os << "}";
	casetoji = 0;
	}
	caselabel += os.str();
	os.str("");
	os.clear();
      } else if (funcdecl) {// 関数の場合
	QualType functype = funcdecl->getType();
	std::string Declreftype = funcdecl->getResultType().getAsString();
	os << "{:kind \"DRE\"" 
	   << " :name " << "\"" << Declref->getNameInfo().getAsString() << "\"";
	checkSpecifier(funcdecl->getStorageClass());
	PrintDisplayType(functype);
	os << " :type [";
	firsttype = 0;
	PrintTypeInfo(functype);
	checkCast();
	os << "]";
	PrintSourceRange(Declref->getSourceRange());
	os << "}";
	if (casetoji != 0) {
	os << "}";
	casetoji = 0;
	}
	caselabel += os.str();
	os.str("");
	os.clear();
      } else {
	QualType Declreftype = Declref->getType();
	os << "{:kind \"DRE\"" 
	   << " :name " << "\"" << Declref->getNameInfo().getAsString() << "\"";
	PrintDisplayType(Declreftype);
	os << " :type [";
	firsttype = 0;
	PrintTypeInfo(Declreftype);
	checkCast();
	os << "]";
	PrintSourceRange(Declref->getSourceRange());
	os << "}";
      }
      if (casetoji != 0) {
	os << "}";
	casetoji = 0;
      }
      caselabel += os.str();
      os.str("");
      os.clear();
    } else {
      if (vardecl) {// 変数の場合
	QualType vartype = vardecl->getType();
	scope = (vardecl->isFileVarDecl() == 1? "global":"local");
	std::string Declreftype = Declref->getType().getAsString();
	llvm::outs() << "{:kind \"DRE\"" 
		     << " :name " << "\"" << Declref->getNameInfo() << "\""
		     << " :scope " << "\"" << scope << "\"";
	checkSpecifier(vardecl->getStorageClass());
	PrintDisplayType(vartype);
	llvm::outs() << " :type [";
	firsttype = 0;
	PrintTypeInfo(vartype);
	checkCast();
	llvm::outs() << "]";
	PrintSourceRange(Declref->getSourceRange());
	checkLabel(); 
	llvm::outs() << "}";
      } else if (funcdecl) {// 関数の場合
	QualType functype = funcdecl->getType();
	std::string Declreftype = funcdecl->getResultType().getAsString();
	llvm::outs() << "{:kind \"DRE\"" 
		     << " :name " << "\"" << Declref->getNameInfo() << "\"";
	checkSpecifier(funcdecl->getStorageClass());
	PrintDisplayType(functype);
	llvm::outs() << " :type [";
	firsttype = 0;
	PrintTypeInfo(functype);
	checkCast();
	llvm::outs() << "]";
	PrintSourceRange(Declref->getSourceRange());
	checkLabel(); 
	llvm::outs() << "}";
      } else {
	QualType Declreftype = Declref->getType();
	llvm::outs() << "{:kind \"DRE\"" 
		     << " :name " << "\"" << Declref->getNameInfo() << "\"";
	PrintDisplayType(Declreftype);
	llvm::outs() << " :type [";
	firsttype = 0;
	PrintTypeInfo(Declreftype);
	checkCast();
	llvm::outs() << "]";
	PrintSourceRange(Declref->getSourceRange());
	checkLabel(); 
	llvm::outs() << "}";
      }
    }
    return true;
  }

  // ImplicitCastExpr
  bool VisitImplicitCastExpr(ImplicitCastExpr *icast) {
    if (labelflag != 0) {
	  return true;
    }
    if (icast->getCastKind() != 3) {
      QualType casttype = icast->getType();
      PrintTypeInfo(casttype); 
      ct.push(castlabel);
      castlabel = "";
      cast.str("");
      cast.clear();
    }
    castflag = 0;
    return true;
  }

  // MemberExpr
  bool VisitMemberExpr(MemberExpr *mem) {
    Expr *base = mem->getBase();
    ValueDecl *vdecl = mem->getMemberDecl();
    QualType memtype = mem->getType();
    if (mem->isLValue() || mem->isRValue()) {
      llvm::outs() << "{:kind \"Struct\""
		   << " :struct ";
      linefeedflag = 0;
      TraverseStmt(base);
      llvm::outs() << " :structmember ";
      linefeedflag = 0;
      TraverseDecl(vdecl);
      llvm::outs() << " :type [";
      firsttype = 0;
      PrintTypeInfo(memtype);
      checkCast();
      llvm::outs() << "]";
      PrintSourceRange(mem->getSourceRange());
      llvm::outs() << "}";
      
      //linefeedflag = 0;
      //TraverseDecl(mem->getMemberDecl());
      return false; 
    }
    if(mem->isArrow()) {
      llvm::outs() << "{:kind \"Binop\" :op \"->\"";
      llvm::outs() << " :type [";
      firsttype = 0;
      PrintTypeInfo(mem->getType());
      checkCast();
      llvm::outs() << "]";
      PrintSourceRange(mem->getSourceRange());
      checkLabel(); 
      llvm::outs() << "\n :LHS ";
      getlhsArrow(base);
      llvm::outs() << "\n :RHS ";
      getrhsArrow(vdecl);
      llvm::outs() << "}"; 
      return false;
    } 
    return false;
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
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(vartype);
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(vdecl->getSourceRange());
    llvm::outs() << "}";
    return true;
  }
  
  // UnaryExprOrTypeTraitExpr
  bool VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr *expr) {
    switch(expr->getKind()) {
    case UETT_SizeOf:
      llvm::outs() << "{:kind \"SizeOf\"";
      llvm::outs() << " :type [";
      firsttype = 0;
      PrintTypeInfo(expr->getType());
      checkCast();
      llvm::outs() << "]";
      if (expr->isArgumentType()) {
	firsttype = 0;
	llvm::outs() << " :ArgumentType [";
	PrintTypeInfo(expr->getArgumentType());
	llvm::outs() << "]";
      } else {
	llvm::outs() << " :Argument ";
	TraverseStmt(expr->getArgumentExpr());
      }
      PrintSourceRange(expr->getSourceRange());
      llvm::outs() << "}";
      return false;
    default: 
      break;
    }
    return true;
  }

  // UnaryOperator
  bool VisitUnaryOperator(UnaryOperator *Unop) {
    UnaryOperator::Opcode opcode = Unop->getOpcode();
    llvm::outs() << "{:kind \"Unop\""
		 << " :op " << "\"" << Unop->getOpcodeStr(opcode) << "\"";
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(Unop->getType());
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(Unop->getSourceRange());
    checkLabel(); 
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
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(Binop->getType());
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(Binop->getSourceRange());
    checkLabel(); 
    llvm::outs() << "\n :LHS ";
    linefeedflag = 0;
    TraverseStmt(Binop->getLHS());
    llvm::outs() << "\n :RHS ";
    if (Binop->getRHS()->getStmtClass() == 68) {
      llvm::outs() << "{:kind \"NULL\" :value \"Null\"}";
    } else {
      linefeedflag = 0;
      TraverseStmt(Binop->getRHS());
    }
    llvm::outs() << "}";
      
    return false;
  }
  
  // ConditionalOperator
  bool VisitConditionalOperator(ConditionalOperator *condop) {
    llvm::outs() << "{:kind \"Conditionalop\""; 
      //<< " :op " << "\"" << condop->getOpcodeStr() << "\"";
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(condop->getType());
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(condop->getSourceRange());
    checkLabel(); 
    llvm::outs() << "\n :operand1 ";
    linefeedflag = 0;
    TraverseStmt(condop->getCond());
    llvm::outs() << "\n :operand2 ";
    linefeedflag = 0;
    TraverseStmt(condop->getTrueExpr());
    llvm::outs() << "\n :operand3 ";
    if (condop->getRHS()->getStmtClass() == 68) {
      llvm::outs() << "{:kind \"NULL\" :value \"Null\"}";
    } else {
      linefeedflag = 0;
      TraverseStmt(condop->getFalseExpr());
    }
    llvm::outs() << "}";
      
    return false;
    
  }
    
  // LabelValue
  void getLabelValue(Expr *literal){
    std::string literalname;
    std::string literalvalue;
    QualType literaltype = literal->getType();
    if (dyn_cast<IntegerLiteral>(literal)) {
      literalname = "IntegerLabel";
      IntegerLiteral* intL = dyn_cast<IntegerLiteral>(literal);
      os << "{:kind \"" << literalname << "\""
	 << " :value " << "\"" << intL->getValue().toString(10, true) << "\"";
    } else if (dyn_cast<CharacterLiteral>(literal)) {
      literalname = "CharacterLabel";
      CharacterLiteral* charL = dyn_cast<CharacterLiteral>(literal);
      os << "{:kind \"" << literalname << "\""
	 << " :value " << "\"" << charL->getValue() << "\""
	 << " :character " << "\"" << char(charL->getValue()) << "\"";
    }
    os << " :type [";
    firsttype = 0;
    PrintTypeInfo(literaltype);
    checkCast();
    os << "]";
    PrintSourceRange(literal->getSourceRange());
    os << "}}";
    casetoji = 0;
    caselabel += os.str();
    os.str("");
    os.clear();
    labelflag = 0;
    return;
  }

  // IntegerLiteral
  bool VisitIntegerLiteral(IntegerLiteral *Int) {
    QualType vartype = Int->getType();
    if (labelflag != 0) {
      getLabelValue(Int);
    } else {
      llvm::outs() << "{:kind \"IntegerLiteral\""
		   << " :value " << Int->getValue();
      llvm::outs() << " :type [";
      firsttype = 0;
      PrintTypeInfo(vartype);
      checkCast();
      llvm::outs() << "]";
      PrintSourceRange(Int->getSourceRange());
      llvm::outs() << "}";
    }
    return true;
  }

  // FloatingLiteral
  bool VisitFloatingLiteral(FloatingLiteral *Float) {
    QualType vartype = Float->getType();
    llvm::outs() << "{:kind \"FloatingLiteral\""
		 << " :value " << Float->getValueAsApproximateDouble();
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(vartype);
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(Float->getSourceRange());
    llvm::outs() << "}";
    return true;
  }

  // CharacterLiteral
  bool VisitCharacterLiteral(CharacterLiteral *Char) {
    QualType vartype = Char->getType();
    if (labelflag != 0) {
      getLabelValue(Char);
    } else {
      llvm::outs() << "{:kind \"CharacterLiteral\""
		   << " :value " << "\"" << Char->getValue() << "\""
		   << " :character " << "\"" << char(Char->getValue()) << "\"";
      llvm::outs() << " :type [";
      firsttype = 0;
      PrintTypeInfo(vartype);
      checkCast();
      llvm::outs() << "]";
      PrintSourceRange(Char->getSourceRange());
      llvm::outs() << "}";
    }
    return true;
  }

  // StringLiteral
  bool VisitStringLiteral(StringLiteral *String) {
    QualType vartype = String->getType();
    llvm::outs() << "{:kind \"StringLiteral\""
		 << " :value " << "\"" << String->getString().str() << "\"";
    llvm::outs() << " :type [";
    firsttype = 0;
    PrintTypeInfo(vartype);
    checkCast();
    llvm::outs() << "]";
    PrintSourceRange(String->getSourceRange());
    llvm::outs() << "}";
    return true;
  }

  //// 出力関係
  // 行数 
  void PrintSourceRange(SourceRange range) {
    FullSourceLoc FullLocationBegin = Context->getFullLoc(range.getBegin());
    FullSourceLoc FullLocationEnd = Context->getFullLoc(range.getEnd());
    if (labelflag != 0) {
      os << " :line [" 
	 << Context->getFullLoc(range.getBegin()).getSpellingLineNumber() 
	 << " " 
	 << Context->getFullLoc(range.getEnd()).getSpellingLineNumber() 
	 << "]";
      caselabel += os.str();
      os.str("");
      os.clear();
    } else {
#if 0
      llvm::outs() << " :line [" 
		   << Context->getFullLoc(range.getBegin()).getSpellingLineNumber() 
		   << " " 
		   << Context->getFullLoc(range.getEnd()).getSpellingLineNumber() 
		   << "]";

      llvm::outs() << " :column " 
		   << Context->getFullLoc(range.getBegin()).getSpellingColumnNumber();
      // U>_<U
      llvm::outs() << " :Filename " 
		   << "\"" << FullLocation.getManager().getFilename(FullLocation) << "\""
		   << " :EndFile "
		   << "\"" << Context->getFullLoc(range.getEnd()).getManager().getFilename(FullLocation) << "\"";
#else
      
      llvm::outs() << " :loc-begin [" 
		   << "\"" << Context->getFullLoc(range.getBegin()).getManager().getFilename(FullLocationBegin) << "\""
		   << " " << Context->getFullLoc(range.getBegin()).getSpellingLineNumber()
		   << " " << Context->getFullLoc(range.getBegin()).getSpellingColumnNumber() << "]"
		   << " :loc-end [" 
		   << "\"" << Context->getFullLoc(range.getEnd()).getManager().getFilename(FullLocationEnd) << "\""
		   << " " << Context->getFullLoc(range.getEnd()).getSpellingLineNumber()
		   << " " << Context->getFullLoc(range.getEnd()).getSpellingColumnNumber() << "]";	
#endif
    }
  }

  // ラベルの有無
  void checkLabel() {
    if (caseflag != 0) {
      llvm::outs() << " :label [" << caselabel << "]";
      caselabel = "";
      caseflag = 0;
    }
  }

  // ImplicitCastの有無
  void checkCast() {
    while (!ct.empty()) {
      llvm::outs() << " " << ct.top();
      ct.pop();
    }
  }
  
  
private:
  ASTContext *Context;
  std::string last_func;
  std::string source_file;
  std::string caselabel; // 出力したいラベルの属性
  std::string castlabel;
  std::ostringstream os;
  std::ostringstream cast;
  std::stack<std::string> ct; // cast_type (ImplicitCast, CStyleCastのみ)
  int ArraySub;
  int casetoji;
  int caseflag; // ラベルが付いている証
  int castflag; // ImplicitCastExpr が出現したか
  int firsttype; // typeでrecordtypeが最初に出て来たか判断
  int FuncCall;
  int labelflag; // ラベル(case, default, label)が出現した印
  int linefeedbody;
  int linefeedflag;
  int pointflag;
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
