package com.sfeir.codelabs.springnative.web.rest;

import com.sfeir.codelabs.springnative.http.HeatlhSpringResource;
import com.sfeir.codelabs.springnative.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

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
        return "Hello " + name + " !";
    }

    @GetMapping("/app/health")
    public ResponseEntity heatlh() {
        return ResponseEntity.ok(heatlhSpringResource.health().getBody());
    }

    @GetMapping("/reflect")
    public ResponseEntity<String> testReflection() {
        try {
            Class<?> messageServiceClass = ClassUtils.forName(MessageService.class.getName(),  getClass().getClassLoader());
            Object instance = messageServiceClass.getDeclaredConstructor().newInstance();
            Method secretMethod = messageServiceClass.getDeclaredMethod("secretMessage");
            secretMethod.setAccessible(true);
            String result = (String) secretMethod.invoke(instance);
            return ResponseEntity.ok("Message obtenu par réflexion: " + result);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/resource")
    public ResponseEntity<String> testResource() {
        try {
            InputStream fileStream = getClass().getClassLoader().getResourceAsStream("test.txt");
            String content = new BufferedReader(
                    new InputStreamReader(fileStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            return ResponseEntity.ok(content);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(e.getMessage());
        }

    }
}
