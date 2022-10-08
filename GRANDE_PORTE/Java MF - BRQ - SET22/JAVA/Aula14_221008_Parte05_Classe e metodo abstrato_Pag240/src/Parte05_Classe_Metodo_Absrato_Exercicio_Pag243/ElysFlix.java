package Parte05_Classe_Metodo_Absrato_Exercicio_Pag243;

/*Escreva a classe SuaEmpresa (isso mesmo, coloque o nome de sua empresa)
 * para testar estas classes.*/

public class ElysFlix {

	public static void main(String[] args) {
		
		Programador p = new Programador(1,"Jair","Consórcios", "Java");
		Analista a = new Analista(2, "Messias", "Governança");
		Gerente g = new Gerente(22, "Bolsomito","Brasil", 1, 1);
		
		imprimir(p);
		imprimir(a);
		imprimir(a);
	}
	
	public static void imprimir(Funcionario f) {
		
		f.trabalhar();
	}

}
