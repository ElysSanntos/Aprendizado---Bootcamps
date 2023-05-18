# Aula 06 - Injetando serviços

O uso de Services em Angular traz mais organização para a aplicação e permite um melhor gerenciamento das informações. Com base no que vimos sobre Services e Injeção de dependência, marque as afirmações corretas.

*Selecione 2 alternativas*

- O decorador @Injectable informa ao Angular que essa classe é injetável e com o metadado providedIn como root torna esse serviço visível em toda aplicação.
    
             O metadado providedIn: 'root', indica que o Angular deve fornecer o serviço no injetor raiz.
    
- Alternativa correta
    
    A injeção de dependência de um serviço é feita quando chamamos a função criada no serviço dentro do componente que depende desse serviço.
    
    A injeção acontece via construtor onde especificamos um parâmetro com o tipo da dependência e ao, colocar o modificador de acesso private, fazemos com que esse atributo seja automaticamente declarado como atributo dessa classe.
    
- Alternativa correta
    
    O Objetivo de um serviço é organizar e compartilhar regras de negócios, dados e métodos para diferentes componentes de uma aplicação por meio da injeção de dependência.
    
    Serviço em Angular são classes com o decorador @Injectable que informa ao Angular que pode ser injetado em componentes da aplicação.