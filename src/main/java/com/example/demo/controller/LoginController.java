package com.example.demo.controller;

import com.example.demo.mapper.CasuserMapper;
import com.example.demo.model.Casuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private CasuserMapper userMapper;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password) {
        Casuser user = userMapper.findUserByUsernameAndPassword(username, password);
        Map<String, Object> response = new HashMap<>();
        
        if (user != null) {
            response.put("status", "success");
            response.put("user", user);
        } else {
            response.put("status", "error");
            response.put("message", "Invalid username or password");
        }
        
        return response;
    }

    @GetMapping("/test")
    public String test() {
        return "Spring Boot Test Success";
    }
    
}
