public class Fluxo {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
            metodo1();
        }catch (ArithmeticException | NullPointerException | MinhaException exception){

            exception.printStackTrace();

        }

        System.out.println("Fim do main");
    }

    private static void metodo1() throws MinhaException {
        System.out.println("Ini do Método 1");

            metodo2();

        System.out.println("Fim do Método 1");
    }

    private static void metodo2() throws MinhaException {
        System.out.println("Ini do Método 2");
        throw new MinhaException("Deu muito errado na classe Fluxo.");

        //System.out.println("Fim do Método 2");
        }

    }

