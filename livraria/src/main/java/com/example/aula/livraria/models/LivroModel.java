package com.example.aula.livraria.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroModel implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String descricao;
    private String lancamento;
    private String autor;
    private Integer numPaginas;
    private String idioma;
    private String editora;
    private String genero;
}
