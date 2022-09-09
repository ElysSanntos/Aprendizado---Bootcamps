#include <stdio.h>
#include <stdlib.h>

int main()
{



int vetor[10];

for ( int i = 0; i < 10; i++ )
{
    vetor[ i ] = i * 2;
}
for (int i = 0; i < 10; i++ )
{
    printf("Elemento[%d] = %d\n", i, vetor[i] );
}

 return 0;
}



