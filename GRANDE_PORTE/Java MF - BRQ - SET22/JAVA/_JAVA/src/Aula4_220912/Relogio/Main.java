package Aula4_220912.Relogio;

public class Main {

	public static void main(String[] args) {

    Relogio cassio  = new Relogio();
    Relogio oriente  = new Relogio(10,30,10);
    
    cassio.setMarca("Cassio");
    cassio.setHora(12);
    cassio.setMinuto(20);
    cassio.setSegundo(30);
    
    oriente.setMarca("Oriente");
    
    System.out.println("======Hora atual======\n");
    cassio.exibeHorario();
    oriente.exibeHorario();
    
    System.out.println("\n====Hora adiantada====\n");
    cassio.adiantar(400000000);;
    cassio.exibeHorario();
    
    oriente.adiantar(30);
    oriente.exibeHorario();
    
    System.out.println("\n=====Hora atrasada====\n");
    cassio.atrasar(400000000);;
    cassio.exibeHorario();
    
    oriente.atrasar(30);
    oriente.exibeHorario();
    
    
	}

}
