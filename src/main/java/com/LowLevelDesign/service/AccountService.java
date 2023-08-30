package com.LowLevelDesign.service;

import com.LowLevelDesign.adapter.AccountAdapter;
import com.LowLevelDesign.db.entity.Account;
import com.LowLevelDesign.db.repository.master.AccountMasterRepository;
import com.LowLevelDesign.db.repository.slave.AccountSlaveRepository;
import com.LowLevelDesign.validator.AccountValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class AccountService {
  private static final Logger log = LoggerFactory.getLogger(AccountService.class);

  @Autowired
  private Scanner scanner;
  @Autowired
  private AccountMasterRepository accountMasterRepository;
  @Autowired
  private AccountSlaveRepository accountSlaveRepository;
  @Autowired
  private AccountAdapter accountAdapter;
  @Autowired
  private AccountValidator accountValidator;
  public void createAccount() {
    log.info("Going to create a new account");
    Account account = Account.builder().build();
    log.info("Please enter an user name for your account which you wish to have");
    String username = scanner.next();
    if(accountValidator.isValidUserName(getAccountByUserName(username), username)) {
      log.info("Username already exists. Hence unable to continue.");
      return;
    }
    account.setUserName(username);
    accountAdapter.setRelevantFields(account);
    accountMasterRepository.save(account);
    log.info("Successfully created a new account");
  }

  public void updateAccount() {
    log.info("Going to update an existing user");
    log.info("Please enter your user name of your account");
    String username = scanner.next();
    Optional<Account>accountOptional = getAccountByUserName(username);
    if(!accountValidator.isValidUserName(accountOptional, username)) {
      log.info("Account doesn't exist for the given username. Hence unable to continue.");
      return;
    }
    Account account = accountOptional.get();
    while(true) {
      log.info("Choose the field which you need to update by selecting the number\n1.contact no\n2.email\n3.display name\n4.Done updating, hence exit");
      String choice = scanner.next();
      if("4".equals(choice)) {
        break;
      } else if("1".equals(choice)) {
        accountAdapter.setContactNo(account);
      } else if("2".equals(choice)) {
        accountAdapter.setEmail(account);
      } else if("3".equals(choice)) {
        accountAdapter.setName(account);
      } else {
        log.info("Please enter a valid choice between 1-4");
      }
    }
    accountMasterRepository.save(account);
    log.info("Successfully updated the account for id {}", username);
  }

  public void deleteAccount(){
    log.info("Going to delete an existing user");
    log.info("Please enter your user name of your account");
    String username = scanner.next();
    Optional<Account>accountOptional = getAccountByUserName(username);
    if(!accountValidator.isValidUserName(accountOptional, username)) {
      log.info("Account doesn't exist for the given username. Hence unable to continue.");
      return;
    }
    accountMasterRepository.delete(accountOptional.get());
    log.info("Successfully deleted the account for id {}", username);
  }

  public Optional<Account> getAccountByUserName(String userName) {
    return accountSlaveRepository.findByUserName(userName);
  }
}
