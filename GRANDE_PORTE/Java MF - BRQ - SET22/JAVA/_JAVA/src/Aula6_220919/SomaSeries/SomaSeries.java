package Aula6_220919.SomaSeries;
public class SomaSeries {

	public static void main(String[] args) {
		
		// série 1
		{
			double numerador   = 1.0;
			double denominador = 1.0;
			double S = 0.0;
			for (int i=0; i<50; i++) {
				S += numerador / denominador;
				numerador   = numerador + 2.0;
				denominador = denominador + 1.0;
			}
			System.out.println("Soma Serie 1 = " + S);
		}

		// série 2
		{
			double numerador   = 2.0;
			double denominador = 50.0;
			double S = 0.0;
			for (int i=0; i<50; i++) {
				S += numerador / denominador;
				numerador   = numerador * 2.0;
				denominador = denominador - 1.0;
			}
			System.out.println("Soma Serie 2 = " + S);
		}

		// série 3
		{
			double numerador   = 37.0;
			double denominador = 1.0;
			double S = 0.0;
			for (int i=0; i<37; i++) {
				S += numerador*(numerador+1.0) / denominador;
				numerador   = numerador - 1.0;
				denominador = denominador + 1.0;
			}
			System.out.println("Soma Serie 3 = " + S);
		}

		// série 4
		{
			double numerador   = 1.0;
			double denominador = 1.0;
			double sinal = 1.0;
			double S = 0.0;
			for (int i=0; i<10; i++) {
				S += sinal * numerador / (denominador * denominador);
				numerador   = numerador - 1.0;
				denominador = denominador + 1.0;
				sinal = sinal * (-1.0);
			}
			System.out.println("Soma Serie 4 = " + S);	
	}

}}