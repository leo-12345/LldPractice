package com.LowLevelDesign.db.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Optional;

public enum AccountType {
  ADMIN(1),
  LIBRARIAN(2),
  CUSTOMER(3);

  private final int value;
  AccountType(int value){
    this.value = value;
  }

  @JsonCreator
  public static Optional<AccountType> fromValue(int value) {
    return Arrays.stream(AccountType.class.getEnumConstants()).filter(accountStatus -> accountStatus.getValue() == value).findFirst();
  }

  @JsonValue
  public int getValue() {
    return this.value;
  }
}
