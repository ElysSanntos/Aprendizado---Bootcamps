public class P1E02 {
	public static void main(String[] args) {
		int q1   = 200;
		int q2   = 310;
		int q3   = 412;
		int q4   = 250;
		int q5   =  30;
		int q6   =  10;
		double D =  5.15;
		double R = (q1 
				   +q2 * 0.50 
				   +q3 * 0.25 
				   +q4 * 0.10
				   +q5 * 0.05 
				   +q6 * 0.01) * D;
		System.out.println("reais = R$"+R);
	}
}