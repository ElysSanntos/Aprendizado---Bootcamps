package Exercicio02;

import java.util.ArrayList;

public class PesquisaDeOpiniao {

	public static void main(String[] args) {
		
		ArrayList<Pesquisa> ibope = new ArrayList<Pesquisa>();
		
		ibope.add(new Pesquisa('M','S'));
		ibope.add(new Pesquisa('M','N'));
		ibope.add(new Pesquisa('F','S'));
		ibope.add(new Pesquisa('F','N'));
		ibope.add(new Pesquisa('M','S'));
		
		Pesquisa ser = new Pesquisa();
		ser.setSexo('F');
		ser.setResposta('S');
		ibope.add(ser);
		
		System.out.println("===================hOMENS=====================\n");
		System.out.println("Qtde homens   resp 'S'...: "+Pesquisa.QHRS(ibope));
		System.out.println("Qtde homens   resp 'N'...: "+Pesquisa.QHRN(ibope));
		System.out.println("% homens      resp 'N'...: "+Pesquisa.PHRN(ibope));
		System.out.println("% homens      resp 'S'...: "+Pesquisa.PHRS(ibope));
		System.out.println("\n==================MULHERES==================\n");
		System.out.println("Qtde mulheres resp 'S'...: "+Pesquisa.QMRS(ibope));
		System.out.println("Qtde mulheres resp 'N'...: "+Pesquisa.QMRN(ibope));
		System.out.println("% mulheres    resp 'N'...: "+Pesquisa.PMRN(ibope));
		System.out.println("% mulheres    resp 'S'...: "+Pesquisa.PMRS(ibope));
		
		
		
		
		

	}

}
