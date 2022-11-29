package com.brq.ms06.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    protected Date timestamp;
    protected Integer status;
    protected String error;
    protected String message;
    protected String path;
}