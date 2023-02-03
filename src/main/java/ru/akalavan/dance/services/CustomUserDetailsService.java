package ru.akalavan.dance.services;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.akalavan.dance.models.User;
import ru.akalavan.dance.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class CustomUserDetailsService
 *
 * @author Вагин Михаил
 * date 20.01.2023
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return build(user);
    }

    public User loadUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public static User build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new User(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                authorities
        );
    }
}
