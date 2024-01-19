void parse_data(char *input_string)
{
  size_t len_str;
  ulong string_index;
  undefined string_data [23];
  byte length_string;
  int outer_index;
  int inner_index;
  
  inner_index = -1;
  outer_index = 0;
  do {
    memset(string_data,0,0x10);
    length_string = 0;
    while (inner_index = inner_index + 1, input_string[inner_index] != ',') {
      if (input_string[inner_index] == 0x0) {
        length_string = length_string - 1;
        break;
      }
      length_string = length_string + 1;
    }
    if (16 < (char)length_string) {
      puts("Too big data");
      leave_to_big();
    }
    memcpy(string_data,input_string + outer_index,(ulong)length_string);
    outer_index = outer_index + length_string + 1;
    printf("Length: %d\n",(ulong)length_string);
    printf("Data :%s\n",string_data);
    string_index = (ulong)inner_index;
    len_str = strlen(input_string);
    if (len_str <= string_index) {
      return;
    }
  } while( true );
}

undefined8 main(void)
{
  void *input_string;
  
  init_buffering();
  puts("Welcome to my data parser!");
  puts("Please enter you comma-seperated data: ");
  input_string = malloc(0x100);
  read(0,input_string,0x100);
  parse_data(input_string);
  return 0;
}

void win()