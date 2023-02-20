# Aula 02 - Array de clientes

Veja o código abaixo:

```
Cliente clienteNormal = new Cliente();
clienteNormal.setNome("Flavio");

Cliente clienteVip = new Cliente();
clienteVip.setNome("Romulo");

Object[] refs = new Object[5];
refs[0]  = clienteNormal;
refs[1]  = clienteVip;

System.out.println(refs[1].getNome());COPIAR CÓDIGO
```

Assumindo que o código está dentro de uma classe com método main, o código compila? E se compilar qual é a saída?

Não compila, por causa da linha:

`System.out.println(refs[1].getNome());`

Correto. Repare que o nosso array guarda referências do tipo `Object`. Ao acessar alguma posição no array recebemos então uma referência do tipo `Object`:

```
Object ref = refs[1];COPIAR CÓDIGO
```

Com essa referência em mãos **não** podemos chamar o método `getNome()`. Para fazer isso funcionar devemos fazer um *type cast* antes.