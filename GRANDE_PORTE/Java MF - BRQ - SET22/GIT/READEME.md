# Comandos básicos do Git

> - **git add (nome do arquivo)** 

>>> adiciona as modifições ou novos arquivos 
para que o GIT comece a versionar os mesmos
ex: git add index.html

> - **git add .** 
>>> adiciona as modifições em todos os arquivos alterados 

> - **git commit -m "mensagem do commit"**

>>>adiciona nas moficações para o repositório local 

> - **git push**

>>>Enviar as modifições do repositório local para o repositório remoto

> - criar nova branch

>>>checkout (apontar para outra branch)
>>>**git checkout** -b nova-branch
>>>**git branch** -> sabemos quais branches temos no nosso repositório
>>>**git checkout** NOMEDABRANCH ->Te leva para a branch desejada
>>>**git push** -u origin nova-branch -> Commita uma nova branch

> - **git pull** 
>>>Recupera e atualiza todas as alterações que estão no repositório remoto e não estão no repositório local.

> - **git merge nova-branch**
>>>Possibilita enviar as alterações da branch atualiza para uma branch em questão
obs: devemos observar a branch de destino e usar o merge para a branch de origem

> - **.ignore**
>>>As alterações realizadas em arquivos que já estão no repositório remoto, não sofrem alteração. 
> **Para corrigir, precisa deletar o arquivo do remoto, add no .ignore e commitar**
