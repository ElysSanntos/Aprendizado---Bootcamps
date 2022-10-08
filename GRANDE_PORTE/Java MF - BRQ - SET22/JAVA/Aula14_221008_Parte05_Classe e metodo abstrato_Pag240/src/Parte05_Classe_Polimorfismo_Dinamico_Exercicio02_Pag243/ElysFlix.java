package Parte05_Classe_Polimorfismo_Dinamico_Exercicio02_Pag243;

/*Escreva a classe SuaEmpresa (isso mesmo, coloque o nome de sua empresa)
 * para testar estas classes.*/

public class ElysFlix {

	public static void main(String[] args) {
		
		Programador p1 = new Programador(1,"Jair","Consórcios", "Java");
		Analista a1 = new Analista(2, "Messias", "Governança");
		Gerente g1 = new Gerente(22, "Bolsomito","Brasil", 1, 1);
		
		p1.trabalhar();
		a1.trabalhar();
		g1.trabalhar();
	}

}
