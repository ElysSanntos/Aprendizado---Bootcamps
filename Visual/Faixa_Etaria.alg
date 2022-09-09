algoritmo "Faixa_Etaria"
// Função :  Solicitar a idade de um aluno e em seguida indique em qual classificação ele se encaixa em função de sua idade,
//de acordo com a tabela abaixo:
//Idade		 	Classificação
//Menos de 4 anos		Sem classificação
//De 4 a 10 anos		Infantil
//De 11 a 14 anos 	Infanto-Juvenil
//De 15 a 17 anos		Juvenil
//18 anos ou mais		Adulto
// Autor :   Elys_Sanntos
// Data : 01/03/2020
// Seção de Declarações
var
idade : inteiro
inicio

escreva("Digite a idade do Aluno: ")
Leia(idade)

Se(idade>=18)ENTAO
   escreva(idade, " anos. O aluno é um adulto")

senao
   se(idade >=15)ENTAO
      escreva(idade," anos. O aluno está na faixa Juvenil")

   senao
      se(idade>=11)ENTAO
         escreva(idade," anos. O aluno está na faixa Infanto-Juvenil")

      senao
         se(idade>=4)ENTAO
            escreva(idade, " anos. O aluno está na faixa Infantil")

         senao
            escreva(idade, " anos. Sem classificação. Por favor, digite uma idade válida!")
         fimse
      fimse
   fimse
fimse

fimalgoritmo
