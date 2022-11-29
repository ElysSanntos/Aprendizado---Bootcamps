package rotas;



import static org.assertj.core.api.Assertions.from;

import java.util.Set;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RotaPedidos {

	public static void main(String[] args) throws Exception{
		CamelContext context = new DefaultCamelContext(); //inicializar o camel, e a partir daqui, vamos definir a nossa primeira rota.
		context.addRoutes(new RoutesBuilder() {


			public void configure() throws Exception{

				from("file:pedidos?delay=5s")
				.to("file:saida");

			}


		});

		context.start();
	}

}
