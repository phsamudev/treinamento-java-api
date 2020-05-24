package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.CreateAccountDTO;
import com.example.demo.model.User;
import com.example.demo.service.AccountService;


@RequestMapping("/accounts")
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
	public User create(@RequestBody final CreateAccountDTO dto) throws Exception {
    return accountService.create(dto.getUserId(), dto.getType());
	}
}
