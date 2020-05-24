package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.TransactionDTO;
import com.example.demo.model.User;
import com.example.demo.service.AccountService;

@RequestMapping("/transactions")
@RestController
public class TransactionController {

  @Autowired
  private AccountService accountService;

  @RequestMapping(method = RequestMethod.PUT)
  @ResponseBody
  public User create(@RequestBody final TransactionDTO dto) throws Exception {
    return accountService.executeTransaction(dto.getUserId(), dto.getAccountType(), dto.getTransactionType(),
        dto.getValue());
  }
}
