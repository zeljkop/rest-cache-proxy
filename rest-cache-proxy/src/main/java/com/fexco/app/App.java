package com.fexco.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zpusec
 * Spring boot entry point.
 */
@SpringBootApplication
@ComponentScan("com.fexco")
@EnableCaching
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
