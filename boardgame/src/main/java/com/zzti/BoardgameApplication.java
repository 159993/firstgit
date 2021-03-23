package com.zzti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zzti.mapper")
public class BoardgameApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardgameApplication.class, args);
    }

}
