package Parte05_Revisao_FazendinhaFeliz_Interface_Pag316;

public class FazendaFeliz {

	public static void main(String[] args) {
		
		Cachorro rex = new Cachorro("Rex", 5, 15.0, "Pastor Alemão");
		Galinha caipira = new Galinha("Caipira", 2, 2.7, "Galinha Caipira");
		Gato felix = new Gato("Felix", 8, 2.5, "Angora");
		Vaca mimosa = new Vaca("Mimosa", 10, 250.0, "Zebu");

		SonsDaFazenda barulho = new SonsDaFazenda();

		barulho.sonsDaFazenda(rex);
		barulho.sonsDaFazenda(caipira);
		barulho.sonsDaFazenda(felix);
		barulho.sonsDaFazenda(mimosa);
	}

}
