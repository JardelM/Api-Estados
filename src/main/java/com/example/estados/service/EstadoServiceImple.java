package com.example.estados.service;

import com.example.estados.dto.EstadoDto;
import com.example.estados.dto.EstadoFormDto;
import com.example.estados.entity.Estado;
import com.example.estados.entity.Regiao;
import com.example.estados.exceptions.StateNotFondException;
import com.example.estados.repository.EstadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoServiceImple implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EstadoDto> buscaTodos(Regiao regiao, String filtro) {

        List<Estado> estados;

        if (regiao == null)
            estados = estadoRepository.findAll();
        else
            estados = estadoRepository.findAllByRegiao(regiao);

        if (filtro != null) {

            if (filtro.equals("populacao"))
                estados.sort(Comparator.comparing(Estado::getPopulacao, Comparator.reverseOrder()));

            else if (filtro.equals("area"))
                estados.sort(Comparator.comparing(Estado::getArea, Comparator.reverseOrder()));
        }

        return estados.stream().map(estado -> modelMapper.map(estado, EstadoDto.class)).collect(Collectors.toList());
    }

    @Override
    public EstadoDto buscaPorId(Long id) {

        Estado estado = verificaExistenciaEstado(id);
        return modelMapper.map(estado, EstadoDto.class);
    }

    @Override
    public EstadoDto criaEstado(EstadoFormDto estadoFormDto) {

        Estado estadoACriar = modelMapper.map(estadoFormDto, Estado.class);
        estadoRepository.save(estadoACriar);
        return modelMapper.map(estadoACriar, EstadoDto.class);
    }

    @Override
    public EstadoDto updateEstado(Long id, EstadoFormDto estadoFormDto) {

        verificaExistenciaEstado(id);

        Estado estadoAAtualizar = modelMapper.map(estadoFormDto, Estado.class);
        estadoAAtualizar.setId(id);
        estadoRepository.save(estadoAAtualizar);

        return modelMapper.map(estadoAAtualizar, EstadoDto.class);
    }

    @Override
    public void deletaEstado(Long id) {

        verificaExistenciaEstado(id);
        estadoRepository.deleteById(id);
    }

    private Estado verificaExistenciaEstado(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new StateNotFondException(id));
    }
}
