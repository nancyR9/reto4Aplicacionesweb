package com.usa.ciclo4.retociclo4.controller;

import com.usa.ciclo4.retociclo4.model.CleaningProduct;
import com.usa.ciclo4.retociclo4.service.CleaningProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class ClleaningProductController {
    @Autowired
    private CleaningProductService productService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll(){
        return productService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CleaningProduct product){
        productService.save(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return  productService.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<CleaningProduct> getProduct(@PathVariable("id") Integer id){
        return productService.getProduct(id);
    }

    @GetMapping("/price/{price}")
    public List<CleaningProduct> getByPrice(@PathVariable("price") double price){
        return productService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<CleaningProduct> getByDescriptionContains(@PathVariable("description") String description){
        return productService.getByDescriptionContains(description);
    }
}
