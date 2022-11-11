package com.brq.ms04.routes;
import com.brq.ms04.processors.PollingProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class PollingRoute extends RouteBuilder {

	@Value("${exchange.url}")
	private String url;

	@Override
	public void configure() throws Exception {

		log.info("O valor da URL é {}", url);

		// após o caracter ?, podemos colocar os parâmetros do conector do camel
		// ex: period=5000 -> executar a cada 5 segundos
		from("timer:polling?period=5000")
				//.to("https://economia.awesomeapi.com.br/json/last/USD-BRL")
				.to(url)
				.process(new PollingProcessor())
				.log("${body}");
	}
}