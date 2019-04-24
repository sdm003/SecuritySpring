package com.example.Security.Controller;

import com.example.Security.Model.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
@GetMapping("/hello")
    public Hello helloSecured(){
        return new Hello("Hello World!! I am first Secure application!");
    }
    @GetMapping("/cashier")
    public Hello helloTeller(){
        return new Hello("Hello World!! I am first Secure application!");
    }
    @GetMapping("/check")
    public Hello helloSupervisor(){
        return new Hello("Hello World!! I am first Secure application!");
    }
    @GetMapping("/general")
    public Hello helloforTellerAndSupervisor(){
        return new Hello("Hello World!! I am first Secure application!");
    }
    @GetMapping("/shared")
    public Hello helloPermtiALL(){
        return new Hello("Hello World!! I am first Secure application!");
    }
}
