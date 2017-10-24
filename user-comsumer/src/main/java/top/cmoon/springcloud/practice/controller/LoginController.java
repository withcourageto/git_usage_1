package top.cmoon.springcloud.practice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.cmoon.springcloud.practice.model.User;
import top.cmoon.springcloud.practice.service.LoginService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cool_moon on 2017/10/17.
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public User login() {
        return loginService.login();
    }

}
