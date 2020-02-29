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
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartorios", cartorioService.findAll());
		mav.setViewName("principal");
		mav.setStatus(HttpStatus.OK);
		return mav;
	}
	
	@GetMapping("/criar")
	public ModelAndView criar(ModelAndView mav) {
		mav.addObject("cartorio", new Cartorio());
		mav.setViewName("criar");
		mav.setStatus(HttpStatus.OK);
		return mav;
	}
	
	@PostMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id, ModelAndView mav) {
		mav.addObject("cartorio", cartorioService.findById(id));
		mav.setViewName("editar");
		mav.setStatus(HttpStatus.OK);
		return mav;
	}
	

	@GetMapping("/")
	public ResponseEntity<List<Cartorio>> findAll() {
		List<Cartorio> lista = cartorioService.findAll();
		return new ResponseEntity<List<Cartorio>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cartorio> findById(@PathVariable("id") int id) {
		Cartorio cartorio = cartorioService.findById(id);
		return new ResponseEntity<Cartorio>(cartorio, HttpStatus.OK);
	}

	@PostMapping("/inserir")
	public ModelAndView save(Cartorio cartorio) {
		cartorioService.save(cartorio);
		ModelAndView mav = new ModelAndView("redirect:/cartorio/pagina");
		mav.addObject("cartorios", cartorioService.findAll());
		return mav;
	}

	@PostMapping("/atualizar/{id}")
	public ModelAndView update(@PathVariable("id") int id, Cartorio cartorio) {
		cartorio.setId(id);
		cartorioService.update(cartorio);
		ModelAndView mav = new ModelAndView("redirect:/cartorio/pagina");
		mav.addObject("cartorios", cartorioService.findAll());
		return mav;
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
		cartorioService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
