# Aula 02 - Lendo arquivos com Scanner

Qual a forma correta de ler arquivos utilizando nossa classe Scanner?

*Selecione uma alternativa*

`Scanner sc = new Scanner(new File("arquivo.txt"));`

Correto! Neste caso o scanner vai conseguir ler o conteúdo do arquivo. Importante é que usamos um objeto `File` para realmente abrir um arquivo.

- precisamos passar um arquivo (File) pro Scanner.
- preciso passar um objeto do tipo File pro Scanner no construtor para fazer a leitura funcionar.