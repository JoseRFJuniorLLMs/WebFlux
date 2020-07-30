package com.linkedin.webflux.services;

import com.linkedin.webflux.document.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.webflux.repository.ProdutosRespository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutosServiceImpl implements ProdutosService {
	
	@Autowired
	ProdutosRespository produtosRespository;

	@Override
	public Flux<Produtos> findAll() {
		return produtosRespository.findAll();
	}

	@Override
	public Mono<Produtos> findById(String id) {
		return produtosRespository.findById(id);
	}

	@Override
	public Mono<Produtos> save(Produtos produtos) {
		return produtosRespository.save(produtos);
	}

	@Override
	public Mono<Void> delete(Produtos produtos) {
		return produtosRespository.delete(produtos);
	}

	@Override
	public Mono<Void> deleteAll() {
		return produtosRespository.deleteAll();
	}

}
