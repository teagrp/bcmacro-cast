int main() {
  int x = 5;
  int y = 0;
  while (x != 0) {
    switch (x) {
      int kokoro;
    case 0:
    case 1:
      y = x;
      x--;
      break;
    case 2:
      y = x;
      x++;
      continue;
    case 3:
    case 4:
    case 5:
      y = x;
      x++;
      break;
    case 6:
    default:
      x = 1;
    }
  }

  return 0;
}
