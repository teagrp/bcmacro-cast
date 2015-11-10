int x;

int func (int a) {
  x = a;

  return 0;
}

int func (int a, int b) {
  x = a + b;
  return 0;
}

int func (char str) {
  return 0;
}

