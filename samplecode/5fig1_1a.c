int main() {
  char input[10], buf[9], *src, *dest;

  dest = buf;
  src = input;
  while (*src) {
  VULN: *dest++ = *src++;
  }
  return 0;
}
