struct X { int a[6]; };

struct X addressee(void) {
  struct X result = { 1, 2, 3, 4, 5, 6 };
  return result;
}

int main(void) {
  printf("%x", ++addressee().a[0]);
  printf("%x", --addressee().a[0]);
  printf("%x", addressee().a[0] + 3);
  printf("%x", addressee().a[0] - 3);
  printf("%x", addressee().a[0] * 3);
  printf("%x", addressee().a[0] / 3);
  printf("%x", addressee().a[0] % 3);
  printf("%x", addressee().a[0] & 0xff00);
  printf("%x", addressee().a[0] | 0xff00);
  printf("%x", addressee().a[0] ^ 0xff00);
  printf("%x", ~addressee().a[0]);
  printf("%x", addressee().a[0] << 3);
  printf("%x", addressee().a[0] >> 3);
  printf("%x", addressee().a[0] = 3);
  printf("%x", addressee().a[0] += 3);
  printf("%x", addressee().a[0] -= 3);
  printf("%x", addressee().a[0] *= 3);
  printf("%x", addressee().a[0] /= 3);
  printf("%x", addressee().a[0] %= 3);
  printf("%x", addressee().a[0] &= 0xff00);
  printf("%x", addressee().a[0] |= 0xff00);
  printf("%x", addressee().a[0] ^= 0xff00);
  printf("%x", addressee().a[0] <<= 3);
  printf("%x", addressee().a[0] >>= 3);

  return 0;
}
