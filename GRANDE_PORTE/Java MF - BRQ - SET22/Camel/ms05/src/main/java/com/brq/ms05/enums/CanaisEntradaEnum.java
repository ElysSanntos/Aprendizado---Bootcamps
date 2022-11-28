package com.brq.ms05.enums;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public enum CanaisEntradaEnum {
    /* ENUM: São campos que possuem um valor fixo pré-definidos na aplicação
    * */

    C2("C2", "Descrição do Sinomar"),
    MOBILE("M1", "Descrição do Mobile"),
    C3("SAT5", "Descrição do C3");

    @Getter
    private String codigo;
    @Getter
    private String descricao;

    // Construtores estão feitos com o Lombok
}
