typedef struct dekinai {   
  char name[20];
  char sex; 
  int age;
  double height; 
  double weight; 
} person_t;


int main() {
  person_t p = {"Tom", 'M', 19, 175.2, 69.5};
  
  p.age ++;
  p.height += 0.7;
  p.weight -= 1.5;
  
  return 0;
}
