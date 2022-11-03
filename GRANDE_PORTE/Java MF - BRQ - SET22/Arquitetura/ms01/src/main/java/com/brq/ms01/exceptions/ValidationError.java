package com.brq.ms01.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data //Pega entre outros, os Getters e Setters
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError extends StandardError {

	private List<FieldMessage> errors = new ArrayList<>();

}
