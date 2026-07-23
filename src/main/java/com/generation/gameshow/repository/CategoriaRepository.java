package com.generation.gameshow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gameshow.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	/* O JPA tem esses metodos integrados
	 * save();
		findAll();
			findById();
				deleteById();
					existsById();
	 */

    
    
	
    List<Categoria> findAllByTipoContainingIgnoreCase(String tipo);

    /* A linha acima findbyCo
     * busca todas as categorias cujo campo tipo contenha esse texto, ignorando maiúsculas e minúsculas.
     */

    
    
}