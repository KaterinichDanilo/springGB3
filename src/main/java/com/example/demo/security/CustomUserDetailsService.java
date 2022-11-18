package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> userOptional = userRepository.findByLogin(username);
    User user = userOptional.orElseThrow(() -> new UsernameNotFoundException(username));
    List<GrantedAuthority> authorities = user.getRoles().stream()
      .map(Role::getName)
      .map(SimpleGrantedAuthority::new)
      .collect(Collectors.toList());

    return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
  }

}
