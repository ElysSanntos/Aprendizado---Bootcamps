package com.brq.ms04.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ActiveMQProducerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		//from("timer:active-mq-producer?period=4000")
		from("timer:active-mq-producer?repeatCount=3")
				//.transform().constant("Apache Camel")
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						Random random = new Random();
						exchange.getIn().setBody("Apache Camel " + random.nextInt());
					}
				}).log("${body}").to("activemq:meu-primeiro-topico-2");
	}
}
