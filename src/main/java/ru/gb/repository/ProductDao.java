package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findAll();
    public String findNameById(Long id);

    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);

    Iterable<Product> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal priceMin, BigDecimal priceMax);



}
