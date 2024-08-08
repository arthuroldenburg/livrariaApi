package com.example.aula.livraria.controllers;

import com.example.aula.livraria.dtos.LivroRecordDto;
import com.example.aula.livraria.models.LivroModel;
import com.example.aula.livraria.repositories.LivroRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class LivroController {
    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<LivroModel>> getAllLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLivroById(@PathVariable(value = "id")UUID id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        if(livro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro nao encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(livro.get());
        }
    }

    @GetMapping("/{genero}")
    public ResponseEntity<List<LivroModel>> getLivrosByGenero(@PathVariable(value = "genero" ) String genero) {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findLivrosByGenero(genero));
    }

    @PostMapping
    public ResponseEntity<LivroModel> addLivro(@RequestBody @Valid LivroRecordDto livroRD) {
        LivroModel livroM = new LivroModel();
        BeanUtils.copyProperties(livroRD, livroM);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livroM));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLivro(@PathVariable(value = "id") UUID id) {
        Optional<LivroModel> livroM = livroRepository.findById(id);
        if(livroM.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro nao encontrado");
        }else {
            livroRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Livro excluido com sucesso!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid LivroRecordDto livroRD) {
        Optional<LivroModel> livroO = livroRepository.findById(id);
        if(livroO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product nao encontrado");
        }else {
            var livroM = livroO.get();
            BeanUtils.copyProperties(livroRD, livroM);
            return ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livroM));
        }
    }
}
