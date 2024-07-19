package com.sam.sba_html_css_javascript;//package com.sam.sba_html_css_javascript;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SbaHtmlCssJavaScriptApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SbaHtmlCssJavaScriptApplication.class, args);
//    }
//
//}


// src/main/java/com/example/SpringBootApplication.java


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SbaHtmlCssJavaScriptApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbaHtmlCssJavaScriptApplication.class, args);
    }
}

