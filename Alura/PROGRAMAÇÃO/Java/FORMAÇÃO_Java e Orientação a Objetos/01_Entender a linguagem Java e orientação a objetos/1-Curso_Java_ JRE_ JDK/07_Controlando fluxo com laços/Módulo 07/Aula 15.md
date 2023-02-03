# Aula 15 - Desafio opcional: Fatorial

Nesse exercício opcional, o seu desafio é imprimir os fatoriais de 1 a 10!

---

Você se lembra do fatorial? Não? Sem problemas, seguem as regras:

- O fatorial de 0 é 1.
- O fatorial de 1 é (0!) * 1 = 1.
- O fatorial de 2 é (1!) * 2 = 2
- O fatorial de 3 é (2!) * 3 = 6
- O fatorial de 4 é (3!) * 4 = 24
- O fatorial de um número n é n * n-1 * n-2 ... até n = 1.

Ou seja:

- O fatorial de 4! = 1 x 2 x 3 x 4 = 24
- O fatorial de 6! = 1 x 2 x 3 x 4 x 5 x 6 = 720

Agora crie uma nova classe, escreva um `for` que inicie uma variável `n` (número atual) como `1` e `fatorial` (resultado total) como `1`. Faça seu laço entre 1 a 10 e calcule o resultado!

Segue uma possível implementação:

```
class Fatorial {
    public static void main(String[] args) {
        int fatorial = 1;
        for (int i = 1; i < 11; i++) {
            fatorial *= i;
            System.out.println("Fatorial de " + i + " = " + fatorial);
        }
    }
}COPIAR CÓDIGO
```

O fatorial é sempre o produto de números consecutivos inteiros de 1 até o próprio número. Ex: Fatorial de 4 = 4 x 3 x 2 x 1 = 24 ou fatorial de 4 = 4 x 3! = 24. Com essa última lógica é que essa questão é feita. Pegando sempre o número que a gente quer e multiplicando pelo fatorial do número anterior.