package com.LowLevelDesign.validator;

import com.LowLevelDesign.db.entity.Account;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountValidator {
  public boolean isValidUserName(Optional<Account> accountOptional, String userName) {
    return accountOptional.isPresent();
  }
}
