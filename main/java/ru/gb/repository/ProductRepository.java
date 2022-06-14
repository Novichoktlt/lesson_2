//package ru.gb.repository;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import ru.gb.entity.Product;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@Slf4j
//public class ProductRepository implements ProductProvider {
//
//    List<Product> products = new ArrayList<>();
//    List<Product> search = new ArrayList<>();
//
//    public List<Product> getProduct() {
//        products.add(new Product(1, "Tea", "45.20"));
//        products.add(new Product(2, "Coffee", "52.20"));
//        products.add(new Product(3, "Cocoa", "85.50"));
//        products.add(new Product(4, "Tomato", "52.20"));
//        products.add(new Product(5, "Onion", "41.40"));
//        return products;
//    }
//
//    public Product save(Product product) {
//        for (Product p : products) {
//            if (product.getId().equals(p.getId())) {
//                return null;
//            }
//        }
//        products.add(product);
//        return Product.builder()
//                .id(product.getId())
//                .title(product.getTitle())
//                .price(product.getPrice())
//                .build();
//    }
//
//    public Product edit(Product product, Integer editId) {
//
//        for (Product p : products) {
//            if (editId.equals(p.getId())) {
//                deleteById(editId);
//                product.setId(editId);
//                products.add(product);
//                return Product.builder()
//                        .id(product.getId())
//                        .title(product.getTitle())
//                        .price(product.getPrice())
//                        .build();
//            }
//        }
//        return null;
//    }
//
//    public Product findById(Product product) {
//            for (Product p : products) {
//                if ((product.getId()).equals(p.getId())) {
//                    search.add(p);
//                    return Product.builder()
//                            .title(p.getTitle())
//                            .price(p.getPrice())
//                            .build();
//                }
//            }
//        return null;
//    }
//
//    public void deleteById(Integer id) {
//        for (Product p : products) {
//            if (id.equals(p.getId())) {
//                products.remove(p);
//                break;
//            }
//        }
//    }
//
//    public List<Product> findAll() {
//        return new ArrayList<>(products);
//    }
//}
