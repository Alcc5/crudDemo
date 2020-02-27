package br.com.cartorio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cartorio.model.Cartorio;

@Repository
public interface CartorioRepository extends CrudRepository<Cartorio, Integer>{

}
