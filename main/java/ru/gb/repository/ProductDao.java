package ru.gb.repository;

import ru.gb.entity.Product;
import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    public String findNameById(Long id);
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);

}
