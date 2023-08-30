package com.LowLevelDesign.db.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
  private String doorNo;
  private String addressLine1;
  private String addressLine2;
  private String addressLine3;
  private Long pinCode;
  private String state;
  private String country;
}
