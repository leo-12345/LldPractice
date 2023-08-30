package com.LowLevelDesign.db.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Optional;

public enum AccountStatus {
  ACTIVE(1),
  INACTIVE(2);

  private final int value;
  AccountStatus(int value){
    this.value = value;
  }
  @JsonCreator
  public static Optional<AccountStatus> fromValue(int value) {
    return Arrays.stream(AccountStatus.class.getEnumConstants()).filter(accountStatus -> accountStatus.getValue() == value).findFirst();
  }

  @JsonValue
  public int getValue() {
    return this.value;
  }
}
