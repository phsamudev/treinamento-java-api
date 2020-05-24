package com.example.demo.controller.dto;

import com.example.demo.model.AccountType;
import com.example.demo.model.TransactionType;

public class TransactionDTO {
  String userId;
  AccountType accountType;
  TransactionType transactionType;
  int value;

  public int getValue() {
    return value;
  }

  public void setValue(final int value) {
    this.value = value;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(final String userId) {
    this.userId = userId;
  }

  public AccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(final AccountType accountType) {
    this.accountType = accountType;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(final TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  
}