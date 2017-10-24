package top.cmoon.springcloud.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.cmoon.springcloud.practice.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cool_moon on 2017/10/17.
 */
@RestController
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/login")
    public User login() {

        Map<String, String> params = new HashMap<>();
        params.put("username", "admin");
        params.put("password", "admin");

        return restTemplate.getForObject(
                "http://user-service/auth?username={username}&password={password}", User.class, params);
    }

}
