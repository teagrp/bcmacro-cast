int f(int a, int b) {
  while ((a = b) || (a = b))
    ;
  return b;
}
