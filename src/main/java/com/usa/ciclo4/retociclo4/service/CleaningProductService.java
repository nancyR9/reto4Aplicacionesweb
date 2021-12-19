package com.usa.ciclo4.retociclo4.service;

import com.usa.ciclo4.retociclo4.model.CleaningProduct;
import com.usa.ciclo4.retociclo4.repository.CleaningProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningProductService {
    @Autowired
    private CleaningProductRepository productRepository;

    public List<CleaningProduct> getAll(){
        return productRepository.getAll();
    }

    public Optional<CleaningProduct> getProduct(Integer id){
        return productRepository.getProduct(id);
    }

    public CleaningProduct save(CleaningProduct product){
        if(product.getId() == null) {
            return product;
        }else{
            return productRepository.save(product);
        }
    }

    public CleaningProduct update(CleaningProduct product) {

        if (product.getId() != null) {
            Optional<CleaningProduct> dbProduct = productRepository.getProduct(product.getId());
            if (!dbProduct.isEmpty()) {
                if (product.getBrand() != null) {
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory() != null) {
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getPresentation() != null) {
                    dbProduct.get().setPresentation(product.getPresentation());
                }
                if (product.getDescription() != null) {
                    dbProduct.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                dbProduct.get().setAvailability(product.isAvailability());
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(Integer id){
        return getProduct(id).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }

    public List<CleaningProduct> getByPrice(double price){
        return productRepository.getByPrice(price);
    }

    public List<CleaningProduct> getByDescriptionContains(String description){
        return productRepository.getByDescriptionContains(description);
    }

}
