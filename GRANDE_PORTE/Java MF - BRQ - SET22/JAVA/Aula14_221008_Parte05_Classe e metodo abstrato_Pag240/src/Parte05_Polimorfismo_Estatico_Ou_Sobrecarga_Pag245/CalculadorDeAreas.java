package Parte05_Polimorfismo_Estatico_Ou_Sobrecarga_Pag245;

public class CalculadorDeAreas {
	// polimorfismo estático ou de sobrecarga
	
	public byte   areaQuadrado(byte   lado) { return (byte)  (lado * lado);} 
	public short  areaQuadrado(short  lado) { return (short) (lado * lado);} 
	public int    areaQuadrado(int    lado) { return lado * lado;} 
	public long   areaQuadrado(long   lado) { return lado * lado;} 
	public float  areaQuadrado(float  lado) { return lado * lado;} 
	public double areaQuadrado(double lado) { return lado * lado;} 
}