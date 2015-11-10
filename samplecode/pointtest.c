#include<stdio.h>
#include<malloc.h>

typedef struct _person{
  char name[50];
  char phone[50];
  struct _person *next;
}person;

person *head;

int main(void) {
  int s, i;
  person *p, *tmp;

  s = 0;
  printf("What people?\n");
  scanf("%d", &s);

  head = NULL;
  
  for (i=1; i<=s; i++) {
    p = (person *)malloc(sizeof(person));
    if(p == NULL) {
      printf("Memory not keep!!\n");
      return 1;
    }

    printf("Waht Name?\n");
    scanf("%s", p->name);
    printf("Waht Number?\n");
    scanf("%s", p->phone);
    
    p->next = head;
    head = p;
  }

  printf("List This is.\n");
  p = head;
  while(p != NULL) {
    tmp = p->next;
    free(p);
    p = tmp;
  }
  
  return 0;
}
