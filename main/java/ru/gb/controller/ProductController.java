package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.entity.Product;

import ru.gb.repository.ProductDao;
import ru.gb.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    boolean start = true;

    private final ProductService productService;
    private final ProductDao productDao;
    Long editId;


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "create-product";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processForm(Product product) {
        productService.save(product);
        return "redirect:/product/all";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showChangeForm(Model model, @PathVariable Long id,
                                 @RequestParam(name="delete", defaultValue = "false", required = false)
                                         Boolean isDelete) {
        if (!isDelete) {
            editId = id;
            model.addAttribute("product", new Product());
            return "edit";
        } else {
            productService.deleteById(id);
            return "redirect:/product/all";
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String changeForm(Product product) {
        product.setId(editId);
        productService.save(product);
        return "redirect:/product/all";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllMessages(Model model) {
        model.addAttribute("findProduct", new Product());
        if (start) {
            model.addAttribute("msg", productDao.findAll());
            start = false;
        }
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String findById(Product product, Model model) {
        Product findProduct;
        findProduct = productService.findById(product.getId());
        model.addAttribute("findProduct", findProduct);
        return "search";
    }

}