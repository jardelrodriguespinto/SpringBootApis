package com.GerenciadorDeCotatoa.demo.gerenciadordecontatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GerenciadorDeCotatoa.demo.gerenciadordecontatos.entity.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
}
