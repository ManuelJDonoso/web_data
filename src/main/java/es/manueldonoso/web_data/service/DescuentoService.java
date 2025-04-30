package es.manueldonoso.web_data.service;

import es.manueldonoso.web_data.model.Producto;
import es.manueldonoso.web_data.repos.CategoriaRepository;
import es.manueldonoso.web_data.repos.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DescuentoService {
    private  final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    /**
     * Aplica un descuento a todos los productos de una categoria
     * @param descuento Un valor decimal entre 0 y 1
     * @param idCategoria idCategoria ID de la categoría
     * @return Lista de Productos Modificados
     */
    public List<Producto> aplicarDescuentoCategoria(double descuento, Long idCategoria){

    List<Producto> productos = productoRepository.findByCategoriaId(idCategoria);

    if(descuento <=0|| descuento  >1)
        throw new RuntimeException("el despuesto no puede ser menor a 0 ni mayor a 1");

    return  productoRepository.saveAll(
            productos.stream()
                    .map(producto -> {
                        producto.setPrecio(producto.getPrecio()*(1.0 -descuento));
                        return producto;
                    })
                    .toList()
    );
}

public  List<Producto>aplicarDescuentoCategorias(double descuento,List<Long>idsCategorias){
    List<Producto> result =new ArrayList<>();
    idsCategorias.forEach(id->{
        List<Producto> l =aplicarDescuentoCategoria(descuento,id);
        result.addAll(l);
    });
    return result;
}
}
