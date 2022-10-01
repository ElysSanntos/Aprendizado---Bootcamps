package Parte4_excecões_Pag193;

public class TryCatchFinally {

	public static void main(String[] args) {
		
			 int[] num = {0,1,2,3,4};
			 try{
			 for(int i=0;i<10;i++)
			 System.out.println(num[i]);
			 }
			 catch(Exception e){
			 System.out.println("Um erro ocorreu => " + e);
			 }
			 finally{
			 System.out.println("O jeito é continuar");
			 }
			 System.out.println("Termino do programa!");
			 
	}

}
