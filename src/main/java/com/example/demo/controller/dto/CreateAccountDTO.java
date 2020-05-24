package com.example.demo.controller.dto;

import com.example.demo.model.AccountType;

public class CreateAccountDTO {
  String userId;
  AccountType type;

  public String getUserId() {
    return userId;
  }

  public void setUserId(final String userId) {
    this.userId = userId;
  }

  public AccountType getType() {
    return type;
  }

  public void setType(final AccountType type) {
    this.type = type;
  }
}