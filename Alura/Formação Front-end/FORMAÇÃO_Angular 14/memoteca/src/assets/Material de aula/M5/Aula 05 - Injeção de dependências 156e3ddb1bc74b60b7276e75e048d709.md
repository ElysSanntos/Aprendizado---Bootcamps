# Aula 05 - Injeção de dependências

Imagine a seguinte situação: em um dia agitado, não foi possível cozinhar a sua própria refeição e você decidiu ir até um restaurante e enfrentou processos como trânsito e filas de pagamento para conseguir se alimentar. Seu almoço seria mais prático se o pedido viesse até você através de um aplicativo de entrega. Ao realizar um pedido nestes aplicativos você não se responsabiliza pelos processos que ocorrem no trajeto, que passam a ser responsabilidade do serviço de entrega.

Este é um exemplo simples de **injeção de dependência**, onde a comida faz o papel de dependência. Entenderemos como utilizar este conceito no *Angular*.

Acessaremos o arquivo `pensamento.service.ts` e adicionaremos o `HttpClient` para conseguirmos inserir os métodos do "CRUD", pois a classe `PensamentoService` possui uma dependência em relação à essa classe.

Nós queremos que essa classe "venha até nós" sem instanciá-la diretamente no `PensamentoService`, assim como ocorre no aplicativo de entrega de refeições. Para isso, criaremos dentro do `constructor` um parâmetro de nome `http` com o modificador de acesso `private`, e com o tipo de dependência `HttpClient`. O `private` permite que o atributo seja declarado automaticamente como atributo da classe.

```
export class PensamentoService {
    constructor(http: HttpClient) { }
}COPIAR CÓDIGO
```

Tenha certeza de que o `HttpClient` foi importado conferindo se o código abaixo foi inserido automaticamente pela aplicação. Em caso negativo, adicione essa importação manualmente.

```
import { HttpClient } from '@angular/common/http';COPIAR CÓDIGO
```

Com estes passos concluídos, temos acesso a todos os métodos da classe `HttpClient`. De acordo com a documentação do *Angular*, a injeção de dependências é um padrão de projeto no qual uma classe solicita dependências externas ao invés de criá-las. Se este conceito for novidade para você, fique à vontade para acessar o [artigo que escrevi sobre serviços e injeção de dependências no *Angular* neste link](https://www.alura.com.br/artigos/services-injecao-dependencia-angular-o-que-sao-como-funcionam). Nos vemos no próximo vídeo!