package com.brq.ms05.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum MensagensExceptionEnum {

    USUARIO_NAO_ENCONTRADO("Usuário não localizado!");

    @Getter private String mensagem;
}
