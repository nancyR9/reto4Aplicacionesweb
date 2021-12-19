package com.usa.ciclo4.retociclo4.repository.crudrepository;

import com.usa.ciclo4.retociclo4.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CleaningProductCrudRepository extends MongoRepository<CleaningProduct, Integer> {
    public List<CleaningProduct> findByPriceLessThanEqual(double price);
    public List<CleaningProduct> findByDescriptionContainingIgnoreCase(String description);
}
