package ru.geekbrains.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.geekbrains.model.Product;
import ru.geekbrains.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/products")
    public List<Product> getFindAll() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public Product saveNewProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/between")
    public List<Product> getFindAllByCostBetween(@RequestParam(defaultValue = "100") Integer min, @RequestParam(defaultValue = "999999") Integer max) {
        return productService.findAllByCostBetween(min, max);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/expensive")
    public Product getExpensive() {
        return productService.getExpensive();
    }

    @GetMapping("/cheap")
    public Product getCheap() {
        return productService.getCheap();
    }
}
