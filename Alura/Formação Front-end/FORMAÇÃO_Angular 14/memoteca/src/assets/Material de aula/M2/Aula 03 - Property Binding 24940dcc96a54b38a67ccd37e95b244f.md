# Aula 03 - Property Binding

Agora que nosso formulário já está criado, adicionaremos um comportamento a ele para poder guardar as informações que a pessoa usuária inserir e aplicar uma lógica no ato de salvar.

O responsável por configurar a lógica do formulário é o arquivo TS, ou *component*, da classe `typescript`, . Portanto quando a gente se referir ao arquivo `component` estaremos nos referindo ao arquivo TS.

Já o responsável pela visualização e interação da pessoa usuária na nossa página é o arquivo HTML, ou *template*.

Agora que conhecemos as funções destes dois arquivos, aprenderemos sobre o fluxo de dados dentro de componentes do Angular, e sobre como os arquivos interagem entre si.

Para facilitar, vamos imaginar o seguinte contexto: Estamos na plateia de um grande desfile de moda. Nos bastidores, existem pessoas agindo para que o desfile aconteça e não podemos vê-las. Depois de tudo pronto, o desfile começa e vemos um fluxo de pessoas que vêm dos bastidores até a passarela.

Considere o seguinte paralelo:

- os bastidores são a classe *typescript* ou *component*;
- As pessoas são os atributos;
- As ações que as pessoas estão realizando nos bastidores são os métodos ou eventos da classe;
- A passarela é o *template*, ou HTML, responsável pela visualização.

Da mesma forma que as pessoas foram dos bastidores para a passarela, nós vamos fazer com que alguns dados que estão na classe sejam visualizados no HTML.

Para isso, abriremos o arquivo `criar-pensamento.component.ts` e criaremos o atributo `pensamento`, que será um objeto com as propriedades `id`, `conteudo`, `autoria` e `modelo`.

```
pensamento = {
    id: ´1´,
    conteudo: ´Aprendendo Angular´,
    autoria: ´Dev´,
    modelo: ´´
}COPIAR CÓDIGO
```

Associaremos os atributos de `pensamento` aos *inputs* de `pensamento` e de `autoria` no formulário do HTML. Para isso, vamos adicionar o atributo `value` entre colchetes e incluir os conteúdos dos *inputs*.

```
<input>
    //trecho de código omitido
    [value]="pensamento.conteudo"
</input>

<input>
    //trecho de código omitido
    [value]="pensamento.autoria"
</input>COPIAR CÓDIGO
```

Agora, se a gente observar a página do navegador, os valores que colocamos em `pensamento` e `autoria` e que inserimos no HTML aparecem no formulário, nos campos de "Pensamento" e "Autoria ou fonte".

O uso de colchetes faz parte de um tipo de associação de dados unidirecional chamada "*Property Binding*". Se não utilizarmos os colchetes, o *Angular* não vai renderizar o atributo. Em vez disso ele vai interpretar a string `"pensamento.conteudo"` como um texto literal.

**E como lembramos futuramente de inserir os colchetes?**

Vamos voltar à imagem do desfile e desenvolver o seguinte raciocínio: alguém te pede para tirar fotos das pessoas na passarela. Imagine que está segurando uma câmera na altura do seu rosto, direcionada para a passarela. As suas mãos neste momento estarão num formato que lembrará muito os colchetes.

Se descermos a página, perceberemos que o conteúdo inserido em "Pensamento" e em "Autoria ou fonte" não está sendo exibido nas prévias. Para renderizarmos esse conteúdo, utilizaremos o recurso de "*Property Binding*" nos três modelos, só que agora com outra sintaxe.

A sintaxe que vamos digitar utiliza duas chaves `{{}}` em vez de colchetes `[]`, e se chama "*Property Binding* com Interpolação". Como boa prática de programação, sempre damos um espaço entre as chaves duplas e o seu conteúdo.

**Modelo 1**

```
//Trecho de código omitido
                    Prévia:
                    <div class="modelo modelo1 ff-roboto-mono">
                        <img src="../../../../assets/imagens/modelo1.png" alt="Aspas azuis">
                        <p class="conteudo">{{ pensamento.conteudo }}</p>
                        <p class="autoria"><b>{{ pensamento.autoria }}</b></p>
                    </div>
//Trecho de código omitidoCOPIAR CÓDIGO
```

**Modelo 2**

```
//Trecho de código omitido
                    Prévia:
                    <div class="modelo modelo2 ff-roboto-mono">
                        <img src="../../../../assets/imagens/modelo2.png" alt="Aspas azul claro">
                        <p class="conteudo">{{ pensamento.conteudo }}</p>
                        <p class="autoria"><b>{{ pensamento.autoria }}</b></p>
                    </div>
//Trecho de código omitidoCOPIAR CÓDIGO
```

**Modelo 3**

```
//Trecho de código omitido
                    Prévia:
                    <div class="modelo modelo3 ff-roboto-mono">
                        <img src="../../../../assets/imagens/modelo3.png" alt="Aspas verdes">
                        <p class="conteudo">{{ pensamento.conteudo }}</p>
                        <p class="autoria"><b>{{ pensamento.autoria }}</b></p>
                    </div>
//Trecho de código omitidoCOPIAR CÓDIGO
```

**Por que usamos uma sintaxe diferente?** O `input` possui propriedades que podem ser referenciadas, já a *tag* `p` não possui conteúdo referenciável. Entretanto, as duas sintaxes funcionam da mesma forma, inserindo a propriedade da classe ou "*component*" e renderizando no "*template*".

Agora, voltando ao navegador, podemos ver as prévias funcionando. Em seguida exploraremos o "*Event Binding*" e como ele funciona.