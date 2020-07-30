package com.linkedin.webflux.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "tipo")
public class Tipo {

    @Id
    long id;
    String nome;

    public Tipo(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
