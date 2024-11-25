/* final_state.c */
#include <stdio.h>
#include <stdlib.h>

int final_state;
pid_t val_return;

int main(int argc, char *argv[])
{
    printf("Proceso padre %ld\n", (long)getpid());
    for(int i = 0; i < 4; i++){
        val_return = fork();
        if (val_return == 0) {
            printf("Hijo %ld creado en iteración = %d\n", (long)getpid(), i);
            exit(i);
        }
        else { /* Padre fuera del bucle for */
            printf("Padre %ld, iteración %d\n", (long)getpid(),i);
            printf("I have created a son %ld\n", (long)val_return);
            break;
        }
    }

    /* Espero a todos mis hijos y salgo */
    while(wait(&final_state)>0) {
        printf("Padre %ld iteración %d", (long)getpid(),i);
        printf("Mi hijo dijo &d\n",WEXITSTATUS(final_state));
        printf("Mi hijo dijo %d\n",final_state/256);
    }
    exit(i);
}
