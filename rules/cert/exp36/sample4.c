char c = 'x';
int *ip = (int *)&c; 
char *cp = (char *)ip;
assert(cp == &c);
