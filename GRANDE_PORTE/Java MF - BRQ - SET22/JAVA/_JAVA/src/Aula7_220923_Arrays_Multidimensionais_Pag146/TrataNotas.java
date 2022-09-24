package Aula7_220923_Arrays_Multidimensionais_Pag146;

import java.util.Date;
import java.util.Random;

public class TrataNotas {
	
	Random ml = new Random(new Date().getTime());
	
	public void preencheNotas(double [] a){
		
		for (int i = 0; i < a.length; i++) {
			a[i] = ml.nextInt(11);
		}
	}
public void preencheNotas(double [][] a){
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a[0].length; j++) {
			 a[i][j] = ml.nextInt(11);
			
		}
		
	}
		
	}
public void preencheNotas(double [][][] a){
	
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a[0].length; j++) {
			for (int k = 0; k < a[0][0].length; k++) {
				a[i][j][k] = ml.nextInt(11);
				
			}
			
		}
		
	}
	
	
}

public double mediaNotas(double [] a) {
	
	double soma = 0.0;
	int contador = 0;
	
	for (int i = 0; i < a.length; i++) {
		
		soma =+ a[i];
		contador =+1;
	}
	return soma / contador;
}
public double mediaNotas(double[][] a) {
	double soma = 0.0;
	int contador = 0;
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a[0].length; j++) {
			soma = soma + a[i][j];
			contador = contador + 1;
		}
	}
	return soma / contador;
}

public double mediaNotas(double [][][] a) {
	double soma  = 0.0;
	int contador = 0;
	for(int i=0; i<a.length; i++) {
		for(int j=0; j<a[0].length; j++) {
			for(int k=0; k<a[0][0].length;k++) {
				soma = soma + a[i][j][k];
				contador = contador + 1;
			}
		}
	}
	return soma / contador;
}
}