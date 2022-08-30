package com.project.restaurant.database.email;

import org.springframework.scheduling.annotation.Async;

public interface IEmailSender {

    @Async
    void send(String to, String email);

}
