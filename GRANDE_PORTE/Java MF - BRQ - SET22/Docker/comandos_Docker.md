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
    3º recriar o container ==> docker run --name hello-word -p 80:80 -p 8000:80 docker/etting-started
    5º acessar o navegador ==> http://localhost

    

```
