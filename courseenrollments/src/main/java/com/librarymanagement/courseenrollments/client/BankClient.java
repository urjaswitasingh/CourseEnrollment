package com.librarymanagement.courseenrollments.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@FeignClient(url = "http://localhost:8081", name = "fundtransfer")
public interface BankClient {
    @PostMapping("/sbiBank/fundTransfer")
    public String fundTransfer(@RequestParam int userId, @RequestParam int senderAcc,@RequestParam int receiverAcc,@RequestParam String ifscCode ,@RequestParam double amount);
}