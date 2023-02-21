# Aula 06 - Resumo

Neste vídeo faremos uma breve revisão do que foi visto neste capítulo.

Vimos, de forma geral, os mundos da entrada `Input`, e da saída, `Output`. Estes mundos se subdividem em `InputStream` e `Reader` no primeiro caso, e `OutputStream` e `Writer` no segundo.

Além disso, temos a divisão entre *streams*, e *readers* e *writers*. `InputStream` e `OutputStream` lidam com dados binários, por exemplo imagens e PDFs, já se estivermos lidando com caracteres, utilizamos o `Reader` ou `Writer`.

Há ainda as classes que fazem a transição de um mundo para outro, como é o caso da `InputStreamReader`, que recebe um `InputStream` de bytes e o transforma em um `Reader`. Da mesma forma, temos o `OutputStreamWriter`, que faz o mesmo, só que para a escrita. Estas classes possuem padrões de projetos, próprios do `java.io`.

Com essa base, podemos partir para outras classes como `Scanner` e `PrintStream`. Até a próxima!