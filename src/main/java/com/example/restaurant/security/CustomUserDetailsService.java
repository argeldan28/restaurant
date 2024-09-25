package com.example.restaurant.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.restaurant.model.User; // Assicurati di usare la tua classe User
import com.example.restaurant.repository.UserRepository;

//@Component -> prendi questa classe, istanziala, metti il suo oggetto nell'Application Context
//tutte le altre sono SPECIALIZZAZIONI di @Component

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Repository per accedere ai dati dell'utente

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Trova l'utente nel database utilizzando il repository
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Restituisci un'implementazione di UserDetails
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword()) // La password è già crittografata
                .roles(user.getRoles().stream().map(role -> role.getName()).toArray(String[]::new)) // Imposta i ruoli dell'utente
                .build();
    }
}
