int main() {
  char const **cpp;
  char *cp;
  char const c = 'A';
  
  cpp = &cp; 
  *cpp = &c; 
  *cp = 'B'; 

  return 0;
}
