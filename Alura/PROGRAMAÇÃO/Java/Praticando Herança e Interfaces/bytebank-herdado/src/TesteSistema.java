public class TesteSistema {

    public static void main(String[] args) {
        Gerente g = new Gerente();
        g.setSenha(2222);

        Administrador adm = new Administrador();
        adm.setSenha(3333);

        SistemaInterno si = new SistemaInterno();
        System.out.println();
        si.autentica(g);
        si.autentica(adm);


    }
}
