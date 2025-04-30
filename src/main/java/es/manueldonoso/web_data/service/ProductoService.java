package es.manueldonoso.web_data.service;

import es.manueldonoso.web_data.model.Producto;
import es.manueldonoso.web_data.repos.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto>findAll(){
        return productoRepository.findAll();
    }

    public Producto findByID(Long id){
        return productoRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Product not found"));

    }

    public void delete(Long id){
        productoRepository.deleteById(id);
    }
}
