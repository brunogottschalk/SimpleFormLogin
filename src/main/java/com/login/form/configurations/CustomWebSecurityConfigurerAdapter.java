package com.login.form.configurations;

import com.login.form.authorizationFiles.CustomAuthenticationProviderService;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  private final CustomAuthenticationProviderService authenticationProviderService;

  public CustomWebSecurityConfigurerAdapter(CustomAuthenticationProviderService authenticationProviderService) {
    this.authenticationProviderService = authenticationProviderService;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProviderService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().defaultSuccessUrl("/main", true);

    http.authorizeRequests().anyRequest().authenticated();
  }

}
