#include <string.h>

int main() {
  char *data;
  struct foo_header *tmp;
  struct foo_header *header;
  
  tmp = data + offset;
  memcpy(&header, tmp, sizeof(header));

  if (header.len < FOO){}

    return 0;
}
