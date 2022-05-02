package com.example.estados.repository;

import com.example.estados.entity.Estado;
import com.example.estados.entity.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository <Estado, Long> {

    List<Estado> findAllByRegiao(Regiao regiao);
}
