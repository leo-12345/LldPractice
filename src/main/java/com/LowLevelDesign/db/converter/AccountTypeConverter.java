package com.LowLevelDesign.db.converter;

import com.LowLevelDesign.db.enums.AccountType;

import javax.persistence.AttributeConverter;

public class AccountTypeConverter implements AttributeConverter<AccountType, Integer> {
  @Override
  public Integer convertToDatabaseColumn(AccountType attribute) {
    return attribute.getValue();
  }

  @Override
  public AccountType convertToEntityAttribute(Integer dbData) {
    return AccountType.fromValue(dbData).get();
  }
}
