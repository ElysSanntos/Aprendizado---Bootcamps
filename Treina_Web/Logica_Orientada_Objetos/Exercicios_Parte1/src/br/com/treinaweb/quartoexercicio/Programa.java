package br.com.treinaweb.quartoexercicio;

import br.com.treinaweb.segundoexercicio.Dentista;
import br.com.treinaweb.terceiroexercicio.Paciente;

public class Programa {

	public static void main(String[] args) {
		Dentista dentista = new Dentista("Carlos", "Silva", "Cirurgião Dentista", "SP-CS-01", true);
		
		dentista.atenderPaciente();
		dentista.marcarConsulta();
		dentista.remarcarConsulta();
		dentista.cancelarConsulta();
		dentista.viajarCongresso();
		
		Paciente paciente = new Paciente(
				1,
				"Maria",
				"Sousa",
				33,
				"Feminino",
				"11-91111-1111",
				"Rua Central, 100 - São Paulo - SP"
				);
		
		paciente.marcarConsulta();
		paciente.remarcarConsulta();
		paciente.consultadoConsulta();
		paciente.cancelarConsulta();
	}

}
