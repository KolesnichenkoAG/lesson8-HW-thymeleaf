package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product getExpensive() {
        return productRepository.getExpensive();
    }

    public Product getCheap() {
        return productRepository.getCheap();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllByCostBetween(Integer min, Integer max) {
        return productRepository.findAllByCostBetween(min, max);
    }
}
