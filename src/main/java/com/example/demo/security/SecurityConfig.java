package com.example.demo.security;

import com.example.demo.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig /* extends WebSecurityConfigurerAdapter */ {

  @Bean
  public GrantedAuthorityDefaults grantedAuthorityDefaults() {
    return new GrantedAuthorityDefaults("");
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return web -> web.ignoring();
  }

  @Bean
  public SecurityFilterChain mySecurityFilterChain(HttpSecurity http) throws Exception {
    return
    http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/h2").permitAll()
            .antMatchers("/app/v1/products").hasAnyRole("ROLE_ADMIN", "ROLE_MANAGER")
            .antMatchers("/app/v1/users").hasRole("ROLE_ADMIN")
            .anyRequest()
            .authenticated()
            .and()
            .formLogin().and().build();
  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    super.configure(http);
//  }
}
