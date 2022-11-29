package com.brq.ms06.exceptions;

public class NaoAcheiException extends RuntimeException {

    public NaoAcheiException(String mensagem){
        super(mensagem);
    }

    public NaoAcheiException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}