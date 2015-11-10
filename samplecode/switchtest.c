int main() {
  int x = 5;
  int y = 0;
  while (x != 0) {
    switch (x) {
    case 1:
      y = x;
      x--;
      break;
    case 2:
      y = x;
      x++;
      continue;
    case 3:
      y = x;
      x++;
      break;
    default:
      x = 1;
    }
  }

  return 0;
}
