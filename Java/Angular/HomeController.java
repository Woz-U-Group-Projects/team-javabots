package com.props;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class HomeController {

	@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
    
    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/osecure")
    public String getOSecure() {
        return "osecure";
    }
    
    @GetMapping("/rsecure")
    public String getRSecure() {
        return "rsecure";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    
    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }
    
    @GetMapping("/oresources")
    public String getOResources() {
        return "oresources";
    }

    @GetMapping("/rresources")
    public String getRResources() {
        return "osecure";
    }
    
    @GetMapping("/services")
    public String getServices() {
        return "services";
    }

    @GetMapping("/rentals")
    public String getRentals() {
        return "rentals";
    }
    
    @GetMapping("/property")
    public String getProperty() {
        return "property";
    }
}