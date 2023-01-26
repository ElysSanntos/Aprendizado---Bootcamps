# Aula 06 - Quais casts

Continuando com a mesma hierarquia de classes:

![https://caelum-online-public.s3.amazonaws.com/850-java-util/02/hierarquia_funcionario.png](https://caelum-online-public.s3.amazonaws.com/850-java-util/02/hierarquia_funcionario.png)

E a declaração do array:

```
Funcionario[] referencias = new Funcionario[5];

referencias[0] = new Designer();

???? ref = (????) referencias[0];COPIAR CÓDIGO
```

O que podemos colocar no lugar de `????` para o código compilar?

*Selecione 3 alternativas*

- `Designer`
    
    Correto, como o `Designer` é um `Funcionario` o cast é possível (compila) e também rodaria normal.
    
- Alternativa correta
    
    `Gerente`
    
    Correto, como o `Gerente` é um `Funcionario` o cast é possível e compila (mas ao rodar daria `ClassCastException`).
    
    `Object`
    
    Correto, no final todas as referências no array são do tipo `Object`. Usando `Object` o cast não precisa ser explícito, basta:
    
    ```
    Object ref = referencias[0];
    ```