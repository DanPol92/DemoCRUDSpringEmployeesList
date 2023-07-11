package com.danp.demoCRUDSpring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig   {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(configurer->
                configurer.requestMatchers("/").hasAnyRole("EMPLOYEE","ADMIN")
                        .requestMatchers("/admin","/showFormForAdd","/showFormForUpdate","/save","/delete").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
            .formLogin(withDefaults());

            http.logout(logout->logout.permitAll());
            http.exceptionHandling(configurer-> configurer.accessDeniedPage("/access-denied"));

        return http.build();
    }
}
