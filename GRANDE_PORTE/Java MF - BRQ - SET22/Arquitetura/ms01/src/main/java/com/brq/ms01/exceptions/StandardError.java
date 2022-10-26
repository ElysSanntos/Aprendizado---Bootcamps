package com.brq.ms01.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder //
@Data //Pega entre outros os Getters e Setters
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
	private Date timestamp;
	private Integer status;
	private String error;
	private String path;
	private String message;

}
