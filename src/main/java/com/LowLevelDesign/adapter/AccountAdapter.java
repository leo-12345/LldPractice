package com.LowLevelDesign.adapter;

import com.LowLevelDesign.db.entity.Account;
import com.LowLevelDesign.db.enums.AccountStatus;
import com.LowLevelDesign.db.enums.AccountType;
import com.LowLevelDesign.service.AccountService;
import com.LowLevelDesign.validator.AccountValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AccountAdapter {
  @Autowired
  Scanner scanner;
  private static final Logger log = LoggerFactory.getLogger(AccountValidator.class);

  public Account setRelevantFields(Account account){
    account.setAccountType(AccountType.ADMIN);
    account.setAccountStatus(AccountStatus.ACTIVE);
    setName(account);
    setContactNo(account);
    setEmail(account);
    return account;
  }

  public Account setName(Account account) {
    log.info("Please enter your name which you wish to have");
    String name = scanner.next();
    account.setName(name);
    return account;
  }

  public Account setContactNo(Account account) {
    log.info("Please enter your contact number");
    String contactNo = scanner.next();
    account.setContactNum(contactNo);
    return account;
  }

  public Account setEmail(Account account) {
    log.info("Please enter your email");
    String email = scanner.next();
    account.setEmail(email);
    return account;
  }
}
