
  char *loop_ptr;
  int *int_ptr;
  
  int *loop_function(void *v_pointer) {

    return v_pointer;
  }
  
int main() {  
  int_ptr = loop_function(loop_ptr);

  return 0;
}
