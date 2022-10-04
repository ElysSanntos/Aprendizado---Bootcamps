public class TestaFrio {
	public static void main(String[] args) {
		try {
			int cont = 0;

			PrevisaoDoTempo ze = new PrevisaoDoTempo();

			while (cont < 100) {
				System.out.println(ze.getTemperatura()+"ºC");
				cont++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}