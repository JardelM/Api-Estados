package com.example.estados.controller;

import com.example.estados.dto.EstadoDto;
import com.example.estados.dto.EstadoFormDto;
import com.example.estados.entity.Regiao;
import com.example.estados.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/states")
public class EstadoController {

    @Autowired
    private EstadoService service;

    @GetMapping
    public List<EstadoDto> buscaEstados(@RequestParam(required = false) Regiao regiao, @RequestParam(required = false) String filtro) {
        return this.service.buscaTodos(regiao, filtro);
    }

    @GetMapping("/{id}")
    public EstadoDto buscaEstado(@PathVariable Long id) {
        return this.service.buscaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoDto postaEstado(@RequestBody @Valid EstadoFormDto estadoFormDto) {
        return this.service.criaEstado(estadoFormDto);
    }

    @PutMapping("/{id}")
    public EstadoDto atualizaEstado(@PathVariable Long id, @RequestBody @Valid EstadoFormDto estadoFormDto) {
        return this.service.updateEstado(id, estadoFormDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletaEstado(@PathVariable Long id) {
        this.service.deletaEstado(id);
    }

}
