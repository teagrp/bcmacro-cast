int x = 100;
static char y;

int fu (int a, int b) {
  int sum;
  sum = a + b;
  return sum;
}

int main() {
  static int a = 50;
  int b = 300;
  fu (a, b);
  return 0;
}
