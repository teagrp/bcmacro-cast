#inclde "clang/AST/ASTContext.h"
#inclde "clang/AST/ASTConsumer.h"
#inclde "clang/AST/RecursiveASTVisitor.h"

using namespace clang;

class MyAstVisitor : public RecursiveASTVisitor<MyAstVisitor> {
public:
  explicit MyAstVisitor(ASTContext *Context, llvm::StringRef InFile) {}
  std::string toString(const Stmt *p) {
    std::string s;
    llvm::raw_string_ostream raw(s);
    p -> printPretty(raw, NULL, Context -> getPrintingPolicy());
    return raw.str();
  }
