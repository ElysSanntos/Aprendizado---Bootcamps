import java.util.Date;

public class MagazineSinomar {

	public static void main(String[] args) {
		Alimenticio a = new Alimenticio(
				"15481-9",
				"Arroz Tio Joao 5kg",
				8.0,
				15.0,
				new Date(),
				new Date(),
				0.1
				);
		
		Livro b = new Livro(
				"54845-8",
				"Use a Cabeca - Java",
				20.0,
				160.0,
				"978-8576081739"
				);

		System.out.println("Lucro Alimenticio = "+a.calculaLucro());
		System.out.println("Lucro Livro       = "+b.calculaLucro());
	}

}
