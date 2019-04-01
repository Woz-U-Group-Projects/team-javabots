package com.props;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/owner").setViewName("owner");
        registry.addViewController("/resident").setViewName("resident");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/oresources").setViewName("oresources");
        registry.addViewController("/rresources").setViewName("rresources");
        registry.addViewController("/osecure").setViewName("osecure");
        registry.addViewController("/rsecure").setViewName("rsecure");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/services").setViewName("services");
        registry.addViewController("/rentals").setViewName("rentals");
        registry.addViewController("/property").setViewName("property");
    }

}