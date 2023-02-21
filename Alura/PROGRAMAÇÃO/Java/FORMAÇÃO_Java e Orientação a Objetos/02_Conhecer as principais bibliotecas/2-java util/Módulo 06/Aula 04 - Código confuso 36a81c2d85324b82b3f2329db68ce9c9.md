# Aula 04 - Código confuso

O *Autoboxing / unboxing* pode ser confuso. Será que você desmistifica o código abaixo?

```
public class TesteWrapper {

    public static void main(String[] args){
        Integer ref = Integer.valueOf("3");
        ref++;
        System.out.println(ref);
    }
}COPIAR CÓDIGO
```

O código compila e roda? Qual seria resultado?

*Selecione uma alternativa*

Compila, roda e imprime 4.

Correto, realmente incrementa o valor inteiro, mesmo sendo uma referência. O que acontece por baixo dos panos é um autoboxing / unboxing na linha que incrementa a variável (`ref++`). Você pode imaginar que essa linha será substituída por três novas:

```
int valor = ref.intValue();
valor = valor + 1;
ref = Integer.valueOf(valor);COPIAR CÓDIGO
```

O valor é desembrulhado, depois incrementado e depois embrulhado de novo!