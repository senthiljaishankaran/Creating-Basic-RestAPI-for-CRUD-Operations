package com.Spring.SpringBoot.GettingStarted.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
    @Value("${welcome.message}")
    private String welcomeMessage;
    // we can use either Below Request mapping method and set value and method type
    // or we can directly use the @GetMapping or other method Mappings
    //@RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/")
    public String welcomePage(){
        return welcomeMessage;
    }
}
