package br.com.tudocelular.gestaolojacelular.service;

import br.com.tudocelular.gestaolojacelular.repository.LoginRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final LoginRepository loginRepository;

    public JwtUserDetailsService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var login = loginRepository.getByEmail(username);

        if(!login.getEmail().isEmpty()) {
            return new User(login.getEmail(), login.getSenha(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Username not found: " + username);
        }
    }
}
