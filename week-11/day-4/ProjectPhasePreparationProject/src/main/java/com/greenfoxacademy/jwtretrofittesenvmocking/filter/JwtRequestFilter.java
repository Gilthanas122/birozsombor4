package com.greenfoxacademy.jwtretrofittesenvmocking.filter;

import com.greenfoxacademy.jwtretrofittesenvmocking.exception.InvalidAuthorizationHeader;
import com.greenfoxacademy.jwtretrofittesenvmocking.exception.InvalidJwtTokenException;
import com.greenfoxacademy.jwtretrofittesenvmocking.exception.MissingUsernameException;
import com.greenfoxacademy.jwtretrofittesenvmocking.util.JwtUtil;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  private UserDetailsService userDetailsService;
  private JwtUtil jwtUtil;

  @Autowired
  public JwtRequestFilter(UserDetailsService userDetailsService, JwtUtil jwtUtil) {
    this.userDetailsService = userDetailsService;
    this.jwtUtil = jwtUtil;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException,
      InvalidJwtTokenException {
    //ha a /register vagy /authenticate endpoint hívódik meg, akkor nem fut le a filter
    String path = request.getRequestURI();
    if (path.equals("/register") || path.equals("/authenticate")) {
      filterChain.doFilter(request, response);
      return;
    }

    String authorizationHeader = request.getHeader("Authorization");
    String username = null;
    String jwt = null;

    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      try {
        jwt = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(jwt);
      } catch (Exception e) {
        System.out.println("Wrong JWT format!");
      }
    } else {
      throw new InvalidAuthorizationHeader();
    }


    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);
      if (jwtUtil.validateToken(jwt, userDetails)) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
            new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      } else {
        throw new InvalidJwtTokenException();
      }
    } else {
      throw new MissingUsernameException();
    }

    filterChain.doFilter(request, response);
  }
}
