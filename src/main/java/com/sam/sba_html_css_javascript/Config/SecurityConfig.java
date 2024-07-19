package com.sam.sba_html_css_javascript.Config;//package com.sam.sba_html_css_javascript.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Bean
////    public static PasswordEncoder passwordEncoder(){
////        return new BCryptPasswordEncoder();
////    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                                authorizeRequests
////                                .requestMatchers("/index","/static/css/**","/static/images/**","/static/JS/**").permitAll()
//                                        .requestMatchers("/static/css/**","/static/images/**","/static/js/**").permitAll()
//                                        .requestMatchers("/index").permitAll()
//                                        .requestMatchers("emailSubscription", "/emailSubscription/list").permitAll()
//                                        .requestMatchers("/parentRegister","/registeredParents/list").permitAll()
//                                        .requestMatchers("/childRegister","/registeredChildren/list").permitAll()
//                                        .requestMatchers("/employeeRegistration","/employeeList").permitAll()
//                                        .requestMatchers("/contact").permitAll()
//                                        .requestMatchers("/about").permitAll()
//                                        .requestMatchers("/login").permitAll()
//                                        .requestMatchers("/contact/list").permitAll()
//                                        .requestMatchers("/calculate").permitAll()
//                                        .requestMatchers("/welcome","/parentLogin","/adminLogin").permitAll()
//                                        .requestMatchers("/adminLogin").hasRole("ADMIN")
//                                        .requestMatchers("/parentLogin").hasRole("PARENT")
//                                        .anyRequest().authenticated()
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .defaultSuccessUrl("/index", true)
//
//                );
//        return http.build();
//
//
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(customUserDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }

//}



// src/main/java/com/example/security/SecurityConfig.java


import com.sam.sba_html_css_javascript.Service.AdminUserDetailsService;
import com.sam.sba_html_css_javascript.Service.ParentUserDetailsService;
import com.sam.sba_html_css_javascript.authenticationProvider.CustomAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private ParentUserDetailsService parentUserDetailsService;

    @Autowired
    private AdminUserDetailsService adminUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/adminDashboard").hasRole("ADMIN")
                        .requestMatchers("/parentDashboard").hasRole("PARENT")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/parentLogin")
                        .loginProcessingUrl("/parentLogin")
                        .defaultSuccessUrl("/parentDashboard", true)
                        .failureUrl("/parentLogin?error=true")
                        .permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/adminLogin")
                        .loginProcessingUrl("/adminLogin")
                        .defaultSuccessUrl("/adminDashboard", true)
                        .failureUrl("/adminLogin?error=true")
                        .permitAll()
                );
//                .logout(logout -> logout
//                        .permitAll()
//                );

        http.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider parentAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(parentUserDetailsService);
        return provider;
    }

    @Bean
    public DaoAuthenticationProvider adminAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(adminUserDetailsService);
        return provider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(parentAuthenticationProvider());
        auth.authenticationProvider(adminAuthenticationProvider());
    }

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationManagerBean();
    }
}







