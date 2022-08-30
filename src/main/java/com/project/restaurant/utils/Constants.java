package com.project.restaurant.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    @Value("${spring.mail.username}")
    private String EMAIL_ADDRESS;

    @Value("${WEBSITE_URL}")
    private String WEB_URL;




    @Bean
    public String getEmailAddress() {
        return EMAIL_ADDRESS;
    }

    @Bean
    public String getWebUrl() {
        return WEB_URL;
    }


}
