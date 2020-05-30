package com.darley.springconfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/**
 *    mvn spring-boot:run -Dserver.port=8085
 * */
@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

    private String driveClassName;
    private String url;
    private String username;
    private String password;
    //url: jdbc:h2:mem:db;DB_CLOSE_DELAY=-1

    @Profile("dev")
    @Bean
    public void testDatabaseConnection() {
        System.out.println("DB connection for DEV - H2");
        System.out.println(driveClassName);
        System.out.println(url);
       // return "DB Connection to H2_TEST instance";
    }
/**
 * server:
 *     port: 8085
 * */
    @Profile("prod")
    @Bean
    public void producaoDatabaseConnection() {
        System.out.println("DB connection for Prod - MYSQL");
        System.out.println(driveClassName);
        System.out.println(url);

      //  return "DB Connection to MYSQL_PRD instance";
    }
}