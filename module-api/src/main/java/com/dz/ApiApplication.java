package com.dz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class ApiApplication {
/*

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
*/

    private static final String APPLICATION_LOCATIONS = "spring.config.location=classpath:application.yml,/application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }


}