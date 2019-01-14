package com.runke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.runke.mapper")
public class SpringBootMybatisPagehelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisPagehelperApplication.class, args);
    }

}

