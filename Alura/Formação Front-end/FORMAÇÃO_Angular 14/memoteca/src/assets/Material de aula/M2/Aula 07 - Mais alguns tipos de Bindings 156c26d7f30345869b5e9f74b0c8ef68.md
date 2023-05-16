# Aula 07 - Mais alguns tipos de Bindings

Nesta aula vimos como podemos fazer a comunicação de dados entre template e componente com auxílio do data binding, os diferentes tipos e quais os recursos necessários para usá-los.

Das afirmações abaixo, assinale as que são verdadeiras.

*Selecione 3 alternativas*

- Ao usar `{{ pensamento.conteudo }}`, o Angular insere o valor do atributo do componente no template.
    
    A interpolação permite a visualização do valor de uma propriedade do componente no template com o uso de chaves duplas. `{{ nome-da-propriedade }}`.
    
- Alternativa correta
    
    Para enviar informação do typescript para o template, utilizamos colchetes na propriedade da tag html, como no exemplo: `[src]=”imagem”`.
    
    O property binding funciona no mesmo sentido da interpolação, unidirecional, vindo a informação do componente para o template. É representado pelo uso de colchetes em atributos de elementos HTML.
    
- Alternativa correta
    
    Two-way data binding mantém a informação atualizada nas duas pontas da comunicação.
    
    Este binding combina o recurso do property binding e o event binding em uma única notação usando a diretiva `ngModel.[(ngModel)]=”nome-da-propriedade”`.