package com.example.managment_pharmacy.Controllers;

import com.example.managment_pharmacy.Entites.LoginRequest;
import com.example.managment_pharmacy.Entites.UpdateProfileResquest;
import com.example.managment_pharmacy.Entites.User;
import com.example.managment_pharmacy.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User newUser = userService.registerUser(user);
            return ResponseEntity.ok(newUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
        return user.isPresent() ? ResponseEntity.ok(user.get()) : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //return profile
    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getUserProfile(@PathVariable Long id){
        Optional<User> user=userService.getUserProfile(id);
        return user.isPresent() ? ResponseEntity.ok(user.get()):ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
    //mettre a joure le profile
    @PutMapping("/profile/{id}")
    public ResponseEntity<?> updateUserProfile(@RequestBody UpdateProfileResquest updateProfileResquest){
        try {
            User userupdate=userService.updateUserProfile(updateProfileResquest.getId(),updateProfileResquest.getUser());
            return ResponseEntity.ok(userupdate);

        }catch (RuntimeException e){
       return   ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
