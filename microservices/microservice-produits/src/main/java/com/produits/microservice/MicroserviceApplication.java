package com.produits.microservice;

import com.produits.microservice.dao.ProductRepository;
import com.produits.microservice.model.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


import java.util.Random;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
public class MicroserviceApplication implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;


    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Product.class);

        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            Product p = new Product();
            p.setTitre(RandomString.make(10));
            p.setPrix((double) (100 + rnd.nextInt(10000)));
            p.setImage("https://my-live-02.slatic.net/p/3/tupperware-zen-square-small-2-200ml-pink-amp-purple-0205-158666461-98ad54f8795809d082230401017fde9a.jpg");
            productRepository.save(p);
        }

    }
}
