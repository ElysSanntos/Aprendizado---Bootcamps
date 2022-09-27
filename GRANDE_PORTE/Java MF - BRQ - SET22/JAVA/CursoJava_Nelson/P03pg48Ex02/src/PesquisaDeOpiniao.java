import java.util.ArrayList;

public class PesquisaDeOpiniao {

	public static void main(String[] args) {
		ArrayList IBOPE = new ArrayList();
		
		IBOPE.add(new Pesquisa('M','S'));
		IBOPE.add(new Pesquisa('M','S'));
		IBOPE.add(new Pesquisa('F','S'));
		IBOPE.add(new Pesquisa('F','N'));
		IBOPE.add(new Pesquisa('M','N'));
		
		Pesquisa p = new Pesquisa();
		p.setSexo('F');
		p.setResposta('S');
		IBOPE.add(p);
		
		System.out.println("Qtde homens resp 'S'...: "+Pesquisa.QHRS(IBOPE));
		System.out.println("Qtde mulheres resp 'N'.: "+Pesquisa.QMRN(IBOPE));
		System.out.println("% homens resp 'S'......: "+Pesquisa.PHRS(IBOPE));
		System.out.println("% mulheres resp 'N'....: "+Pesquisa.PMRN(IBOPE));
	}
}