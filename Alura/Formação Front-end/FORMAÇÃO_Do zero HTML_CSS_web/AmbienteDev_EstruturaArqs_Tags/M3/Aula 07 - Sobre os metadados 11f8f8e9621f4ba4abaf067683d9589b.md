# Aula 07 - Sobre os metadados

Quando construímos a estrutura básica de tags do HTML, inserimos meta tags dentro da tag `<head>`. As tags meta determinam os metadados, que são as informações sobre dados de um documento HTML. Logo abaixo, podemos visualizar os metadados que colocamos no código do projeto Portfolio.

```
 <meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">COPIAR CÓDIGO
```

Dadas as afirmações abaixo, selecione as alternativas corretas sobre metadados:

*Selecione 2 alternativas*

O metadado `http-equiv="X-UA-Compatible" content="IE=edge"` é utilizado para configurar a página web no Internet Explorer, para que ela esteja sempre em sua versão mais recente.

Exatamente esse metadado é utilizado para configurar a página para ser renderizada como em outra versão do Internet Explorer. Caso não definirmos esse metadado, o Internet Explorer, especificamente, pode encontrar problemas de compatibilidade, por isso é importante utilizarmos essa tag meta pois o usuário final pode estar utilizando este navegador.

O metadado `charset="UTF-8"` é empregado para repassar aos navegadores qual é o formato de codificação de caracteres utilizado naquele documento.

Ao utilizarmos a tag meta `charset="UTF-8”`, estamos comunicando aos navegadores que a codificação daquela página é a UTF-8, o padrão de codificação mais utilizado, também conhecido por Unicode. Com esse padrão as informações são unificadas ao redor do mundo e os navegadores renderizam todos os conteúdos a partir das regras estabelecidas pelo UTF-8.

- Informamos para o navegador as medidas da tela para definir a largura que será renderizada na página, mas não remetemos qual o dispositivo que está usado.