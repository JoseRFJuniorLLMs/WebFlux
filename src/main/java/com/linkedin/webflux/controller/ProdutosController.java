package com.linkedin.webflux.controller;

import com.linkedin.webflux.document.Produtos;
import com.linkedin.webflux.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "produto")
@RestController
public class ProdutosController {
	
	@Autowired
    ProdutosService produtosService;
	
	@GetMapping(value="/produto/todos")
	public Flux<Produtos> getPlaylist(){
		return produtosService.findAll();
	}
	
	@GetMapping(value="/produto/{id}")
	public Mono<Produtos> getPlaylistId(@PathVariable String id){
		return produtosService.findById(id);
	}
	
	@PostMapping(value="/produto")
	public Mono<Produtos> save(@RequestBody Produtos produtos){
		return produtosService.save(produtos);
	}

}
