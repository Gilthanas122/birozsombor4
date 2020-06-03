package com.greenfoxacademy.jwtretrofittesenvmocking.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.jwtretrofittesenvmocking.exception.InvalidAuthorizationHeader;
import com.greenfoxacademy.jwtretrofittesenvmocking.exception.InvalidJwtTokenException;
import com.greenfoxacademy.jwtretrofittesenvmocking.exception.MissingUsernameException;
import com.greenfoxacademy.jwtretrofittesenvmocking.model.dto.ErrorDTO;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (InvalidAuthorizationHeader e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().write(convertObjectToJson(new ErrorDTO("Invalid Authorization " +
          "header and/or JWT token.")));
    } catch (MissingUsernameException e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().write(convertObjectToJson(new ErrorDTO("Username is missing from JWT " +
          "token.")));
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    } catch (InvalidJwtTokenException e) {
      response.getWriter().write(convertObjectToJson(new ErrorDTO("Invalid JWT token! Bad " +
          "credentials or expired token.")));
    }
  }


  public String convertObjectToJson(Object o) {
    ObjectMapper objectMapper = new ObjectMapper();
    String objectAsJson = null;
    try {
      objectAsJson = objectMapper.writeValueAsString(o);
    } catch (JsonProcessingException e) {
      System.out.println("Something went wrong with converting object to JSON in " +
          "ExceptionHandlerFilter!");
    }
    return objectAsJson;
  }
}
