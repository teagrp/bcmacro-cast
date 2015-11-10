int x = 100;

int sum (int a, int b) {
  return a + b;
}

int main() {
  int y;
  for (y = 0; y < 10; y++) {
    sum(x, y);
  }


  return 0;
}
