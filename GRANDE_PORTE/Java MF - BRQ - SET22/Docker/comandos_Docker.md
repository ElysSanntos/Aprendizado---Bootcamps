<h2 align = "center" >Aula 2  - Docker - 15/09/2022<h2>

<h3 align = "center" ><a href="https://github.com/ffborelli/">Professor: Fabrizio Borelli</a></h3>
</br></br>

 
 


# Principais comandos

## Como iniciar um container (que ainda não existe)?

```

    docker run NOME-DA IMAGEM

    docker run docker/getting-started
```

## para listar os container que estão em execução

```
    docker ps
    docker ps -a    ==> lista todos os containers
```

# Se eu quiser parar a execuções de um container:

```
    docker stop NOMEDOCONTAINER
    Ex: docker stop objective_euler
```

# Se eu quiser iniciar um container que já existe:

```
    docker start NOMEDOCONTAINER
    Ex: docker start objective_euler
```

# Para remover um container:

Obs: o container deve estar parado.

```
    docker run NOMEDOCONTAINER
    Ex: docker rm objective_euler
```

# Eu posso definir o nome de um container

Obs: exemplo na criação do container
O nome da imagem sempre precisa ser o último parâmetro do docker run

```
    docker run  --nane NOMEDOCONTAINERDESEJO NOMEDAIMAGEM
    Ex: docker run --name hello-world docker/getting-started
```

# redirecionar a requisição da máquina hospedeira para um container docker

Obs: exemplo na criação do container


```
    docker run  --name NOMEDOCONTAINERDESEJO -p PORTA-HOSPEDEIRO:PORTA-CONTAINER  NOMEDAIMAGEM
    
    1º parar o conteiner   ==> docker stop hello-world
    2º excluir o conteiner ==> docker rm hello-world
    3º recriar o container ==> docker run --name hello-word -p 80:80 -p 8000:80 docker/getting-started
    5º acessar o navegador ==> http://localhost

    

```

<h2 align = "center" >Aula 3  - Docker - 20/09/2022<h2>

<h3 align = "center" ><a href="https://github.com/ffborelli/">Professor: Fabrizio Borelli</a></h3>
</br></br>


# Acessar terminal do container


```
Obs: O container deve estar executando
    docker exec -it NOMEDOCONTAINER /bin/bash

    /bin/bash (terminal) é o comando que vamos executar quando ao entrar no container 
    -it -> 'modo interativo'

Ex: docker exec -it hello-word /bin/bash
                OU
docker exec -it hello-word /bin/sh

/ # ==Significa que estamos dentro do terminal do container

```
# Comandos básicos Linux

```
ls     ==> Listar arquivos e pastas no Linux
ls -R  ==> vai listar todos os arquivos nos subdiretórios
ls -a  ==> vai mostrar todos os arquivos ocultos
ls -al ==> vai listar todos os arquivos e diretórios com informações detalhadas como permissões, tamanho, proprietário, etc.
cd     ==> entrar dentro de uma pasta
pwd    ==> mostrar em qual diretório estamos
cd..   ==> voltar um nível no sistema de diretórios
cd     ==> para ir diretamente para a pasta home
cd–    ==> (com um hífen) para mover para os diretórios anteriores
cd /   ==> Volta para o diretório anterior
touch  ==> criar um arquivo vazio
exit   ==> sai do terminal do container e volta para o terminal da máquina
cat file.text ==> cria um novo arquivo
cat filename1 filename2>filename3 ==> junta dois arquivos (1 e 2) e armazena a saída deles num novo arquivo (3)
cat filename | tr a-z A-Z >output.txt ==> converter um arquivo para usos de maiúscula ou minúscula
mkdir Music ==> criar um novo diretório chamado Music
mkdir Music/Newfile ==>gerar um novo diretório dentro de outro diretório
mkdir -p Music/2020/Newfile ==> use a opção p (parents) para criar um diretório entre dois diretórios existentes,vai criar o novo arquivo “2020”.
rmdir ==>só permite que você apague diretórios vazios (sem conteúdos)
rm ==> apagar um diretório e todos os conteúdos que estiverem lá dentro
rm -r ==> deletar o diretório
find . -name notes.txt ==> ncontrar arquivos no diretório atual,
/ -type d -name notes. txt ==> procurar por diretórios
sudo  ==> permite que que você execute tarefas que exigem permissões root ou administrativas. Porém, não é muito aconselhável usá-lo diariamente porque pode ser que um erro aconteça se você fizer algo de errado.  

```

<h2 align = "center" >Aula 4  - Docker - 21/09/2022<h2>

<h3 align = "center" ><a href="https://github.com/ffborelli/">Professor: Fabrizio Borelli</a></h3>
</br></br>


# dentro do container, iremos criar uma pasta

```
    mkdir pasta1
```

Para sair do container, digite:         exit

# Removendo o container para verificar o que acontece com o seu conteúdo

```
    docker stop hello-word
    docker rm hello-word
```

# Subindo um novo container da mesma imagem

```
    docker run --name hello-world -p 80:80 -p 8000:80  docker/getting-started
    docker exec -it hello-world /bin/sh
    ls
```

## Como podemos fazer para ao deletar um container, não perdermos dados do mesmo?

### Resp: usando o conceito de volume

```
    docker run -v PASTA_DO_HOSPEDEIRO:PASTA_DO_CONTAINER

    docker rm hello-world
    
    docker run --name hello-world -p 80:80 -p 8000:80 -v ${PWD}/meu-volume_SO:/meu-volume-container docker/getting-started

    docker exec -it hello-world /bin/sh

cd meu-volume-container/
touch arquivo.txt
tail -f arquivo.txt 
docker run --name hello-world -p 80:80 -p 8000:80 -v ${PWD}/meu-volume:/meu-volume-container docker/getting-started
docker exec -it hello-world /bin/sh
cd ..
touch t.txt
docker run --name hello-world -p 80:80 -p 8000:80 -v ${PWD}/meu-volume:/meu-volume-container-3 docker/getting-started

```

## Criar uma imagem de MySql
```
docker run -d --name=mysql-java-1 -p 3306:3306 --env="MYSQL_ROOT_PASSWORD=root" -v ${PWD}/mysql-datadir:/var/lib/mysql    mysql

```

## Para acessar o Banco de dados
```
mysql -uroot -proot

```
## Criando um dataBase

```

create database db_correntista;

use db_correntista;

create table contas (cd_contas int primary key auto_increment, nome varchar(40));

show databases;

insert into contas (nome) VALUES ('JUAN');
insert into contas (nome) VALUES ('Maria');

select * from contas;

```



<h2 align = "center" >Aula 5  - Docker - 22/09/2022<h2>

<h3 align = "center" ><a href="https://github.com/ffborelli/">Professor: Fabrizio Borelli</a></h3>
</br></br>

# nginx

## o que é o Dockerfile?

```
É um arquivo na qual o Docker usa para saber como criar uma imagem (é um passo-a-passo). Em geral, quando vamos criar a nossa imagem partimos de uma outra imagem padrão

```
## Para partir de uma imagem, devemos usar a palavra FROM
### O comando abaixo deve ser inserido no arquivo **Dockerfile**
### **latest** é a versão mais recente da imagem

```
FROM nginx:latest

COPY conf.txt /

```

## Documentação: 

https://hub.docker.com/_/nginx

## Baixar imagem nginx
```
docker run --name nginx -p 80:80 nginx:latest

```
## copiando o arquivo conf.txt(criado na pasta ngnix) para a raiz da imagem (futuro container)
```

1 . cd nginx

2 . COPY conf.txt /

```

## Para criar a nossa própria imagem, devemos usar o comando docker build 
```

 docker build -t NOME-DA-IMAGEM:TAG .
 
 docker build -t brq-nginx:latest .

 ```
 ## Verificar as imagens existentes
 ```

 docker images    ==> Verifica quantas imagens temos no container

```
## Subir nosso container
```
 docker run --name brq-nginx-container -p 90:80 brq-nginx:latest

 ```

## Visualizar a nossa imagem via Browser

```
 http://localhost:90/   

 ```
 ## Entrar no container criado
 ```
 docker exec -it brq-nginx-container /bin/sh

 ls ==> visualizar o conteúdo do container.

 ```

 ## Criar uma nova instancia do nosso container

 ```
 docker run -d --name brq-nginx-container-instanciado -p 100:80 brq-nginx:latest

 ** Usar porta diferente
 ** -d ==> detash significa separar, isso vai liberar o console para continuar sendo usado

 ```

## Atualizar todos os possiveis pacotes que podemos vir a instalar. Deve ser setado no arquivo Dockerfile.

```
RUN apt-get update 
RUN apt-get install nano -y

```

## Construir novamente a imagem

```
docker build -t brq-nginx:latest .

```
## Recriar o container com a nova versão

```
docker run -d --name brq-nginx-container -p 90:80 brq-nginx:latest

docker run -d --name brq-nginx-1-container -p 95:80 brq-nginx:latest

```

<h2 align = "center" >Aula 6  - Docker - xx/09/2022<h2>

<h3 align = "center" ><a href="https://github.com/ffborelli/">Professor: Fabrizio Borelli</a></h3>
</br></br>




