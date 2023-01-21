public class FluxoComTratamento {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
            metodo1();
        }catch (ArithmeticException | NullPointerException | MinhaException exception){
//            String msg = exception.getMessage();
//            System.out.println("ArithmeticException" + msg);
            exception.printStackTrace();

        }

        System.out.println("Fim do main");
    }

    private static void metodo1() throws MinhaException{
        System.out.println("Ini do metodo1");
            metodo2();
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() throws MinhaException {
        System.out.println("Ini do metodo2");
        //ArithmeticException exception = new ArithmeticException("Deu errado!");
        throw new MinhaException("Deu Errado!");
        //System.out.println("Ini do metodo2");
    }
}
