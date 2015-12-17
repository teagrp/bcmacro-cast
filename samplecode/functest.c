int x;

int func (int a) {
  x = a;

  return 0;
}

int function (int a, int b) {
  x = a + b;
  return x;
}

int funcsion (char str) {
  return 0;
}

int main() {
  int s = 10, t = 50;

  s = function(s, t);
  s = s + 100;
  func(s);
  
  return 0;
}
