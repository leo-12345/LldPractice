package com.LowLevelDesign.db.converter;

import com.LowLevelDesign.db.enums.AccountStatus;

import javax.persistence.AttributeConverter;

public class AccountStatusConverter implements AttributeConverter<AccountStatus, Integer> {
  @Override
  public Integer convertToDatabaseColumn(AccountStatus attribute) {
    return attribute.getValue();
  }

  @Override
  public AccountStatus convertToEntityAttribute(Integer dbData) {
    return AccountStatus.fromValue(dbData).get();
  }
}
