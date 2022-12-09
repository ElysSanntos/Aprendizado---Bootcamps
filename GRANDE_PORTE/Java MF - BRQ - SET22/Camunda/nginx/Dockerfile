# o que é o Dockerfile?
# é um arquivo na qual o Docker usa para saber como criar uma imagem (é um passo-a-passo
# Em geral, quando vamos criar a nossa imagem partimos de uma outra imagem padrão

# para partir de uma imagem, devemos usar a palavra FROM
# Exemplo: pegando a última imagem do servidor web nginx
FROM nginx:latest

# copiando o arquivo conf.txt para a raiz da imagem (futuro container)
COPY conf.txt /

# apt-get update no linux atualiza todos os possíveis pacotes que podemos instalar
RUN apt-get update

# instalando o editor de texto nano
RUN apt-get install nano -y

# para criar a nossa própria imagem, devemos usar o comando docker build 
# docker build -t NOME-DA-IMAGEM:TAG .
# ex: docker build -t brq-nginx:latest .
# docker run -d --name brq-nginx-container -p 90:80 brq-nginx:latest
# docker run -d --name brq-nginx-container-1 -p 95:80 brq-nginx:latest


