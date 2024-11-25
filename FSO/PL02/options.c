#include <stdio.h>

int main(int argc, char *argv[]) {
     // A completar

     for(int i = 1; i < argc; i++) {

         switch(argv[i][1]) {
             case 'c':
                 printf("Argumento %d es Compilar\n", i);
                 break;
             case 'E':
                 printf("Argumento %d es Preprocesar\n", i);
                 break;
             case 'i':
                 printf("Argumento %d es Incluir %s\n", i, &argv[i][2]);
                 break;
         }
     }
}

