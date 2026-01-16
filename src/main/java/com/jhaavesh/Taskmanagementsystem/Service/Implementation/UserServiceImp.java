package com.jhaavesh.Taskmanagementsystem.Service.Implementation;

import com.jhaavesh.Taskmanagementsystem.Model.User;
import com.jhaavesh.Taskmanagementsystem.Repository.UserRepository;
import com.jhaavesh.Taskmanagementsystem.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor


public class UserServiceImp  implements UserService {

    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
       User saveUser = userRepository.save(user);
        return saveUser;

    }

    @Override
    public User getUserById(Long id) {

        User getUser = userRepository.findById(id).get();
        return getUser;

    }


    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setRoleId(userDetails.getRoleId());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
         userRepository.deleteById(id);
    }
}
