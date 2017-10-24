package top.cmoon.springcloud.practice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.cmoon.springcloud.practice.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cool_moon on 2017/10/24.
 */
@Service
public class LoginService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "loginFallback")
    public User login() {

        Map<String, String> params = new HashMap<>();
        params.put("username", "admin");
        params.put("password", "admin");

        return restTemplate.getForObject(
                "http://user-service/auth?username={username}&password={password}", User.class, params);
    }

    public User loginFallback() {
        return new User();
    }
}
