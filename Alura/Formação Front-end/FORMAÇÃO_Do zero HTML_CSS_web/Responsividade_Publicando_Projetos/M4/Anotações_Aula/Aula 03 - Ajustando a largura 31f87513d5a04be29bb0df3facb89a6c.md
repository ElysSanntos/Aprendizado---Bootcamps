# Aula 03 - Ajustando a largura

No vídeo o Gui e a Rafa definiram uma largura automática para a seção "apresentação conteúdo” com o `width: auto;`, existe outra forma de fazer isso que é muito utilizada na versão mobile.

Assinale a alternativa abaixo que apresenta a forma correta para a versão mobile.

*Selecione uma alternativa*

```@media (max-width: 1200px) {

    `.apresentacao__conteudo{
            width: 100%;
}`
}
```

Dessa forma, aplicando 100% na largura da página responsiva, ela vai ter o mesmo resultado que o `width: auto;` e vai acompanhar o tamanho da tela de forma automática.