package Parte04_Exercicio08_Pag217;

import java.util.ArrayList;

public class Guerra {
	
	public  static ArrayList getFrota(String nomeFrota) {
		ArrayList frota = newArrayList();
		frota.add(new Navio(5,nomeFrota + "Pesqueiro 1"));
		frota.add(new Navio(5,nomeFrota + "Pesqueiro 2"));
		frota.add(new Navio(5,nomeFrota + "Pesqueiro 3"));
		
		frota.add(new Navio(15,nomeFrota + "Mercante 1",500,50));
		frota.add(new Navio(15,nomeFrota + "Mercante 2",500,50));
		
		frota.add(new Navio(15,nomeFrota + "Guerra 1",1000.0,200.0));
		frota.add(new Navio(15,nomeFrota + "Guerra 2",500,50));
		
		frota.add(new Navio(15,nomeFrota + "Cruzador 1",500,50));
		frota.add(new Navio(15,nomeFrota + "Cruzador 2",500,50));
		
		return null;
	}
	
	public void fazGuerra(ArrayList a, ArrayList b) {
		
	}

	public static void apresentaFrota(ArrayList frota) {
		for (int i = 0; i < frota.size(); i++) {
			if(frota.get(i)instanceof PortaAvioes) {}
					
			if(frota.get(i)instanceof NavioMercante) {}
			if(frota.get(i)instanceof NavioDeGuerra) {}
			if(frota.get(i)instanceof Cruzador) {}
			
		}
		
	}

}
