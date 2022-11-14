package com.brq.ms04.dtos;


import com.brq.ms04.models.USDBRLModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class USDBRLDTO {
    private String code;
    private String codein;
    private String name;
    private String high;
    private String low;
    private String varBid;
    private String pctChange;
    private String bid;
    private String ask;
    private String timestamp;
    private String create_date;

    public USDBRLModel toModel(){
        final var mapper = new ModelMapper();

        return mapper.map(this, USDBRLModel.class);
    }
}