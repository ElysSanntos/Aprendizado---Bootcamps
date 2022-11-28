package com.brq.ms05.mappers;

public class ThMsgErrorReturned {

    public static String convertMsgTh(
            ResponseThError codError, SalesEnum codChannel
    ){
        String response = null;

        switch (codError){
            case NEG1:
                if (codChannel.equals( SalesEnum.C2 )){
                    response = "Erro NEG1 - CANAL C2: Para que possa simular....";
                }
                else if ( codChannel.equals( SalesEnum.C3 ) ){
                    response = "Erro NEG1 - CANAL C3";
                }
        }
        return response;
    }
}
