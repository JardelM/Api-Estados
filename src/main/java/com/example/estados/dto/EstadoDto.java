package com.example.estados.dto;

import com.example.estados.entity.Regiao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDto {

    private Long id;
    private String nome;
    private Regiao regiao;
    private Integer populacao;
    private String capital;
    private Double area;
}
