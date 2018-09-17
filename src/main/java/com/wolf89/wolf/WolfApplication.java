package com.wolf89.wolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

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
@EnableRedisRepositories(
        basePackages = {"com.wolf89.wolf.model.cache"},
        value = "com.wolf89.wolf.dao.system"
)
@EntityScan(value = {
        "com.wolf89.wolf.model.entity"
})
public class WolfApplication {

    public static void main(String[] args) {
        SpringApplication.run(WolfApplication.class, args);
    }
}
