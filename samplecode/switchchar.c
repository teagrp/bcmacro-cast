int main() {
  char x = 'a';
  char y = 'b';
  while (x != y) {
    switch (x) {
    case 'w':
    case 'z':
      x = y;
      break;
    case 'f':
      y = x;
      continue;
    case 'g':
    case 'h':
    case 'y':
      y = x;
      break;
    default:
      x = 'z';
    }
  }

  return 0;
}
