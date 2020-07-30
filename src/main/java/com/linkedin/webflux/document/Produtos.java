package com.linkedin.webflux.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "produto")
public class Produtos {

	 @Id
	 String id;
	 String nome;
	 String preco;

	public Produtos(String id, String nome, String preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
}
