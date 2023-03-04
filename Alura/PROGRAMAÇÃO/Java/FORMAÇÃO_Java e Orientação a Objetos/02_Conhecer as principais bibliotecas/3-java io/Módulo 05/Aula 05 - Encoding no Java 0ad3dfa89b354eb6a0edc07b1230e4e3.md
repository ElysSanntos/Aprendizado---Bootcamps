# Aula 05 - Encoding no Java

Pedro deseja testar os ensinamentos do vídeo. Então ele criou uma string com caracteres especiais em português, converteu-os em bytes e depois gerou nova string a partir desses bytes. Contudo, quando ele imprimiu a segunda string ele obteve um problema na codificação.

Veja o código de Pedro:

```
String s1 = "13º Órgão Oficial";
byte[] bytes = s1.getBytes();
String s2 = new String(bytes, "UTF-8");
System.out.println(s2);COPIAR CÓDIGO
```

Veja o valor impresso no console:

```
13? ?rg?o OficialCOPIAR CÓDIGO
```

Você consegue ajudar Pedro indicando a alternativa com a correção?

*Selecione uma alternativa*

`Charset utf8 = StandardCharsets.UTF_8;
String s1 = "13º Órgão Oficial";
byte[] bytes = s1.getBytes(utf8);
String s2 = new String(bytes, utf8);
System.out.println(s2);`

Isso aí!