package com.butler.admin.common.config

import com.butler.admin.common.filter.JwtRequestFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        return http
            .csrf { it.disable() }
            .cors { it.disable() }
            .authorizeHttpRequests{ request ->
                request.requestMatchers("/admin/**").hasAnyAuthority("ROLE_SUPER_ADMIN", "ROLE_ADMIN")
                request.anyRequest().authenticated()
            }
            .addFilterBefore(JwtRequestFilter(), UsernamePasswordAuthenticationFilter::class.java)
            .formLogin(Customizer.withDefaults())
            .build()
    }
}