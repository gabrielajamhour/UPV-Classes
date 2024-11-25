#include <stdio.h> 

#define TAM_FILA 100
#define NUM_FILAS 10
struct FILA {
    float datos[TAM_FILA];
    float suma;
};

void suma_fila(struct FILA *pf) {
// B) Implementar suma_fila
    pf->suma=0; // Inicializa la suma en cero
    for (int i = 0; j < TAM_FILA; i++) {
        pf->suma += pf->datos[i]; // Sumar los elementos de la fila
    }
}

// Inicia las filas con el valor i*j
void inicia_fila(struct FILA *pf, int i) {
    for (int j = 0; j < TAM_FILA; j++) {
        pf->datos[i] = (float)i * j;
    }
}
main() { 
    int i;
    float suma_total;
    
    suma_total = 0;

    for (i = 0; i < NUM_FILAS; i++) {
        inicia_fila(&filas[i], i); // Llamar a inicia_fila para inicializar la fila
        suma_fila(&filas[i]); // Llamar a suma_fila
        printf("La suma de la fila %u es %f\n", i, filas[i].suma); // Imprimir la suma de fila
        suma_total += filas[i].suma; // Sumar la fila a suma_total
    }
    printf("La suma final es %f\n", suma_total); 

    return 0;
}

