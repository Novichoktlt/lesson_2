package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.gb.entity.Product;
import ru.gb.repository.ProductDao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

//    public Iterable<Product> findAll() {
//        return productDao.findAll();
//    }

    public Iterable<Product> findAllSortedByPrice(String isSort) {
        if (isSort.equals("max")){
        return productDao.findAll(Sort.by(Sort.Direction.DESC, "price"));
        }
        if (isSort.equals("mix")){
            return productDao.findAll(Sort.by(Sort.Direction.ASC, "price"));
        }
        return productDao.findAll();
    }

    public Iterable<Product> findByPrice(BigDecimal priceMin, BigDecimal priceMax) {
        if (priceMax == null){
            priceMax = BigDecimal.valueOf(0);
            return productDao.findByPriceGreaterThanEqualAndPriceLessThanEqual(priceMin, priceMax);
        }

            return productDao.findByPriceGreaterThanEqualAndPriceLessThanEqual(priceMin, priceMax);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}
