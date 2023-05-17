# Aula 06 - Diretivas

As diretivas são como atributos em um elemento DOM que informa o Angular para que adicione algum comportamento a este elemento. Sobre as diretivas que conheceu nesta aula, marque as afirmativas corretas.

*Selecione 3 alternativas*

Para utilizar o ngClass com expressão basta informar a classe seguida da expressão que retorne valor booleano.

É isso aí. Caso a expressão retorne true a classe declarada é aplicada, como no exemplo. A propriedade active vai ser alterada para o valor contrário ao atual, se for true muda para false e vice versa:

```
@Component({
  selector: 'app-home',
  template: `
    <div>
      <h1 [ngClass]="{'color-blue': active}">
        Home!
      </h1>
      <button (click)="colorBlue()">
          Mudar cor
      </button>
    </div>
  `,
  styles: [
  ]
})
export class HomeComponent {
  active: boolean = true;

  constructor() { }

  colorBlue(){
    this.active = !this.active
  }
}
```

A diretiva “*ngIf” é responsável por incluir ou excluir um elemento do template.

Isso aí. O elemento que recebeu a diretiva, caso a condicional for verdadeira, irá incluir o elemento no template, caso contrário, ele poderá excluir o elemento ou incluir um elemento declarado usando o elemento do Angular `<ng-template>`.

O “*ngFor” permite percorrer um array e exibir cada item como elemento no template.

A sintaxe é composta por uma variável local que recebe o valor de cada item percorrido seguido de qual será o array ou objeto iterável.

```
<div *ngFor="let pensamento of listaPensamento">
```