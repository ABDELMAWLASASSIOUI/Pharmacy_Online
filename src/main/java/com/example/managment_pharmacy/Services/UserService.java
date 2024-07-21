package com.example.managment_pharmacy.Services;

import com.example.managment_pharmacy.Entites.User;
import com.example.managment_pharmacy.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Méthodes existantes...

    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
   public List<User> getAllUsers(){return userRepository.findAll();}


    // Mise à jour du profil utilisateur
    public User updateUserProfile(Long id, User userProfile) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found");
        }
        User user = optionalUser.get();
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());
        user.setEmail(userProfile.getEmail());
        user.setPhoneNumber(userProfile.getPhoneNumber());
        user.setAddress(userProfile.getAddress());
        user.setDateOfBirth(userProfile.getDateOfBirth());
        // Ne mettez à jour le mot de passe que si un nouveau mot de passe est fourni
        if (userProfile.getPassword() != null && !userProfile.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userProfile.getPassword()));
        }


        return userRepository.save(user);
    }
    //afficher le profile
    public Optional<User> getUserProfile(Long id) {
        return userRepository.findById(id);
    }


}
