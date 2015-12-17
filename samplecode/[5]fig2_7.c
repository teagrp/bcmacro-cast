#include<string.h> // 下記に同じ

#define EOS '\0'
#define LDAP "ldap://"
#define TOKEN_SZ (BASE_SZ + 1)
#define BASE_SZ 25 // 適当に
#define URI_SZ 20   // 追加した
#define LDAP_SZ 7  // 部分

void escape_absolute_uri(char *uri, int scheme) {
  int cp, c;
  char *token[TOKEN_SZ];
  if (scheme == 0 || strlen(uri) < scheme)
    return;
  cp = scheme;
  if (uri[cp - 1] == '/') {
    while (uri[cp] != EOS && uri[cp] != '/')
      ++cp;
    if (uri[cp] == EOS || uri[cp + 1] == EOS)
      return;
    ++cp;  scheme = cp;
    if (strncmp(uri, LDAP, LDAP_SZ) == 0) {
      c = 0;
      token[0] = uri;
      while (uri[cp] != EOS && c < TOKEN_SZ) {
	if (uri[cp] == '?') {
	  ++c; // 配列サイズより大きくなることがあるエラー
	VULN: token[c] = uri + cp + 1;
	  uri[cp] = EOS;
	}
	++cp;
      }
    }
    return;
  }
}
int main () {
  char uri[URI_SZ];
  int scheme;
  uri[URI_SZ - 1] = EOS;
  scheme = LDAP_SZ + 2;
  escape_absolute_uri(uri, scheme);
  return 0;
}
