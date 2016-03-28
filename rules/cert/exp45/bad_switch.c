int f(int a, int b) {
  switch(a = b) {
  case 0:
    return 0;
  default:
    return 1;
  }
}
