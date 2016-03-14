typedef unsigned int size_t;

void f(size_t n) {
  size_t a = sizeof(int [n + 3]);
  size_t b = sizeof(int [n - 3]);
  size_t c = sizeof(int [n * 3]);
  size_t d = sizeof(int [n / 3]);
  size_t e = sizeof(int [n % 3]);
  size_t f = sizeof(int [n++]);
  size_t g = sizeof(int [n--]);
  size_t h = sizeof(int [n & 0xff00]);
  size_t i = sizeof(int [n | 0xff00]);
  size_t j = sizeof(int [n ^ 0xff00]);
  size_t k = sizeof(int [~n]);
  size_t l = sizeof(int [n << 3]);
  size_t m = sizeof(int [n >> 3]);
  size_t o = sizeof(int [n = 3]);
  size_t p = sizeof(int [n += 3]);
  size_t q = sizeof(int [n -= 3]);
  size_t r = sizeof(int [n *= 3]);
  size_t s = sizeof(int [n /= 3]);
  size_t t = sizeof(int [n %= 3]);
  size_t u = sizeof(int [n &= 0xff00]);
  size_t v = sizeof(int [n |= 0xff00]);
  size_t w = sizeof(int [n ^= 0xff00]);
  size_t x = sizeof(int [n <<= 3]);
  size_t y = sizeof(int [n >>= 3]);
}
