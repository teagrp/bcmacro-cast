
int main() {
  int x = 100;
  int y = 200;
  
 lavel1:
  x = x + y;
  if (x < 500) goto lavel1;

  return 0;
}
