package br.com.elys.java_io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class TesteRede {

	public static void main(String[] args)throws IOException {

		/*ESSA CLASSE NÃO VAI FUNCIONAR, POIS O OUTRO LADO DO TELEFONE NÃO ESTÁ CONECTADO*/

			Socket s = new Socket();

		//Estabelecendo entrada
		InputStream fis = System.in;
        Reader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        //Estabelecendo escrita
        OutputStream fos = s.getOutputStream();
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        String linha = br.readLine();

        while(linha != null && !linha.isEmpty()) {
            bw.write(linha);
            bw.newLine();
            bw.flush();
            linha = br.readLine();
        }

        br.close();
        bw.close();
	}

}
