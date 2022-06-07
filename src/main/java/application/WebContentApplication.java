package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class WebContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebContentApplication.class, args);
    }
}
