package com.login.form.authorizationFiles;

import java.util.function.Supplier;

import com.login.form.models.User;
import com.login.form.repositories.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Supplier<UsernameNotFoundException> exception = () -> new UsernameNotFoundException(
        "Problem during authentication.");

    User user = userRepository.findUserByUsername(username).orElseThrow(exception);

    return new CustomUserDetails(user);
  }

}
