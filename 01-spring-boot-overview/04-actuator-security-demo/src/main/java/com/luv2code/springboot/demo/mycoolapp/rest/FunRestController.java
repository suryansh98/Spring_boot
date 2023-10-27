package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //expose "/" which will return "Hello World"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    //expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 5K";
    }

    //expose a new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getFortune(){
        return "It's your lucky day";
    }
}
