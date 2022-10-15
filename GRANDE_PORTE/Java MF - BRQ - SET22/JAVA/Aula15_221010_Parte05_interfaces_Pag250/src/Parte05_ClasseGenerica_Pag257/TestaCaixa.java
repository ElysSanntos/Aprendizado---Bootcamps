package Parte05_ClasseGenerica_Pag257;

public class TestaCaixa {

	public static void main(String[] args) {
		
		Caixa <Integer> caixaInteger = new Caixa<Integer>();
		Caixa <Double> caixaDouble =   new Caixa<Double>();
		Caixa <String> caixaString =   new Caixa<String>();

		 caixaInteger.setDado(10);
		 caixaDouble.setDado (new Double(10.0));//A partir do Java 8, n�o precisamos mais fazer desta forma
		 caixaString.setDado (new String("Ol� Mundo!"));
		 
		 System.out.println("Valor Inteiro : " + caixaInteger.getDado());
		 System.out.println("Valor Double : " + caixaDouble.getDado());
		 System.out.println("Valor String : " + caixaString.getDado());
		 
		 System.out.println();
		 
		 caixaInteger.setDado(11);
		 caixaDouble.setDado(11.0);
		 caixaString.setDado("Elys Sanntos");
		 System.out.println("Integer ==> "+caixaInteger.getDado());
		 System.out.println("Double ==> "+caixaDouble.getDado());
		 System.out.println("String ==> "+caixaString.getDado());
		 
		 //Heran�a para classe gen�rica
		 Tupperware t = new Tupperware();
		 
		 t.setDado("Banana");
		 System.out.println("\n Heran�a: "+t.getDado());
		 }

	}


