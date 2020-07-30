package com.linkedin.webflux.controller;

import com.linkedin.webflux.document.Produtos;
import com.linkedin.webflux.document.Tipo;
import com.linkedin.webflux.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

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

	@GetMapping(value = "/stream/produtos", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Produtos> getAllProdutos() {return produtosService.findAll();}

	@GetMapping("/produtos/{id}")
	public Mono<ResponseEntity<Produtos>> getProdutos2(@PathVariable String id) {
		return produtosService.findById(id)
				.map(pokemon -> ResponseEntity.ok(pokemon))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping(value="/produto/{id}")
	public Mono<Produtos> getPlaylistId(@PathVariable String id){
		return produtosService.findById(id);
	}

	@PostMapping(value="/produto/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Produtos> saveProdutos(@RequestBody Produtos produtos) {
		return produtosService.save(produtos);
	}

	@PutMapping("/produto/{id}")
	public Mono<ResponseEntity<Produtos>> updateProdutos2(@PathVariable(value="id")
															   String id,
													   @RequestBody Produtos produtos) {
		return produtosService.findById(id)
				.flatMap(existingProduto -> {
					existingProduto.setNome(produtos.getNome());
					existingProduto.setPreco(produtos.getPreco());
					return produtosService.save(existingProduto);
				})
				.map(updateProdutos-> ResponseEntity.ok(updateProdutos))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping(value="/produto")
	public Mono<Produtos> save(@RequestBody Produtos produtos){
		return produtosService.save(produtos);
	}


	@DeleteMapping("/produto/delete/{id}")
	public Mono<ResponseEntity<Void>> deleteProdutos2(@PathVariable(value = "id") String id) {
		return produtosService.findById(id)
				.flatMap(existingProdutos -> produtosService.delete(existingProdutos)
						.then(Mono.just(ResponseEntity.ok().<Void>build()))
				)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/produto/delete/todos")
	public Mono<Void> deleteAllProdutos() {
		return produtosService.deleteAll();
	}

	@GetMapping(value = "/tipos/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tipo> getTipoFlux() {
		return Flux.interval(Duration.ofSeconds(1))
				.map(val ->
						new Tipo(val, "Stream de Tipos")
				);
	}

}
