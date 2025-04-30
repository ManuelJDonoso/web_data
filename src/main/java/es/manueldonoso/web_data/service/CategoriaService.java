package es.manueldonoso.web_data.service;

import es.manueldonoso.web_data.model.Categoria;
import es.manueldonoso.web_data.model.Producto;
import es.manueldonoso.web_data.repos.CategoriaRepository;
import es.manueldonoso.web_data.repos.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria>findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findByID(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Category not found"));

    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }
}
