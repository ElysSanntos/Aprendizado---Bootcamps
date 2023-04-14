package br.com.elys.java_io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEnconding {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String s = "C";
		System.out.println("CodePointAt da letra: "+ s  +"  é: "+ s.codePointAt(0));

		Charset charset = Charset.defaultCharset();
		System.out.println("Nome do CharSet: " + charset.displayName());


		//CTRL + 1 - Cria uma variável local
		byte[] bytes = s.getBytes();
		System.out.println("Qtde de bytes: " + bytes.length + " -- Nome do CharSet: " +  charset.displayName() );

		bytes = s.getBytes("UTF-16");
		System.out.println("Qtde de bytes: " + bytes.length + " -- Nome do CharSet: UTF-16 "  );

		bytes = s.getBytes("windows-1252");
		System.out.println("Qtde de bytes: " + bytes.length + " -- Nome do CharSet: windows-1252"  );


		bytes = s.getBytes(StandardCharsets.US_ASCII);
		System.out.println("Qtde de bytes: " + bytes.length + " -- Nome do CharSet: US_ASCII"  );


	}

}
