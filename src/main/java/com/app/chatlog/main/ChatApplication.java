package com.app.chatlog.main;

import com.app.chatlog.constants.CommonConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static com.app.chatlog.constants.CommonConstants.BASE_PACKAGE;

@SpringBootApplication(scanBasePackages = BASE_PACKAGE)
@EntityScan(basePackages = BASE_PACKAGE)
@EnableJpaRepositories(basePackages = BASE_PACKAGE)
public class ChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }

}
