package com.clientui.proxies;

import com.clientui.beans.ExpeditionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zuul-server")
public interface MicroserviceExpeditionProxy {

    @GetMapping("/microservice-expedition/etatExpedition/{id}")
    ExpeditionBean etatExpedition(@PathVariable("id") int id);
}
