package com.excelr.ExcelrSeptSpringboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyAppSecurity2 {
	

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
        //Authorisation
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	//Authentication               SPOC
    	http.authenticationProvider(myAuthenticationProvider());
    	
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/showAllPlayers",
                    "/addPlayerForm"
                ).hasAnyAuthority("USER", "ADMIN")

                .requestMatchers(
                    "/updatePlayerFormFE/**",
                    "/deletePlayerFE/**"
                ).hasAuthority("ADMIN")

                .anyRequest().authenticated()
            )

            .formLogin(form -> form
                .loginProcessingUrl("/login")
                .successForwardUrl("/showAllPlayers")
                .permitAll()
            )

            .logout(logout -> logout
                .logoutSuccessUrl("/login")
                .permitAll()
            )

            .exceptionHandling(exception -> exception
                .accessDeniedPage("/403")
            )

            .cors(cors -> {})

            .csrf(csrf -> csrf.disable());

        return http.build();
    }


    @Bean
    public AuthenticationProvider myAuthenticationProvider() {
		DaoAuthenticationProvider dao =new DaoAuthenticationProvider(mySetUserDetailsService());
		dao.setPasswordEncoder(passwordEncoder());
		return dao;
	}

    @Bean
    public UserDetailsService mySetUserDetailsService() {
		return new MyUserDetailsService();
	}

}
