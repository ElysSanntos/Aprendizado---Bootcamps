# git add 

adiciona as modifições ou novos arquivos 
para que o GIT comece a versionar os mesmos

ex: git add index.html

# git commit

adiciona nas moficações para o repositório local

ex: git commit -m "criando nosso primeiro arquivo"

# git push

Enviar as modifições do repositório local para o 
repositório remoto

# git branch

checkout (apontar para outra branch)

comando: git checkout -b nova-branch

git branch -> lista todas as branchs
git checkout NOMEDABRANCH

## Apagando Branches Remotas
Para apagar uma branch remota nós fazemos um push e adicionamos o --delete. 
Entre o --delete indicamos o repositório remoto e o nome da branch a ser apagada

$ git push origin -d minha-branch

$ git push origin :minha-branch

## Renomeando Branches Remotas
$ git branch -m nome-atual novo-nome

## Após renomear a sua branch local, basta apagar a branch remota com o nome antigo e fazer um push com a branch com o novo nome
$ git push origin :nome-atual novo-nome

## Para terminar de ligar a branch local com a remota, entre na branch com o novo nome e execute

$ git push origin -u novo-nome

## Achando o culpado - Com o comando blame você pode ver quem alterou cada linha de um arquivo.
git blame nome-do-arquivo

### Para não ficar muito grande, podemos usar -w para ignorar espaços em branco e usar -L para indicar um intervalo de linhas a serem exibidas.
git blame -w -L 1,12 nome-do-arquivo

### E ainda podemos usar -e para que seja exibido o email ao invés do nome do usuário


# git pull

Recupera e atualiza todas as alterações que estão no 
repositório remoto e não estão no repositório local.

# git merge

Possibilita enviar as alterações da branch atualiza
para uma branch em questão

obs: devemos estar observando a branch de destino e 
usar o merge para a branch de origem

git merge nova-branch


