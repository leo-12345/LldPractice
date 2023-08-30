package com.LowLevelDesign.db.entity;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
  private String name;
  private String contactNum;
  private Address address;
  private Timestamp joinedOn;
}
