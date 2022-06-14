package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import ru.gb.config.JpaConfig;
import ru.gb.entity.Product;
import ru.gb.repository.ProductDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

   @Autowired
    private ProductDao productDao;

    public void save(Product product) {
        productDao.save(product);
    }

//    public void edit(Product product, Integer editId) {
//        productDao.edit(product, editId);
//    }

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
