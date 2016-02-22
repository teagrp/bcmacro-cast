main(){
  static volatile int **ipp;
  static int *ip;
  static volatile int i = 0;
  int **x;
  
  printf("i = %d.\n", i);

  ipp = &ip;
  x = (int**) &ip;
  ipp = x;
  *ipp = &i;
  if (*ip != 0) {
  }
}
