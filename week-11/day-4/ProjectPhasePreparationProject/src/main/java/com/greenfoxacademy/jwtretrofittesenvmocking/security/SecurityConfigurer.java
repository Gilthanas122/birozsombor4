package com.greenfoxacademy.jwtretrofittesenvmocking.security;

import com.greenfoxacademy.jwtretrofittesenvmocking.filter.ExceptionHandlerFilter;
import com.greenfoxacademy.jwtretrofittesenvmocking.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

  private UserDetailsService userDetailsService;
  private JwtRequestFilter jwtRequestFilter;
  private ExceptionHandlerFilter exceptionHandlerFilter;

  @Autowired
  public SecurityConfigurer(UserDetailsService userDetailsService,
                            JwtRequestFilter jwtRequestFilter,
                            ExceptionHandlerFilter exceptionHandlerFilter) {
    this.userDetailsService = userDetailsService;
    this.jwtRequestFilter = jwtRequestFilter;
    this.exceptionHandlerFilter = exceptionHandlerFilter;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasRole("USER")
        .antMatchers("/authenticate", "/register").permitAll()
        .anyRequest().authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    http.addFilterBefore(exceptionHandlerFilter, JwtRequestFilter.class);
  }

  /*
  //ez csak akkor működik, ha a filterben nincs try/catch (viszont így stacktraceli a consolet)
  private static void handleException(HttpServletRequest request,
                                      HttpServletResponse response,
                                      AuthenticationException e) throws IOException {
    PrintWriter writer = response.getWriter();
    writer.println(new ObjectMapper().writeValueAsString(new ErrorDTO("Unauthorized")));
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
  }*/

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
