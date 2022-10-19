package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.entity.Product;

import ru.gb.repository.ProductDao;
import ru.gb.service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
class ProductController {

    boolean start = true;

    private final ProductService productService;
    private final ProductDao productDao;
    Long editId;


    @GetMapping("/create")
    public ModelAndView showForm(Model model) {
        model.addAttribute("product", new Product());
        return new ModelAndView("create-product");
    }

    @PostMapping( "/create")
    public ModelAndView processForm(Product product) {
        productService.save(product);
        return new ModelAndView("redirect:/product/all");
    }

    @GetMapping( "/{id}")
    public ModelAndView showChangeForm( Model model, @PathVariable Long id,
                                 @RequestParam(name="delete", defaultValue = "false", required = false)
                                         Boolean isDelete) {
        if (!isDelete) {
            editId = id;
            Optional<Product> findProduct;
            findProduct = productService.findById(editId);
            model.addAttribute("product", new Product());
            model.addAttribute("findProduct", findProduct.get());
            return new ModelAndView("edit");
        } else {
            productService.deleteById(id);
            return new ModelAndView("redirect:/product/all");
        }
    }

    @PostMapping("/edit")
    public ModelAndView changeForm(Product product) {
        product.setId(editId);
        productService.save(product);
        return new ModelAndView("redirect:/product/all");
    }

    @GetMapping("/app")
    public ModelAndView getApp(Model model) {
        model.addAttribute("findProduct", new Product());
        return new ModelAndView("app");
    }
    @GetMapping("/all")
    public ModelAndView getAllMessages(Model model, @RequestParam(name="sort", defaultValue = "")
    String isSort) {
        model.addAttribute("findProduct", new Product());
        model.addAttribute("products", productService.findAllSortedByPrice(isSort));
        return new ModelAndView("product-list");
    }

    @PostMapping("/search")
    public ModelAndView findById(Product product, Model model) {
        Optional<Product> findProduct;
        findProduct = productService.findById(product.getId());
        model.addAttribute("findProduct", findProduct.get());
        return new ModelAndView("search");
    }

    @PostMapping("/show")
    public ModelAndView findByPrice(BigDecimal min, BigDecimal max, Model model) {
        model.addAttribute("findProduct", new Product());
        Iterable<Product> products;
        products = productService.findByPrice(min, max);
        model.addAttribute("products", products);
        return new ModelAndView("product-list");
    }
}
