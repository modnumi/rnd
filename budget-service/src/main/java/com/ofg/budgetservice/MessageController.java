package com.ofg.budgetservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {

    private final String message;

    @Autowired
    public MessageController(@Value("${message}") String message) {
        this.message = message;
    }

    @GetMapping(value = "/message")
    public String getMessage() {
        return message;
    }
}
