package com.linkedin.webflux.controller;

import com.linkedin.webflux.document.Produtos;
import com.linkedin.webflux.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProdutosController {
	
	@Autowired
    ProdutosService service;
	
	@GetMapping(value="/produto")
	public Flux<Produtos> getPlaylist(){
		return service.findAll();
	}
	
	
	@GetMapping(value="/produto/{id}")
	public Mono<Produtos> getPlaylistId(@PathVariable String id){
		return service.findById(id);
	}
	
	@PostMapping(value="/produto")
	public Mono<Produtos> save(@RequestBody Produtos produtos){
		return service.save(produtos);
	}

}
