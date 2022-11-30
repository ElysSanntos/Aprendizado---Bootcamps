package com.brq.ms01.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder //Uma forma de construção onde ocorre a instanciação de uma classe e o uso de todos os getters e setters de forma mais elegante.
@Data //Pega entre outros os Getters e Setters
@AllArgsConstructor//Construtor com todos os atributos
@NoArgsConstructor//Construtor padrão vazio
public class StandardError {
	protected Date timestamp;
	protected Integer status;
	protected String error;
	protected String path;
	protected String message;


}
