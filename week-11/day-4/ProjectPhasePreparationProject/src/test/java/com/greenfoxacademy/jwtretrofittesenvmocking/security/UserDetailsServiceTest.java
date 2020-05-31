package com.greenfoxacademy.jwtretrofittesenvmocking.security;

import com.greenfoxacademy.jwtretrofittesenvmocking.model.dao.UserDAO;
import com.greenfoxacademy.jwtretrofittesenvmocking.repository.UserRepository;
import java.util.Arrays;
import java.util.Optional;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RunWith(JUnit4.class)
public class UserDetailsServiceTest extends TestCase {

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();
  private UserRepository userRepository;
  private UserDetailsService userDetailsService;

  @BeforeEach
  public void beforeEach() {
    this.userRepository = Mockito.mock(UserRepository.class);
    this.userDetailsService = new UserDetailsServiceImpl(this.userRepository);
  }

  @Test
  public void loadUserByUsername_WithExistingUsername_ReturnsValidUserDetails() {
    UserDAO fakeUser = new UserDAO();
    fakeUser.setUsername("fakeUser");
    fakeUser.setPassword("fakePassword");
    fakeUser.setRoles("FAKE_ROLE,");
    Optional<UserDAO> fakeUserOptional = Optional.of(fakeUser);

    Mockito.when(userRepository.findUserByUsername("fakeUser")).thenReturn(fakeUserOptional);

    UserDetails result = userDetailsService.loadUserByUsername("fakeUser");

    Assert.assertEquals("fakeUser", result.getUsername());
    Assert.assertEquals("fakePassword", result.getPassword());
    Assert.assertEquals(Arrays.asList(new SimpleGrantedAuthority("FAKE_ROLE")),
        result.getAuthorities());
  }

  @Test
  public void loadUserByUsername_WithNotExistingUsername_ThrowUsernameNotFoundException() {
    Mockito.when(userRepository.findUserByUsername("fakeUser")).thenReturn(Optional.empty());

    UserDetails result = userDetailsService.loadUserByUsername("fakeUser");

    exceptionRule.expect(UsernameNotFoundException.class);
    exceptionRule.expectMessage("User not found: fakeUser");
  }
}
