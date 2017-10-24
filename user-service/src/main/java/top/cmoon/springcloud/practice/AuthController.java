package top.cmoon.springcloud.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.cmoon.springcloud.practice.model.User;

import java.util.Random;

/**
 * Created by cool_moon on 2017/10/12.
 */
@RestController
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);


    class ReturnInfo {
        private int code;
        private String msg;

        public ReturnInfo(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }


    @GetMapping("/auth")
    public Object auth(@RequestParam("username") String principal,
                       @RequestParam("password") String credentials) {

        int sleepTime = new Random().nextInt(3000);

        logger.info("sleep time: {}ms", sleepTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (principal.equals("admin") && credentials.equals("admin")) {
            User user = new User();
            user.setUserName("admin");
            return user;
        }

        return new ReturnInfo(1001, "user name or password incorrect");
    }

}
