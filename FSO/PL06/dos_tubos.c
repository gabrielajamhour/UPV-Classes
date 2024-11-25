// dos_tubos.c
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (int argc, char *argv[]) {
    int fd;
    char *arguments1[] = { "ls", "-la", NULL };  // Para listar archivos
    char *arguments2[] = { "grep", "ejemplo", NULL };  // Filtra por "ejemplo"
    char *arguments3[] = { "wc", "-l", NULL };  // Cuenta las líneas
    
    char *arch = "result.txt";
    mode_t fd_mode = S_IRWXU;  // permisos del archivo
    
    int pipe1[2], pipe2[2];
    pid_t pid;

    // Crea pipe1
    if (pipe(pipe1) == -1) { 
        fprintf(stderr, "Pipe failure\n");
        exit(-1);
    }

    pid = fork();  // Crea P2
    if (pid == 0) {
        dup2(pipe1[1], STDOUT_FILENO);  // Redirige stdout a pipe1[1]
        close(pipe1[0]);
        close(pipe1[1]);

        execvp("ls", arguments1);  // Ejecuta ls
        perror("execvp ls failed");
        exit(-1);
    }

    // Crea pipe2
    if (pipe(pipe2) == -1) { 
        fprintf(stderr, "Pipe failure\n");
        exit(-1);
    }

    pid = fork();  // Crea P3 
    if (pid == 0) {
        dup2(pipe1[0], STDIN_FILENO);
        dup2(pipe2[1], STDOUT_FILENO);
        
        close(pipe1[0]);
        close(pipe1[1]);
        close(pipe2[0]);
        close(pipe2[1]);

        execvp("grep", arguments2);  // Ejecuta grep
        perror("execvp grep failed");
        exit(-1);
    }

    // Abre result.txt
    fd = open(arch, O_RDWR | O_CREAT, fd_mode);
    if (fd == -1) {
        perror("File failure");
        exit(-1);
    }

    dup2(pipe2[0], STDIN_FILENO); 
    dup2(fd, STDOUT_FILENO);
    close(pipe1[0]);
    close(pipe1[1]);
    close(pipe2[0]);
    close(pipe2[1]);
    close(fd);

    execvp("wc", arguments3); 
    perror("execvp wc failed");
    exit(-1);

    return 0;
}
