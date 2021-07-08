package com.produits.microservice.dao;

import com.produits.microservice.configurations.ApplicationPropertiesConfiguration;
import com.produits.microservice.model.Product;
import com.produits.microservice.web.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer> {


    @RestController
    public class MyRestController {

        @Autowired
        ApplicationPropertiesConfiguration appProperties;

        @Autowired
        ProductRepository productDao;

        // Affiche la liste de tous les produits disponibles
        @GetMapping(value = "/products")
        public List<Product> listeDesProduits() {

            List<Product> products = productDao.findAll();

            if (products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

            List<Product> listeLimitee = products.subList(0, appProperties.getLimitDeProduits());

            return listeLimitee;

        }

        //Récuperer un produit par son id
        @GetMapping(value = "/products/{id}")
        public Optional<Product> recupererUnProduit(@PathVariable int id) {

            Optional<Product> product = productDao.findById(id);

            if (!product.isPresent())
                throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

            return product;
        }

    }

}
