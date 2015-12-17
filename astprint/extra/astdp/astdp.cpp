#include "clang/Frontend/FrontendActions.h"
#include "clang/Tooling/CommonOptionsParser.h"
#include "clang/Tooling/Tooling.h"
#include "clang/Driver/Options.h"
#include "llvm/Support/CommandLine.h"
#include "llvm/Support/Path.h"
#include "llvm/Support/Signals.h"
#include "llvm/Option/OptTable.h"

using namespace clang::driver;
using namespace clang::tooling;
using namespace llvm;
using namespace llvm::opt;

static OwningPtr<OptTable> Options(createDriverOptTable());
static cl::opt<bool> MyOpt(
                           "my-opt",
                           cl::desc("my-opt message"));

static cl::extrahelp CommonHelp(CommonOptionsParser::HelpMessage);

static cl::extrahelp MoreHelp("\nMore help text...");

int main(int argc, const char **argv) {
  CommonOptionsParser OptionsParser(argc, argv);
  ClangTool Tool(OptionsParser.getCompilations(),
                 OptionsParser.getSourcePathList());

  if (MyOpt) {
    llvm::outs() << "Use MyOpt!" << "\n";
  }

  return Tool.run(newFrontendActionFactory<clang::ASTDumpAction>());
}
