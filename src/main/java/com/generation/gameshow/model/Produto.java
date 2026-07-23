package com.generation.gameshow.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

		@Entity // informa ao Spring que a classe sera uma  tabela
				//Mas, ele só cria se estiver o hibernate no app.properties
		@Table(name = "tb_produto") // CREATE TABLE tb_produto();
public class Produto {
	
		
		 	
			
			@Id // PRIMARY KEY
			@GeneratedValue(strategy = GenerationType.IDENTITY) // id AUTO_INCREMENT
			private Long id;
			
			@NotBlank(message = "O atributo Nome é obrigatório!")
			@Size(min = 2, max = 100, message = "O atributo Nome deve ter no mínimo 2 e no máximo 100 caracteres")
			@Column(length = 100)
			private String nome;
			
		
			@Size(min = 10, max = 6000, message = " A URL deve ter no mínimo 10 e no máximo 6000 caracteres")
			@Column(length = 6000)
			private String foto;
			
			@NotNull(message = "A quantidade é obrigatória!")
			private Integer quantidade;
			
			@NotNull(message = "O preço é obrigatório!")
			@DecimalMin(value = "0.01", message = "O preço deve ser maior que zero!")
			@Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 10 dígitos inteiros e 2 decimais")
			@Column(nullable = false, precision = 12, scale = 2) //total 12 digitos, sendo 2 decimais.
			private BigDecimal preco;
			

			// Muitos  produtos podem pertencer à UMA categoria.
			@ManyToOne

			// chave estrangeira (FK) categoria_id na tabela Produto.
			@JoinColumn(name = "categoria_id")
			private Categoria categoria;

			//  criando um construtor vazio para o Hibernate/Spring conseguir criar objetos.
			public Produto() {
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getNome() {
				return nome;
			}

			public void setNome(String nome) {
				this.nome = nome;
			}

			public String getFoto() {
				return foto;
			}

			public void setFoto(String foto) {
				this.foto = foto;
			}

			public Integer getQuantidade() {
				return quantidade;
			}

			public void setQuantidade(Integer quantidade) {
				this.quantidade = quantidade;
			}

			public BigDecimal getPreco() {
				return preco;
			}

			public void setPreco(BigDecimal preco) {
				this.preco = preco;
			}

			public Categoria getCategoria() {
				return categoria;
			}

			public void setCategoria(Categoria categoria) {
				this.categoria = categoria;
			}
			
			
			

	}


