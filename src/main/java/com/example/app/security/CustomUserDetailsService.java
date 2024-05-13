package com.example.app.security;

import com.example.app.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(r -> User.builder()
                        .username(r.username())
                        .password(r.password())
                        .disabled(!r.enabled())
                        .authorities(List.of())
                        .build()
                )
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
