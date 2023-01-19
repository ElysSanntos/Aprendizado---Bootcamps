/*Definimos um contrato
* Quem assinar Esse contrato precisa implementar:
* o metodo setSenha
* O metodo autentica
* */
public abstract interface Autenticavel {


    public abstract void setSenha(int senha);

    public abstract boolean autentica(int senha);
}
