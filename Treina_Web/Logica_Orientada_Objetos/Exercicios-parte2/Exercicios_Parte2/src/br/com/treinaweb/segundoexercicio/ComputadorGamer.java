package br.com.treinaweb.segundoexercicio;

public class ComputadorGamer extends Computador {
	private int memoriaPlacaVideo;
	
	public int getMemoriaPlacaVideo() {
		return memoriaPlacaVideo;
	}

	public void setMemoriaPlacaVideo(int memoriaPlacaVideo) {
		this.memoriaPlacaVideo = memoriaPlacaVideo;
	}

	public void jogarNeedForSpeed(){
		System.out.println("Jogando Need For Speed!");
	}
}
