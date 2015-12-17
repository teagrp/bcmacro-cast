int x = 100;

int sum (int a, int b) {
  return a + b;
}

void summer () {
  sum(x, x);
  return;
}

int main() {
  int y;
  for (y = 0; y < 10; y++) {
    sum(x, y);
  }


  return 0;
}
