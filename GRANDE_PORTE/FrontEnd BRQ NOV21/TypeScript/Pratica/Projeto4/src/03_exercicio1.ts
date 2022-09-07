/*Exercício 1:
// definido um array com os nomes  'Marcos', 'Luan', 'Bento', 'Ruan','João'​
// varrear o array construido​
// alterar o nome do aluno Marcos para Marcos Silva​
// acrescentar o aluno Rodrigo​
// excluir o ultimo aluno da lista​
// retirar o aluno Bento​*/

// definido um array com os nomes
let vetorNomes: Array<string> = ["Marcos", "Luan", "Bento", "Ruan", "João"];

// varrer / iterar o array construido​
function imprimirNomes(vetor: any[]): void {
  vetor.forEach(function (nomes) {
    console.log(nomes);
  });
}

imprimirNomes(vetorNomes);

let marcos: number = vetorNomes.indexOf("Marcos");
console.log(marcos);

// alterar o nome do aluno Marcos para Marcos Silva​
vetorNomes.splice(0, 1, "Marcos", "Marcos Silva​");
console.log(vetorNomes);
// excluir o ultimo aluno da lista​
vetorNomes.splice(0, 1);
console.log(vetorNomes);

// acrescentar o aluno Rodrigo​
vetorNomes.splice(5, 0, "Rodrigo​");
console.log(vetorNomes);

// excluir o ultimo aluno da lista​
vetorNomes.splice(5, 1);
console.log(vetorNomes);

// retirar o aluno Bento​*/
//  let bento: number = vetorNomes.indexOf("Bento");
//  console.log(bento);
//  vetorNomes.splice(2, 1);
//  console.log(vetorNomes);

let bento: number = vetorNomes.indexOf("Bento");
console.log(bento);
vetorNomes.splice(bento, 1);
console.log(vetorNomes);
