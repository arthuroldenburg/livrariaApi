package com.example.aula.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}
//Abstrair a entidade Livro e:
//-Criar uma API em Spring que tenha:
//-LivroController (com get, post, put, delete)
//-LivroModel
//-LivroRepository
//-LivroDto
}
