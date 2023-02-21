# Aula 08 - Conhece os wrappers?

Você está querendo ajudar o Pedro que está trabalhando com Java mas nunca aprendeu os generics. Ele te mostrou o código abaixo:

```
List referencias = new ArrayList(); //AQUI
referencias.add(Double.valueOf(30.9));
referencias.add(Integer.valueOf(10));
referencias.add(Float.valueOf(13.4f));COPIAR CÓDIGO
```

Com qual código você pode substituir a linha com o comentário `//AQUI` para usar *generics*?

*Selecione 2 alternativas*

`List<Object> referencias = new ArrayList<>();`

Correto, todas as referências também são *Object*s.

`List<Number> referencias = new ArrayList<>();`

Correto, todos os elementos dessa lista são números.