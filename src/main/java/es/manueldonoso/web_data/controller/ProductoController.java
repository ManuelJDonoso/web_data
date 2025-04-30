package es.manueldonoso.web_data.controller;

import es.manueldonoso.web_data.model.Categoria;
import es.manueldonoso.web_data.model.Producto;
import es.manueldonoso.web_data.service.CategoriaService;
import es.manueldonoso.web_data.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    @ModelAttribute("categorias")
    public List<Categoria> categorias(){
        return categoriaService.findAll();
    }

    @GetMapping("/new")
    public String mostrarFormularioProducto(Model model){
    model.addAttribute("producto",new Producto());
        return "form-producto.html";
    }

    @PostMapping("/new/submit")
    public String ProcesarFormularioProducto(
        @ModelAttribute("producto") Producto producto){
        productoService.save(producto);
        return "redirect:/producto/list";
    }

    @ResponseBody
    @GetMapping({"/","list"})
    public String list(Model model){
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return productos.toString();
    }
}