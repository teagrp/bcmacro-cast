main(){
  static volatile int **ipp;
  static int *ip;
  static volatile int i = 0;
  
  printf("i = %d.\n", i);

  ipp = &ip;
  ipp = (int**) &ip;
  *ipp = &i;
  if (*ip != 0) {
  }
}
