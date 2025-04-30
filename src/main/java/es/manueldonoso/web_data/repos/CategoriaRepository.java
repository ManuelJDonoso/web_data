package es.manueldonoso.web_data.repos;

import es.manueldonoso.web_data.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository
        extends JpaRepository<Categoria,Long> {
}
