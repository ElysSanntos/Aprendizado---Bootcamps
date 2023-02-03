# Aula 03 - Mão na massa: instalando o JDK

Vamos instalar o JDK! Para isso, siga os passos abaixo de acordo com seu sistema operacional. E, após instalado, prossiga para as configurações finais.

---

## **Instalando o JDK no Linux**

1) No Linux, primeiramente vamos ter que executar o seguinte comando no terminal:

```
sudo apt updateCOPIAR CÓDIGO
```

2) Feito isso, agora vamos instalar a versão 17 do JDK, que hoje é a mais recente, para isso, vamos executar o seguinte comando no terminal:

```
sudo apt install openjdk-17-jdkCOPIAR CÓDIGO
```

Caso queira, você poderá instalar uma versão mais antiga do JDK, você só terá que mudar o número da versão que fica entre `openjdk-` e `-jdk`, por exemplo, você pode instalar a versão 11 com: `openjdk-11-jdk` e a versão 8 com: `openjdk-8-jdk`, mas recomendamos que você instale a versão mais recente, no caso, a versão 17.

3) Terminado o processo de instalação, chegou a hora de configurar a variável de ambiente **JAVA_HOME**, que é utilizada para indicar o caminho de instalação do JDK. Em uma tradução literal seria o “lar do java” e ela será necessária para utilizarmos os recursos do JDK como o **javac**. Para isso, execute o comando `sudo update-alternatives --config java` que mostrará o caminho onde o JDK foi instalado. O resultado será parecido ou igual a esse:

![https://cdn1.gnarususercontent.com.br/1/4341/263dcb94-0fbf-44a2-9cea-6fae18cc8688.png](https://cdn1.gnarususercontent.com.br/1/4341/263dcb94-0fbf-44a2-9cea-6fae18cc8688.png)

Agora, copie esse caminho até /bin, por exemplo: `/usr/lib/jvm/java-17-openjdk-amd64/bin` e digite no seu terminal o comando: `export JAVA_HOME=`, sendo que após o sinal de igual, sem deixar espaços, cole o caminho que você copiou da instalação do JDK. Por exemplo:

`export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/bin`

Pressione `enter` e pronto, seu JDK está instalado e configurado. Para testá-lo, digite os seguintes comandos no terminal:

```
javac -version
java -versionCOPIAR CÓDIGO
```

## **Instalando o JDK no Mac**

No Mac você pode baixar a versão mais atual do JDK [aqui!](https://www.oracle.com/java/technologies/downloads/#jdk17-mac)

![https://cdn1.gnarususercontent.com.br/1/4341/828f7b0d-78f9-4919-8fa2-cc8c13272035.png](https://cdn1.gnarususercontent.com.br/1/4341/828f7b0d-78f9-4919-8fa2-cc8c13272035.png)

Escolha a opção de download compatível com a configuração do seu computador e faça a instalação a partir do instalador do JDK. Caso queira instalar uma versão mais antiga do JDK, descendo um pouco a página você encontrará opções de downloads para versões mais antigas.

Após a instalação no seu Mac, teste seu Java com os seguintes comandos no terminal:

`javac -version`

`java -version`

## **Instalando o JDK no Windows**

Por fim, para instalar no Windows, acesse [esse site](https://www.oracle.com/java/technologies/downloads/#jdk17-windows).

![https://cdn1.gnarususercontent.com.br/1/4341/f32d7c89-d44b-4c23-80cd-278904ac156d.png](https://cdn1.gnarususercontent.com.br/1/4341/f32d7c89-d44b-4c23-80cd-278904ac156d.png)

Escolha então o JDK (Java Development Kit) e, por fim, a versão do seu sistema operacional. Após baixado, execute o instalador e faça a instalação.

E, novamente, caso queira instalar uma versão mais antiga do JDK, descendo um pouco a página você encontrará opções de downloads para versões mais antigas.

### **Configurações do PATH(Variável de Ambiente) no Windows**

A partir daqui, caso queira assistir essas configurações em vídeo, no vídeo **[Instalação do JDK no Windows](https://cursos.alura.com.br/course/java-primeiros-passos/task/29328)** temos o passo a passo, ou acompanhe as configurações pelo tutorial abaixo:

1) Vá em painel de controle e procure por Sistema, após isso, clique em

**Configurações avançadas do sistema**

![https://cdn1.gnarususercontent.com.br/1/4341/893b20a1-d26c-4abf-97a0-997aa3aba85c.png](https://cdn1.gnarususercontent.com.br/1/4341/893b20a1-d26c-4abf-97a0-997aa3aba85c.png)

2) Na aba "Avançado", clique em

**variáveis de Ambiente...**

![https://cdn1.gnarususercontent.com.br/1/4341/98ebe6ad-ff3d-4d80-8597-4092926b56af.png](https://cdn1.gnarususercontent.com.br/1/4341/98ebe6ad-ff3d-4d80-8597-4092926b56af.png)

3) Na janela que foi aberta, na parte inferior da tela, selecione a variável de ambiente chamada

**Path**

e clique em

**Editar**

![https://cdn1.gnarususercontent.com.br/1/4341/c75d9fc5-9cd3-4bb8-9f2a-8188a744a5c2.png](https://cdn1.gnarususercontent.com.br/1/4341/c75d9fc5-9cd3-4bb8-9f2a-8188a744a5c2.png)

3) Nessa nova janela, clique no botão

**novo**

e nessa linha que foi selecionada (última), coloque o caminho para seu diretório

```
bin
```

dentro da pasta

```
jdk
```

, que por sua vez, está dentro da pasta java

![https://cdn1.gnarususercontent.com.br/1/4341/ef501ec2-7952-4b67-b484-95e1752eded7.png](https://cdn1.gnarususercontent.com.br/1/4341/ef501ec2-7952-4b67-b484-95e1752eded7.png)

4) Salve a mudança clicando em `OK` e feche todas as janelas.

5) Após feito isso, feche seu prompt de comando e o abra novamente.

Teste os seguintes comandos:

`java -version`

`javac -version`

Tudo ocorreu como esperado?