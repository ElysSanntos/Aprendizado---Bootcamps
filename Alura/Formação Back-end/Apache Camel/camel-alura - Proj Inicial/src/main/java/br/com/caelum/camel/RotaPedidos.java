package br.com.caelum.camel;

//CTRL + SHIFT + C é para comentar e descomentar em linha

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

//Esta classe que vai denifir a rota de pedidos

public class RotaPedidos {

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {
            	from("file:pedidos?delay=5s&noop=true").
                log("Camel trabalhando!!").
                log("${id} - ${body}").//aqui tem um ponto para encadear a chamada do próximo método
                to("file:saida");
            }
        });

        context.start(); //aqui camel realmente começa a trabalhar
        Thread.sleep(0);; //esperando um pouco para dar um tempo para camel
    }    
};


