package Aula3_220910.UsoStatic;

public class Pacote {
	
	// atributos
	 private static int proximoId = 0;
	 private int idPacote;
	 
	 // construtor
	 public Pacote(){
	 proximoId++;
	 this.idPacote = proximoId;
	 }
	 
	 // getters
	 public int getProximoId(){
	 return proximoId;
	 }
	 public int getIdPacote(){
	 return this.idPacote;
	 }

}
