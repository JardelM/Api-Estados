package com.example.estados.service;

import com.example.estados.dto.EstadoDto;
import com.example.estados.dto.EstadoFormDto;
import com.example.estados.entity.Regiao;

import java.util.List;

public interface EstadoService {

    List<EstadoDto> buscaTodos(Regiao regiao , String filtro);

    EstadoDto buscaPorId(Long id);

    EstadoDto criaEstado(EstadoFormDto estadoFormDto);

    EstadoDto updateEstado(Long id, EstadoFormDto estadoFormDto);

    void deletaEstado(Long id);
}
