package com.example.estados.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Regiao {

    NORTE ("Norte"),
    NORDESTE ("Nordeste"),
    CENTROOESTE ("Centro Oeste"),
    SUL ("Sul"),
    SUDESTE ("Sudeste");

    private final String descricao;

    @JsonCreator (mode = JsonCreator.Mode.DELEGATING)
    public static Regiao paraValores (@JsonProperty ("regiao") String des){
        for (Regiao regiao : Regiao.values()){
            if (regiao.descricao.equalsIgnoreCase(des))
                return regiao;
        }
        return null;
    }
}
