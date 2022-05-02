package com.example.estados.dto;


import com.example.estados.entity.Regiao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoFormDto {

    @NotBlank
    private String nome;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Deve conter uma região do Brasil válida!")
    private Regiao regiao;
    @NotNull
    private Integer populacao;
    @NotNull //numeros tem que ser not null
    private String capital;
    @NotNull
    private Double area;
}
