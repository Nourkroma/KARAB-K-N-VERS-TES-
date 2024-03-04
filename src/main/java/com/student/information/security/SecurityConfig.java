// package com.student.information.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


// import jakarta.servlet.http.HttpServletRequest;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;



// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
//         http
//         .cors(cors -> cors.configurationSource(new CorsConfig()))

//         .authorizeHttpRequests((authz) -> authz
//                         .anyRequest().permitAll());
//         return http.build();
//     }

// }

