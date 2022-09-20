public class TestaRelogio {
	public static void main(String[] args) {
		Relogio cassio = new Relogio();
		Relogio rolex = new Relogio(10,30,0);

		cassio.setHora(12);
		cassio.setMinuto(20);
		cassio.setSegundo(30);
		
		cassio.exibeHorario();
		cassio.adiantar(5*24*3600+6*3600+15*60+10);
		cassio.exibeHorario();

		System.out.println("-----------------------");

		rolex.exibeHorario();
		rolex.atrasar(5*24*3600+10*3600);
		rolex.exibeHorario();
	}
}