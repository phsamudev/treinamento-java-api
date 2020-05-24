package com.example.demo.model;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
  @Id
  String id;
  String email;
  String password;
  HashMap<AccountType, Integer> accounts;

  public User(final String email, final String password) {
    this.email = email;
    this.password = password;
    this.accounts = new HashMap<>();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public HashMap<AccountType, Integer> getAccounts() {
    return this.accounts;
  }

  public void addAccount(final AccountType accountType) {
    this.accounts.put(accountType, 0);
  }

  public Boolean hasAccountType(final AccountType accountType) {
    return this.accounts.keySet().contains(accountType);
  }

  public void deposit(final AccountType accountType, final int value) {
    this.accounts.put(accountType, this.accounts.get(accountType) + value);
  }

  public void withdraw(final AccountType accountType, final int value) {
    this.accounts.put(accountType, this.accounts.get(accountType) - value);
  }
}
