package com.ofg.proxy.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionsApiGateway {
    
    private final TransactionsReader transactionsReader;

    @Autowired
    public TransactionsApiGateway(TransactionsReader transactionsReader) {
        this.transactionsReader = transactionsReader;
    }

    @GetMapping
    public Collection<Transaction> transactions(){
        return transactionsReader.read().getContent();
    }
}
