package Aula7_220923_ArraysList_Pag158;

import java.util.ArrayList;

public class TestaArrayList {

	public static void main(String[] args) {
		
		// cria um Object array list
		 ArrayList cornucopia = new ArrayList(100);
		 System.out.println("Conte�do inicial : "+cornucopia);
		 System.out.println("Tamanho inicial : "+cornucopia.size());
		 
		 // acrescenta elementos no array list
		 cornucopia.add("Jose");
		 cornucopia.add(3.14);
		 cornucopia.add(true);
		 
		 System.out.println("Tamanho do array list : "+cornucopia.size());
		 System.out.println("Conte�do do array list : "+cornucopia);
		 
		 cornucopia.add(1,"C");
		 cornucopia.add("C");
		 cornucopia.set(0,"Pedro");
		 
		 // exibe informa��es e elementos do array list
		 System.out.println("Tamanho do array list : "+cornucopia.size());
		 System.out.println("Conte�do do array list : "+cornucopia);
		 System.out.println("Verifica se existe C : "+cornucopia.contains("C"));
		 System.out.println("Verifica se existe D : "+cornucopia.contains("D"));
		 System.out.println("Conte�do da 2� posi��o : "+cornucopia.get(1));
		 System.out.println("�ndice do primeiro C : "+cornucopia.indexOf("C"));
		 System.out.println("�ndice do �ltimo C : "+cornucopia.lastIndexOf("C"));
		 System.out.println("Est� vazio? : "+cornucopia.isEmpty());
		 
		 // limpa array list
		 cornucopia.clear();
		 System.out.println("E agora, est� vazio? : "+cornucopia.isEmpty());
		 }

	}


