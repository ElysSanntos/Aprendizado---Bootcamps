package Numeros;

public class ConverterNumeros {

	public static void main(String[] args) {
		/*
		 * Byte meuByte = new Byte((byte)5); 
		 * Integer meuInteger = new Integer(12345);
		 * Double meuDouble = new Double(1234567.89);
		 */
			Byte meuByte = 5;
			Integer meuInteger = 12345;
			Double meuDouble = 1234567.89;
		

		 byte doubleParaByte = meuDouble.byteValue();
		 int byteParaInt = meuByte.intValue();
		 double integerParaDouble = meuInteger.doubleValue();
		 System.out.println("Byte: " + meuByte +
		 " - para int: " + byteParaInt +
		 "\nInteger: " + meuInteger +
		 " - para double: " + integerParaDouble +
		 "\nDouble: " + meuDouble +
		 " - para byte: " + doubleParaByte);

	}

}
