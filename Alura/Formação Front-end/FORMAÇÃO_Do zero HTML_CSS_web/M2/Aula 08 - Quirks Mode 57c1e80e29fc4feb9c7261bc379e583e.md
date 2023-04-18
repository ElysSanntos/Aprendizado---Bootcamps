# Aula 08 - Quirks Mode

Como vimos nessa aula, o uso do `<!DOCTYPE html>` é muito importante para que o navegador utilize o modo padrão e não o “Quirks Mode”. Pensando nisso, assinale a alternativa correta:

*Selecione uma alternativa*

O Quirks Mode é o modo em que o navegador adapta páginas web que estão em versões antigas para que funcionem, o que pode quebrar sua página em HTML 5. Portanto, esse modo deve ser evitado através do uso do `<!DOCTYPE html>`.

O Quirks Mode (modo peculiaridade) adapta as páginas antigas que não estão na versão 5 do HTML para que funcionem normalmente, causando quebras nas páginas HTML 5. Para evitá-lo basta aplicar o `<!DOCTYPE html>` antes de abrir a tag `<html>`, fazendo com que o navegador reconheça a versão 5 do HTML e funcione em modo padrão.

- O `<!DOCTYPE html>`  funciona normalmente se adotarmos outra maneira de declarar, como por exemplo: `<!doctype html>` , `<!DOCTYPE HTML>`
 e até `<!DoCtYpE hTmL>`. O que acontece é que existe um acordo de boas práticas para utilizar o `<!DOCTYPE html>` como padrão. .
- O papel principal do `<!DOCTYPE html>` é informar ao navegador sobre a versão do HTML, no caso, a versão 5 e não necessariamente a extensão desse arquivo.