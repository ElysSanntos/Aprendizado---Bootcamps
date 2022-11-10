package com.brq.ms04.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CotacaoUSD {

    @JsonProperty("USDBRL")
    private USDBRL uSDBRL;
}