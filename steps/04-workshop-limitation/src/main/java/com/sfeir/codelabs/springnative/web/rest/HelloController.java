package com.sfeir.codelabs.springnative.web.rest;

import com.sfeir.codelabs.springnative.http.HeatlhSpringResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@RestController
public class HelloController {

    private final HeatlhSpringResource heatlhSpringResource;

    public HelloController() {
        RestClient restClient = RestClient.builder().baseUrl("http://localhost:8080").build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        heatlhSpringResource = factory.createClient(HeatlhSpringResource.class);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello "+name+ " !";
    }

    @GetMapping("/app/health")
    public ResponseEntity heatlh() {
        return ResponseEntity.ok(heatlhSpringResource.health().getBody());
    }
}
