
int x = 10;
int y = 0;

int main() {
  double sum;
  while (x > 5) {
    sum = x + y;
    y++;
    x--;
  }
  
  do {
    sum--;
  } while (sum != 0);

  return 0;
}
