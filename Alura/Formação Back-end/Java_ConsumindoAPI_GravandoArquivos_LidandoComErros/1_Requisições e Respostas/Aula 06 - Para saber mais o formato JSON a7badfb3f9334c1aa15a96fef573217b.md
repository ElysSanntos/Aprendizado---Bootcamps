# Aula 06 - Para saber mais: o formato JSON

O JSON (JavaScript Object Notation) é um formato de dados leve e popular para troca de informações entre sistemas, podendo ser utilizado em várias linguagens de programação.

O JSON é composto por dois tipos de estruturas de dados: **objetos** e **arrays**. Um objeto é uma coleção de pares **chave-valor**, onde as chaves são strings e os valores podem ser strings, números, booleanos, objetos ou arrays. Por exemplo:

```
{
  "nome": "João",
  "idade": 30,
  "solteiro": false,
  "endereco": {
    "rua": "Rua 123",
    "cidade": "São Paulo",
    "estado": "SP"
  },
  "telefones": [
    "1111-1111",
    "2222-2222"
  ]
}
```

Já um array é uma coleção ordenada de valores, que podem ser strings, números, booleanos, objetos ou outros arrays. Por exemplo:

```
[
  {
    "nome": "João",
    "idade": 30
  },
  {
    "nome": "Maria",
    "idade": 25
  },
  {
    "nome": "Pedro",
    "idade": 40
  }
]
```

O JSON é amplamente utilizado em aplicações, independente da linguagem de programação utilizada, para enviar e receber dados de APIs, sendo que para isso é recomendado utilizar alguma biblioteca que permita a serialização (conversão de objetos em JSON) e a desserialização (conversão de JSON em objetos).