package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.entity.Product;
import ru.gb.repository.ProductDao;

@Service
@RequiredArgsConstructor
public class ProductService {

   @Autowired
    private ProductDao productDao;

    public void save(Product product) {
        productDao.save(product);
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }

    public Iterable<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}
