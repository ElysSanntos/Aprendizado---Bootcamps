package Aula5_220916;

public class DesvioCondicional {
	
	public static void main(String[] args) {
		int a=11;
		
		if      (a==0) System.out.println("zero"); 
		if      (a==1) System.out.println("um");
		else if (a==2) System.out.println("dois");
		else if (a==3) System.out.println("tres");
		else           System.out.println("outro");
		
		if(a==0) {
			System.out.println("zero");
		} else {
			if (a==1) {
				System.out.println("um");
			}
			else {
				if (a==2) {
					System.out.println("dois");
				}
				else {
					if (a==3) {
						System.out.println("tres");
					}
					else {
						System.out.println("outro");
					}
				}
			}
		}
	}

}
