public class P1E03 {
	public static void main(String[] args) {
		double C,F,K,Ra,Re;
		C  = 26.0;
		F  = C * 1.8 + 32;
		K  = C + 273.15;
		Ra = C * 1.8 + 32 + 459.67;
		Re = C * 0.8;
		System.out.println("F  = " + F );
		System.out.println("K  = " + K );
		System.out.println("Ra = " + Ra);
		System.out.println("Re = " + Re);
	}
}