package com.clientui.proxies;

import com.clientui.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "zuul-server", url = "localhost:9004")
public interface MicroserviceProduitsProxy {

    @GetMapping(value = "/microservice-produits/products")
    List<ProductBean> listeDesProduits();

    /*
     * Notez ici la notation @PathVariable("id") qui est différente de celle qu'on utlise dans le contrôleur
     **/
    @GetMapping( value = "/microservice-produits/products/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);


}
