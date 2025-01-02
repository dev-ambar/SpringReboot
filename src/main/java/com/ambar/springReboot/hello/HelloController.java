package com.ambar.springReboot.hello;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class HelloController {


     @GetMapping("/hello")
     public String helloWorld()
     {
         return "Hello word with new way";
     }

     // using path variable
    //http://localhost:8080/v1/helloBean/AmbarGupta
     @GetMapping("/helloBean/{name}")
    public HelloWord helloWorldBean(@PathVariable String name)
    {
         System.out.println("hello -> "+name);
         return  new HelloWord("Hello!"+name);
    }

    // using requestParameter
    // http://localhost:8080/v1/helloBean?firstName=Ambar&lastName=Gupta
    @GetMapping("/helloBean")
    public HelloWord helloWorldBeanWithRequestParameter(@RequestParam String firstName,@RequestParam(required = false ,defaultValue = "") String lastName)
    {
        System.out.println("hello -> "+firstName+lastName);
        return  new HelloWord("Hello!"+firstName+lastName);
    }
     
     
     
}
