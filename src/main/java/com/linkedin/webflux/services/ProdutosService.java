package com.linkedin.webflux.services;

import com.linkedin.webflux.document.Produtos;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProdutosService {
	
	Flux<Produtos> findAll();
	Mono<Produtos> findById(String id);
	Mono<Produtos> save(Produtos produtos);

}
