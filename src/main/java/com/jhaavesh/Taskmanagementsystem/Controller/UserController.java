package com.jhaavesh.Taskmanagementsystem.Controller;

import com.jhaavesh.Taskmanagementsystem.Model.User;
import com.jhaavesh.Taskmanagementsystem.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {


    private UserService userService;


    @PostMapping
    private ResponseEntity<User>  saveUserDetails(@RequestBody User user) {

        User saveUser = userService.saveUser(user);

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);


    }

    @GetMapping("/{id}")

    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);

    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);

        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build(); // 404 aaye ga agr  user nhi mila  Aj
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully" + id);
    }
}
