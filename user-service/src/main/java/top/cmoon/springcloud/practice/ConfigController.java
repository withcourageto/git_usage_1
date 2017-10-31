package top.cmoon.springcloud.practice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbName;

    @Value("${db.password}")
    private String dbPassword;

    @RequestMapping("/config/db")
    public String config() {
        return dbUrl + " " + dbName + " " + dbPassword;

    }
}
