# Aula 10 - Você domina packages?

No desenvolvimento em Java, organizamos nossas classes em pacotes. Sobre esse tema é correto afirmar que:

Alternativa correta[x] 
Por organização e pela convenção adotada, precisamos seguir o domínio da empresa. Ou seja, se a empresa tem como domínio `alura.com.br`, os pacotes devem ser subpacotes de `br.com.alura`.
Correto, mas existem exceções (poucas).Alternativa correta[x] 
Quando um projeto utiliza pacotes, podemos usar o `import` de outras classes para sua utilização.
Correto! O `import` facilita o uso da classe pois não precisamos do *Full Qualified Name*.

O modificador *default* do Java restringe acesso a nível de pacote. Logo, se não for definido algum modificador, seja na classe, método, ou atributo, apenas classes do mesmo pacote podem acessar essas informações.

Correto, com *default* apenas classes do mesmo pacote podem acessar essas informações.