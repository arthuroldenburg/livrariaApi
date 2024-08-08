package com.example.aula.livraria.repositories;

import com.example.aula.livraria.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, UUID> {
    @Query("select * from livro where livro.genero = :genero")
    List<LivroModel> findLivrosByGenero(String genero);
}
