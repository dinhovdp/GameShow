package com.generation.gameshow.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

	
public class Produto {
		@Entity // Gera uma tabela
		@Table(name = "tb_produto") // CREATE TABLE tb_categoria();
		
		 	
			
			@Id // PRIMARY KEY
			@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
			private Long id;
			
			@NotBlank(message = "O atributo título é obrigatório!")
			@Size(min = 2, max = 100, message = "O atributo Nome deve ter no mínimo 2 e no máximo 100 caracteres")
			@Column(length = 100)
			private String nome;
			
		
			@Size(min = 10, max = 6000, message = " A URL deve ter no mínimo 10 e no máximo 6000 caracteres")
			@Column(length = 1000)
			private String foto;
			
			@NotNull(message = "O preço é obrigatório!")
			@DecimalMin(value = "0.01", message = "O preço deve ser maior que zero!")
			@Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 10 dígitos inteiros e 2 decimais")
			@Column(nullable = false, precision = 12, scale = 2)
			private BigDecimal preco;
			

			public Produto produto; {
			}
			
			
			

	}


