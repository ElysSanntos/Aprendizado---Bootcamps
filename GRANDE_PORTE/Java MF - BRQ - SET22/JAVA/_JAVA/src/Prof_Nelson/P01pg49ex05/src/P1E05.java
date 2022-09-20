public class P1E05{
	public static void main(String [] args) {
		double DP = 4.0;
 	    double DG = 9.0;
		double PP = 1.5;
	    double PG = 3.0;
	    double PM = (PP+PG)/2.0;
	    double QTDLITROS = DG * DP * PM * 785.0;
	    System.out.println("serao necesssarios " +
	                        QTDLITROS + " litros.");
	}
}