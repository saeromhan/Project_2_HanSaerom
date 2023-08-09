package com.example.project7.controller;

package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private Map<String, User> usersDatabase = new HashMap<>();

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        if (usersDatabase.containsKey(user.getUsername())) {
            return "Username already exists!";
        }

        usersDatabase.put(user.getUsername(), user);
        return "SignUp successful!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (usersDatabase.containsKey(user.getUsername())) {
            User storedUser = usersDatabase.get(user.getUsername());
            if (storedUser.getPassword().equals(user.getPassword())) {
                return "Login successful!";
            }
        }

        return "Login failed!";
    }
}
