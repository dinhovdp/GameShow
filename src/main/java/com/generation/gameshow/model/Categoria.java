package com.generation.gameshow.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Categoria {

	@Entity // Gera uma tabela
	@Table(name = "tb_categorias") // CREATE TABLE tb_categoria();
	
	 	
		
		@Id // PRIMARY KEY
		@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
		private Long id;
		
		@NotBlank(message = "O atributo título é obrigatório!")
		@Size(min = 5, max = 100, message = "O atributo título deve ter no mínimo 5 e no máximo 100 caracteres")
		@Column(length = 100)
		private String tipo;
		
		@NotBlank(message = "O atributo descrição é obrigatório!")
		@Size(min = 10, max = 1000, message = "O atributo descrição deve ter no mínimo 10 e no máximo 1000 caracteres")
		@Column(length = 1000)
		private String descricao;
		
		@UpdateTimestamp
		private LocalDateTime data;

		public Categoria categoria; {
		}
		
		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public LocalDateTime getData() {
			return data;
		}

		public void setData(LocalDateTime data) {
			this.data = data;
		}

		
		
	
}

