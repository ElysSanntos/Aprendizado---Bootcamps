package Parte05_Classe_Metodo_Absrato_Pag241;

public class TestaEletrodomestico {
	public static void main(String[] args) {

		TV tv1 = new TV(29, 110);
		Radio radio1 = new Radio(110);

		// chamando os métodos abstratos implementados
		tv1.ligar();
		radio1.ligar();
		System.out.print("Neste momento a TV  da sala está ");
		System.out.println(tv1.isLigado() ? "ligada" : "desligada");
		System.out.print("e o Rádio da cozinha está ");
		System.out.println(radio1.isLigado() ? "ligado." : "desligado.");
		
		System.out.println("=================================================");
		tv1.desligar();
		radio1.desligar();
		System.out.print("Neste momento a TV do quarto está ");
		System.out.println(tv1.isLigado() ? "ligada" : "desligada");
		System.out.print("e o Rádio da cozinha está ");
		System.out.println(radio1.isLigado() ? "ligado." : "desligado.");
	}
}