
int main() {
  int a, b, c;
  
  c = 20;
  for (a = 10, b = 50; a + c <= b; a++, c++) {
    b = b + 1;
  }
  c = 0;
  for (a = 50; a < b; a++) {
    c++;
  }
  
  return 0;
}
