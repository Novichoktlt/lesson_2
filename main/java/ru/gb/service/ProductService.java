package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public void edit(Product product, Integer editId) {
        productRepository.edit(product, editId);
    }

    public Product findById(Product product) {
        return productRepository.findById(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
