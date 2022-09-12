public class P1PRF {
	public static void main(String[] args) {
		int ANO = 2011;
		int a = ANO % 19;
		int b = ANO / 100;
		int c = ANO % 100;
		int d = b / 4;
		int e = b % 4;
		int f = (b + 8) / 25;
		int g = (b - f + 1) / 3;
		int h = (19 * a + b - d - g + 15) % 30;
		int i = c / 4;
		int j = c % 4;
		int k = (32 + 2 * e + 2 * i - h - j) % 7;
		int L = (a + 11 * h + 22 * k) / 451;
		int MES = (h + k - 7 * L + 114) / 31;
		int DIA = ((h + k - 7 * L + 114) % 31) + 1;
		System.out.println("Pascoa " 
		                   + DIA + "/"
				           + MES + "/"+ANO);
	}
}