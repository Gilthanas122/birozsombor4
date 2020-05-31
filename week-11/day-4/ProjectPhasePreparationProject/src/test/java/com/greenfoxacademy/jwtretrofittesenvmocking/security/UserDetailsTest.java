package com.greenfoxacademy.jwtretrofittesenvmocking.security;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.UserDAO;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsTest {

  @Test
  public void createUserDetails_ReturnsExpectedUserDetailsFields() {
    UserDAO fakeUser = new UserDAO();
    fakeUser.setUsername("fakeUsername");
    fakeUser.setPassword("fakePassword");
    fakeUser.setRoles("ROLE_FAKE1,ROLE_FAKE2");
    UserDetails fakeUserDetails = new UserDetailsImpl(fakeUser);

    List<SimpleGrantedAuthority> expectedAuthorities = Arrays.asList(
        new SimpleGrantedAuthority("ROLE_FAKE1"),
        new SimpleGrantedAuthority("ROLE_FAKE2"));

    Assert.assertEquals("fakeUsername", fakeUserDetails.getUsername());
    Assert.assertEquals("fakePassword", fakeUserDetails.getPassword());
    Assert.assertEquals(Arrays.asList(new SimpleGrantedAuthority("ROLE_FAKE1"),
        new SimpleGrantedAuthority("ROLE_FAKE2")),
        fakeUserDetails.getAuthorities());
    Assert.assertTrue(fakeUserDetails.isAccountNonExpired());
    Assert.assertTrue(fakeUserDetails.isAccountNonLocked());
    Assert.assertTrue(fakeUserDetails.isCredentialsNonExpired());
    Assert.assertTrue(fakeUserDetails.isEnabled());
  }
}
