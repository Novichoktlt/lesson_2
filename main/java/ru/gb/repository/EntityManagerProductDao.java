package ru.gb.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class EntityManagerProductDao implements ProductDao {

    List<Product> products = new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p").getResultList();
    }

    @Override
    public String findNameById(Long id) {
        TypedQuery<String> namedQuery = entityManager.createNamedQuery("Product.findNameById", String.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> namedQuery = entityManager.createNamedQuery("Product.findById", Product.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    @Override
    public Product save(Product product) {
       if (product.getId() == null) {
           entityManager.persist(product);
       }else {
           entityManager.merge(product);
       }
       return product;
    }

    @Override
    public void deleteById(Long id) {
        Product product = new Product();
        product.setId(id);
        delete(product);
    }
    public void delete(Product product) {
        Product mergedProduct = entityManager.merge(product);
        entityManager.remove(mergedProduct);
    }
}
