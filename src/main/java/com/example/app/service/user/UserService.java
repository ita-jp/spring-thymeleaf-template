package com.example.app.service.user;

import com.example.app.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void register(String username, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        userRepository.insert(username, encodedPassword, true);
    }
}
