package com.brq.ms01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinanciamentoDTO {

	private Integer id;
	private Integer numeroContrato;
	private Double valor;
}