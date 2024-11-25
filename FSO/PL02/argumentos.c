#include <stdio.h>

int main(int argc, char *argv[]) {   
     // A completar 
     printf("Numero de argumentos = %d", argc);

     for(int i = 0; i < argc; i++) {
          printf("\nArgumento %d es %s", i, argv[i]);
     }
     printf("\n");
}

