package com.example.aula.livraria.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record LivroRecordDto(@NotBlank String nome, @NotBlank String descricao, @NotBlank String lancamento, @NotBlank String autor, @NotNull Integer numPaginas, @NotBlank String idioma, @NotBlank String editora, @NotBlank String genero) {
}
