package com.example.app.security;

import com.example.app.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.selectByUsername(username)
                .map(r -> User.builder()
                        .username(r.username())
                        .password(r.password())
                        .disabled(!r.enabled())
                        .authorities(userRepository.selectAuthoritiesByUserId(r.id()).toArray(new String[0]))
                        .build()
                )
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
