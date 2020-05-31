package com.greenfoxacademy.jwtretrofittesenvmocking.util;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.UserDAO;
import com.greenfoxacademy.jwtretrofittesenvmocking.security.UserDetailsImpl;
import java.util.Date;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUtilTest {

  private JwtUtil jwtUtil;

  @BeforeEach
  public void beforeEach() {
    this.jwtUtil = new JwtUtil();
  }

  @Test
  public void extractUsername_ReturnsValidUsername() {
    UserDAO fakeUser = new UserDAO();
    fakeUser.setUsername("fakeUser");
    fakeUser.setPassword("fakePassword");
    fakeUser.setRoles("ROLE_FAKE,");
    UserDetails fakeUserDetails = new UserDetailsImpl(fakeUser);
    String generatedToken = "eyJhbGciOiJIUzI1NiJ9" +
        ".eyJzdWIiOiJmYWtlVXNlciIsImV4cCI6MTU5MDgwMjk1MiwiaWF0IjoxNTkwNzY2OTUyfQ" +
        ".TvUo_-6GalD6rQm10eACxLQ4CsaMXOhXUVE_3d36UKs";

    String username = jwtUtil.extractUsername(generatedToken);

    Assert.assertEquals(username, "fakeUser");
  }

  @Test
  public void extractExpirationDate_ReturnsValidUsername() {
    UserDAO fakeUser = new UserDAO();
    fakeUser.setUsername("fakeUser");
    fakeUser.setPassword("fakePassword");
    fakeUser.setRoles("ROLE_FAKE,");
    UserDetails fakeUserDetails = new UserDetailsImpl(fakeUser);
    String generatedToken = "eyJhbGciOiJIUzI1NiJ9" +
        ".eyJzdWIiOiJmYWtlVXNlciIsImV4cCI6MTU5MDgwMjk1MiwiaWF0IjoxNTkwNzY2OTUyfQ" +
        ".TvUo_-6GalD6rQm10eACxLQ4CsaMXOhXUVE_3d36UKs";

    Date expiration = jwtUtil.extractExpiration(generatedToken);

    Assert.assertNotNull(expiration);
  }
}
