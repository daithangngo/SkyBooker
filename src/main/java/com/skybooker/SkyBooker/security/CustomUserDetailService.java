package com.skybooker.SkyBooker.security;

import com.skybooker.SkyBooker.entities.User;
import com.skybooker.SkyBooker.exceptions.NotFoundException;
import com.skybooker.SkyBooker.repositories.UserRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new NotFoundException("User not found with username: " + username));

        return AuthUser.builder().user(user).build();
    }
}
