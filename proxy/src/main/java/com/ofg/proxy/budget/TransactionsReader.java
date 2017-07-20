package com.ofg.proxy.budget;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "budget")
public interface TransactionsReader {
    
    @GetMapping(value = "transactions")
    Resources<Transaction> read();
}
