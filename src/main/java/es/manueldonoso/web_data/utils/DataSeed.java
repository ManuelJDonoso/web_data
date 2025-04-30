package es.manueldonoso.web_data.utils;

import es.manueldonoso.web_data.model.Categoria;
import es.manueldonoso.web_data.model.Producto;
import es.manueldonoso.web_data.repos.CategoriaRepository;
import es.manueldonoso.web_data.repos.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeed {
    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @PostConstruct
    public void insertData(){

        Categoria categoriaElectronica = Categoria.builder().nombre("Electrinica").build();
        Categoria categoriaHogar = Categoria.builder().nombre("Hogar").build();

        categoriaRepository.save(categoriaElectronica);
        categoriaRepository.save(categoriaHogar);

        Producto producto1 = Producto.builder()
                .nombre("Aspiradora")
                .precio(150.65)
                .categoria(categoriaHogar)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("Cafetera")
                .precio(88.99)
                .categoria(categoriaHogar)
                .build();

        Producto producto3 = Producto.builder()
                .nombre("Lapara de mesa")
                .precio(29.99)
                .categoria(categoriaHogar)
                .build();

        Producto producto4 = Producto.builder()
                .nombre("mesa")
                .precio(70.99)
                .categoria(categoriaHogar)
                .build();

        Producto producto5 = Producto.builder()
                .nombre("Auriculares Inalambrico")
                .precio(59.99)
                .categoria(categoriaElectronica)
                .build();

        Producto producto6 = Producto.builder()
                .nombre("Telefono")
                .precio(700.00)
                .categoria(categoriaElectronica)
                .build();

        List<Producto> productos=
                List.of(producto1,producto2,producto3,producto4,producto5,producto6);
        productoRepository.saveAll(productos);

    }
}
