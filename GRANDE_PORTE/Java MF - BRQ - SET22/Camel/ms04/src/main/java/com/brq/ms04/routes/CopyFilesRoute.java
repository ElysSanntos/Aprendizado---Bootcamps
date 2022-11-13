package com.brq.ms04.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CopyFilesRoute extends RouteBuilder  {

	@Override
	public  void configure() throws Exception{

		/*A rota é do tipo arquivo e parte da pasta input*/
		from("file:input")
				/*A rota é do tipo arquivo e tem com o destino a paste output*/
				.to("file:output");

	}
}
