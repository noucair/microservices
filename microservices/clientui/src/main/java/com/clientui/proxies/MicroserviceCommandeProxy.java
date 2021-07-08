package com.clientui.proxies;

import com.clientui.beans.CommandeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server", url = "localhost:9004")
public interface MicroserviceCommandeProxy {

    @PostMapping(value = "/microservice-commande/commandes")
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);

}
