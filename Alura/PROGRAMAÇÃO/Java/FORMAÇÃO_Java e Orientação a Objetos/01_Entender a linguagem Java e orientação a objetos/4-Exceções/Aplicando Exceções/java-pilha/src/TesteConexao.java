public class TesteConexao {
    public static void main(String[] args) {

        /*Novo try que simplifica o código*/

        try(Conexao conexao = new Conexao()) {
            conexao.leDados();

        }catch (IllegalStateException illegalStateException){
            System.out.println("Erro de conexão");
        }


        /*Código legado*/

//        Conexao conexao = null;
//        try {
//            conexao = new Conexao();
//            conexao.leDados();
//
//        }catch (IllegalStateException illegalStateException){
//            System.out.println("Erro de conexão");
//
//
//        }finally {
//            System.out.println("finally");
//            if (conexao != null){
//                conexao.close();
//            }
//        }
    }
}
