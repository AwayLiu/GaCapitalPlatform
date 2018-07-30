//package com.ga.capitalmgmtplatform.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private static final String[] exclusivePaths = {"/", "/login", "/res/css/**", "/res/js/**", "/res/fonts/**", "/res/img/**","/res/assets/**"};
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers(exclusivePaths).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/Login")
//                .defaultSuccessUrl("/index")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .csrf().disable();;
//    }
//
////    @Override
////    @Bean
////    public UserDetailsService userDetailsServiceBean() {
////        return new MyUserDetailServiceImpl();
////    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsServiceBean());
////    }
//}
