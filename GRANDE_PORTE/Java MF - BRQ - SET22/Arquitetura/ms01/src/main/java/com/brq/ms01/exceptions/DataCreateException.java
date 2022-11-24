package com.brq.ms01.exceptions;

public class DataCreateException extends RuntimeException{

    public DataCreateException(String mensagem){
        super(mensagem);
    }

    public DataCreateException(String mensagem, Throwable causa){
        super(mensagem,causa);
    }
}