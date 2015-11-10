void main() {
  char input[10], buf[9], *src, *dest;

  input[8] = '\0';
  
  dest = buf;
  src = input;
  while (*src) {
  VULN: *dest++ = *src++;
  }
}
