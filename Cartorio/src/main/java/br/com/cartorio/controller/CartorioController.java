package br.com.cartorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cartorio.model.Cartorio;
import br.com.cartorio.service.CartorioService;

@Controller
@RequestMapping("/cartorio")
public class CartorioController {
	
	@Autowired
	private CartorioService cartorioService;
	
	@GetMapping("/pagina")
	public ModelAndView logar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("src/main/resources/templates/cartorios.html");
		return mav;
	}
	
	@GetMapping("/selecionar")
	public ResponseEntity<List<Cartorio>> findAll() {
		List<Cartorio> lista = cartorioService.findAll();
		return new ResponseEntity<List<Cartorio>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/selecionar/{id}")
	public ResponseEntity<Cartorio> findById(@PathVariable("id") int id) {
		Cartorio cartorio = cartorioService.findById(id);
		return new ResponseEntity<Cartorio>(cartorio, HttpStatus.OK);
	}
	
	@PostMapping("/inserir")
	public ResponseEntity<Cartorio> save(@RequestBody Cartorio cartorio) {
		cartorioService.save(cartorio);
		return new ResponseEntity<Cartorio>(cartorio, HttpStatus.CREATED);
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Cartorio> update(@PathVariable("id") int id, @RequestBody Cartorio cartorio) {
		cartorio.setId(id);
		cartorioService.update(cartorio);
		return new ResponseEntity<Cartorio>(cartorio, HttpStatus.OK);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
		cartorioService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
