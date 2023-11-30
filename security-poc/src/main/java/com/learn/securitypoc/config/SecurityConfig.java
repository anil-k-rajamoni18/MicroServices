package com.learn.securitypoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{

    private static final List<String> WHITELISTED_APIS = Arrays.asList("/", "/api/product/**", "/health");
    private static final String ENCRYPT_API = "/encrypt";

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) { //authentication
        /*UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN").build();

        UserDetails user = User
                .withUsername("kumar")
                .password(passwordEncoder.encode("kumar123"))
                .roles("USER").build();

        return new InMemoryUserDetailsManager(admin,user);
        */
        return new UserInfoUserDetailService();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //authorization
//            /*return http.csrf((csrf) -> csrf.disable())
//                    .authorizeHttpRequests().requestMatchers("/product/status").permitAll()
//                    .and()
//                    .authorizeHttpRequests().requestMatchers("/product/**").authenticated()
//                    .and().formLogin()
//                    .and().build();
//
//            */
//        return http.csrf(AbstractHttpConfigurer::disable)
//                .headers(header -> header.frameOptions().disable())
//                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
//                        .requestMatchers(antMatcher("/api/product/status")).permitAll())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(antMatcher("/api/product/addUser")).permitAll())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(antMatcher("/h2-console/**/**")).permitAll())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(antMatcher("/api/login")).permitAll())
//                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
//                        .requestMatchers(antMatcher("/api/product/**")).authenticated())
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/").permitAll())
//                .formLogin().loginProcessingUrl("/api/login")
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                .and()
//                .build();
//    }
//
//
    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        final String[] IGNOREENDPOINTS = {"/","/api/login/","/api/product/*","/h2-console/*"};
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(IGNOREENDPOINTS).permitAll()
                ).httpBasic();
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
