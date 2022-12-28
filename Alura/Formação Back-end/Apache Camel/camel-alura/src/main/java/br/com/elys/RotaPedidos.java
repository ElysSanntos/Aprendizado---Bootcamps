package br.com.elys;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RotaPedidos {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("file:pedidos?directoryMustExist=true").//aqui camel realmente começa a trabalhar
				log("${body}").
				to("file:saida");

			}
		});

		//context.start();
		Thread.sleep(20000);
		context.stop();
	}

}
