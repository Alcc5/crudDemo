package br.com.cartorio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartorio.interfaces.CrudService;
import br.com.cartorio.model.Cartorio;
import br.com.cartorio.repository.CartorioRepository;

@Service
public class CartorioService implements CrudService<Cartorio>{
	
	@Autowired
	private CartorioRepository cartorioRepository;

	@Override
	public List<Cartorio> findAll() {
		List<Cartorio> cartorios = new ArrayList<>();
		cartorioRepository.findAll().forEach(cartorio -> cartorios.add(cartorio));
		return cartorios;
	}
	
	@Override
	public Cartorio findById(int id) {
		Cartorio cartorio = cartorioRepository.findById(id).get();
		return cartorio;
	}

	@Override
	public boolean save(Cartorio objeto) {
		cartorioRepository.save(objeto);
		return true;
	}

	@Override
	public void update(Cartorio objeto) {
		cartorioRepository.save(objeto);
	}

	@Override
	public void deleteById(int id) {
		cartorioRepository.delete(findById(id));
		
	}

}
