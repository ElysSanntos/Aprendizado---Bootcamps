package com.brq.ms04.processors;

import com.brq.ms04.dtos.CotacaoUSDDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PollingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        final var messageIn = exchange.getIn().getBody(String.class);
        System.out.println("GET IN " + messageIn);

        final var objectMapper = new ObjectMapper();

         var cotacao = objectMapper
                        .readValue(messageIn, CotacaoUSDDTO.class);
         cotacao.getUSDBRL().setCode(cotacao.getUSDBRL().getCode()+ "- BRQ");
         exchange.getIn().setBody(cotacao);


        System.out.println("GET OUT " + cotacao);
    }
}