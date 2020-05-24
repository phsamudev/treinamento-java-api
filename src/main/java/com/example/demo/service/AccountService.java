package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AccountType;
import com.example.demo.model.TransactionType;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class AccountService {

  @Autowired
  private UserRepository userRepository;

  public User create(final String userId, final AccountType accountType) throws Exception {
    final User user = userRepository.findById(userId).get();

    user.addAccount(accountType);

    return userRepository.save(user);
  }

  public User executeTransaction(final String userId, final AccountType accountType,
      final TransactionType transactionType, final int value) throws Exception {
    final User user = userRepository.findById(userId).get();

    if (!user.hasAccountType(accountType)) {
      throw new Exception("User doesn't have account of this type");
    }

    if (transactionType == TransactionType.DEPOSIT) {
      user.deposit(accountType, value);
    } else {
      user.withdraw(accountType, value);
    }

    return userRepository.save(user);
  }
}
