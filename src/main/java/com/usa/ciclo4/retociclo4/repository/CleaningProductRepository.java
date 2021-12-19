package com.usa.ciclo4.retociclo4.repository;

import com.usa.ciclo4.retociclo4.model.CleaningProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo4.retociclo4.repository.crudrepository.CleaningProductCrudRepository;

@Repository
public class CleaningProductRepository {
    @Autowired
    private CleaningProductCrudRepository productCrudRepository;

    public List<CleaningProduct> getAll(){

        return (List<CleaningProduct>) productCrudRepository.findAll();
    }

    public Optional<CleaningProduct> getProduct(Integer id) {

        return productCrudRepository.findById(id);
    }

    public CleaningProduct save(CleaningProduct product) {

        return productCrudRepository.save(product);
    }

    public void update(CleaningProduct product) {
        productCrudRepository.save(product);
    }

    public void delete(CleaningProduct product) {
        productCrudRepository.delete(product);
    }

    public List<CleaningProduct> getByPrice(double price){
        return productCrudRepository.findByPriceLessThanEqual(price);
    }

    public List<CleaningProduct> getByDescriptionContains(String description){
        return productCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }


}
