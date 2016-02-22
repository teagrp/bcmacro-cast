struct X { int b[4];};

int f() {
  int a[3];
  struct X c;
  a[0]++;
  c.b[0]++;
  return 0;
}
