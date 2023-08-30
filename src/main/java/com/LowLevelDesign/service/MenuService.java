package com.LowLevelDesign.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MenuService {
  @Autowired
  Scanner scanner;
  @Autowired
  AccountService accountService;
  private static final Logger log = LoggerFactory.getLogger(MenuService.class);
  public void showMenu(){
    while(true){
      log.info("\nEnter a choice \n1.Create an user\n2.Update an user\n3.Delete an user\n4.Exit");
      String choice = scanner.next();
      if(isEndingChoice(choice)){
        processEndingChoice();
        break;
      }
      processChoice(choice);
    }
  }

  private void processChoice(String choice){
    if("1".equals(choice)){
      accountService.createAccount();
    } else if("2".equals(choice)){
      accountService.updateAccount();
    } else if("3".equals(choice)){
      accountService.deleteAccount();
    } else {
      log.info("Please enter a valid choice between 1-4");
    }
    log.info("-----------------------");
  }

  private boolean isEndingChoice(String choice){
    return "4".equals(choice);
  }

  private void processEndingChoice(){
    log.info("-----Exit----------");
  }
}
