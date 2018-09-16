package com.wolf89.wolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 主类.
 *
 * @author chried
 */
@SpringBootApplication
@EnableJpaRepositories(value = {
        "com.wolf89.wolf.dao",
        "com.wolf89.wolf.core.dao"
})
@EntityScan(value = {
        "com.wolf89.wolf.entity"
})
public class WolfApplication {

    public static void main(String[] args) {
        SpringApplication.run(WolfApplication.class, args);
    }
}
