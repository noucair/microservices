package com.mcommerce.zuulserver.configuration;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Configuration
public class SleuthConfig {


    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
