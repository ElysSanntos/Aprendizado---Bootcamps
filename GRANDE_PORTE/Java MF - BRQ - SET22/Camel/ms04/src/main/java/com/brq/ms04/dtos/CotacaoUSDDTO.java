package com.brq.ms04.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CotacaoUSDDTO {

    @JsonProperty("USDBRL")
    private USDBRLDTO uSDBRL;
}