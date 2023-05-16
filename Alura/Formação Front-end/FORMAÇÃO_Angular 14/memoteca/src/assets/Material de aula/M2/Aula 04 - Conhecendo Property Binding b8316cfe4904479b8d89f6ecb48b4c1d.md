# Aula 04 - Conhecendo Property Binding

Cláudia está aplicando seus conhecimentos em Angular desenvolvendo um componente de perfil de usuário, onde deseja apresentar o nome e a foto de perfil do usuário. Com o uso do property binding, Cláudia testou algumas formas diferentes de mostrar esses dados, mas uma não está correta.

```
@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styles: []
})
export class PerfilComponent {
  usuario = {
    nome: 'Cláudia Ohio',
    imgPerfil: './assets/foto-1445.jpg'
  }
}
```

Marque as alternativas corretas de acordo com o uso do property binding:

*Selecione 2 alternativas*

`<div class="card-perfil">
    <p>{{usuario.nome}}</p><img src="{{usuario.imgPerfil}}" alt="Imagem de perfil">
</div>`

A interpolação é a incorporação de expressões em texto com o uso de chaves duplas como delimitadores.

`<div class="card-perfil">
    <p [textContent]="usuario.nome"></p><img [src]="usuario.imgPerfil" alt="Imagem de perfil">
</div>`

A vinculação de propriedades ajuda a definir o valor de uma propriedade criada dentro do componente para uma propriedade de um elemento HTML. para isso basta colocar a propriedade entre colchetes e passar como valor a propriedade do componente.