# 09 - Mãos na massa: Contas

1) Antes de mexer com o projeto de *contas*, feche o projeto sobre **Funcionarios**. Depois abra o projeto de **contas**.

2) Transforme a classe **Conta** em abstrata, já que não devemos poder instanciar apenas uma conta, mas sim uma conta corrente ou poupança. Fique atento aos erros de compilação e corrija-os.

3) Transforme o método **deposita** em abstrato, veja o código abaixo:

```
public abstract void deposita(double valor);COPIAR CÓDIGO
```

4) Repare que nossas outras classes deixaram de compilar. Isso acontece devido ao fato de que agora essas classes filhas devem implementar o método **deposita**.

Implemente o método **deposita** nas classes filhas. Lembre-se de antes transformar o atributo **saldo** da classe **Conta** para **protected**, permitindo que as classes filhas o vejam.

O método deve ficar assim:

```
@Override
public void deposita(double valor){
    super.saldo += valor;
}COPIAR CÓDIGO
```

5) Rode o teste e veja se tudo continua funcionando normalmente!