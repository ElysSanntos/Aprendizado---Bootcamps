public class SistemaInterno {

    private int senha = 2222;
    public void autentica(Autenticavel fa){

        boolean autenticou = fa.autentica(this.senha);
        if(autenticou) {
            System.out.println("Pode Acessar no sistema!");
        } else {
            System.out.println("Não pode acessar no sistema, verifique seus dados de acesso!");
        }

    }
}
