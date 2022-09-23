
#Comentários

# o que é o Dockerfile?
# é um arquivo na qual o Docker usa para saber como criar uma imagem (é um passo-a-passo
# Em geral, quando vamos criar a nossa imagem partimos de uma outra imagem padrão


# Exemplo: pegando a última imagem do servidor web nginx
FROM nginx:latest

# copiando o arquivo conf.txt para a raiz da imagem (futuro container)
COPY conf.txt /

# apt-get update no linux atualiza todos os possíveis pacotes que podemos instalar
RUN apt-get update

# instalando o editor de texto nano
RUN apt-get install nano -y











