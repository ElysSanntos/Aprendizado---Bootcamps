public class P1E04 {
	public static void main(String[] args) {
		int hora    = 10;
		int minuto  = 24;
		int segundo = 30;
		int passou  = hora * 3600 + minuto * 60 + segundo;
		int faltam  = 86400 - passou;
		System.out.println("Passou = " + passou + "s");
		System.out.println("Faltam = " + faltam + "s");
	}
}