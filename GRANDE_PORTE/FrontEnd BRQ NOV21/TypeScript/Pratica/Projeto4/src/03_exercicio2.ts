//Passe 5 números para uma função e apresente o resultado da  soma dos números

let numbersList = [1, 2, 3, 4, 5];


 function somaVetor(vetor: number[]): void{
    var soma = 0;
for (var i = 0; i < numbersList.length; i++){
 soma += numbersList[i]; 
 }
 console.log(soma)};




console.log(numbersList.reduce(function(anterior,atual){
    return anterior + atual;
}));