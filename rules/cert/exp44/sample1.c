void f() {
  int a = 14;
  int b = sizeof(a + 3);
  int c = sizeof(a - 3);
  int d = sizeof(a * 3);
  int e = sizeof(a / 3);
  int f = sizeof(a % 3);
  int g = sizeof(a++);
  int h = sizeof(a--);
  int i = sizeof(a & 0xff00);
  int j = sizeof(a | 0xff00);
  int k = sizeof(a ^ 0xff00);
  int l = sizeof(~a);
  int m = sizeof(a << 3);
  int n = sizeof(a >> 3);
  int o = sizeof(a = 3);
  int p = sizeof(a += 3);
  int q = sizeof(a -= 3);
  int r = sizeof(a *= 3);
  int s = sizeof(a /= 3);
  int t = sizeof(a %= 3);
  int u = sizeof(a &= 0xff00);
  int v = sizeof(a |= 0xff00);
  int w = sizeof(a ^= 0xff00);
  int x = sizeof(a <<= 3);
  int y = sizeof(a >>= 3);
}
