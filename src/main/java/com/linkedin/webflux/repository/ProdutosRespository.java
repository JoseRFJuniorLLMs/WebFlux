package com.linkedin.webflux.repository;

import com.linkedin.webflux.document.Produtos;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProdutosRespository extends ReactiveMongoRepository<Produtos, String>{

}
