package Parte05_FazendinhaFeliz_PolimorfismoDinamico_Pag248;

public class FazendaFeliz {

	public static void main(String[] args) {
		Cachorro racaCao = new Cachorro("Rex", 5,"Pastor Alemão",15.0);
		Galinha racaGalinha = new Galinha("Pintatinha", 1,"Angola",5.0);
		Gato racaGato = new Gato("Caramelo", 3,"Angorá",6.0);
		Vaca racaVaca = new Vaca("Mimosa", 6,"Angus",500.0);
		
		SonsDaFazenda vozAnimal = new SonsDaFazenda();
		
		

		vozAnimal.sonsDaFazenda(racaVaca);
		vozAnimal.sonsDaFazenda(racaCao);
		vozAnimal.sonsDaFazenda(racaGalinha);
		vozAnimal.sonsDaFazenda(racaGato);
	}

}
