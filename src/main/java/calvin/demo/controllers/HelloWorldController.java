package calvin.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import calvin.demo.models.Greeting;
import calvin.demo.services.HelloService;

@RestController
public class HelloWorldController {
    @Autowired
    HelloService helloService;
    
    @GetMapping("/")
    public Greeting printHelloWorld() {
        return helloService.greeting();
    }
}
