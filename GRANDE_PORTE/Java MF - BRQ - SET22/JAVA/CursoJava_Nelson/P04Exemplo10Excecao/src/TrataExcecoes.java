import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class TrataExcecoes {
	public static void main(String[] args) {
		int [] num = {0,1,2,3,4};
		double [][][][][] s;
		try {
			SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
			String StrMeuNiver = "01@10@2022";
			
			// ParseException
			// catch(ParseException e)
			// catch(Exception e)
			
			Date meuNiver = ft.parse(StrMeuNiver); 
			
			for(int i=0;i<num.length;i++) {
				System.out.println(num[i]);
			}
			// NullPointerException
			// catch(RuntimeException e)
			String nome="banana";
			nome.toUpperCase();		
			
			// ArithmeticException
			// catch(RuntimeException e)
			int x = 10 / 10;
			
			// StackOverflowError
			// catch(Error e)
			vaiEstourar(300);
			
			// OutOfMemoryError
			// catch(Error e)
			s = new double[365][24][60][60][1000];
		}
		/*
		catch(ParseException e) {
			System.out.println("Contate a Andre...");
			System.out.println(e);
		}
		*/
		catch(Error e) {
			System.out.println("Contate a Elys...");
			System.out.println(e);
			s = null;
			System.exit(12);
		}
		catch(RuntimeException e) {
			System.out.println("Contate a Winton...");
			System.out.println(e);
		}	
		catch(Exception e) {
			System.out.println("Contate a Ivo...");
			System.out.println(e);
		}		

	}
	
	public static void vaiEstourar(int a) {
		if (a<0) return;
		vaiEstourar(--a);
	}
}