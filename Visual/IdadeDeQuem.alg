

Algoritmo "IdadeDeQuem"
Var  Idade, A, B, C, D : inteiro
Inicio
   A <-1
   B <-0
   C <- 0
   Idade<-1
   

   Enquanto (Idade>0) Faca
   

       Escreva ('Digite a ', A, 'a. Idade (0 ou menor, para sair): ')
       Leia (Idade)
       Se (Idade>0) Entao

       
       para
           B <- B + Idade
           Se (Idade>=12) Entao
                C <- C + 1

           A <- A + 1
       fimpara
   fimpara
   A <- A - 1
    Se (A > 0 ) Entao
          D<- B / (A)
    Senao
          D <- 0;
   Escreva ('A=', A )
   Escreva ('B=', B )
   Escreva ('C=', C )
   Escreva ('D=', D )
fimse
