package com.LowLevelDesign.db.entity;

import com.LowLevelDesign.db.converter.AccountStatusConverter;
import com.LowLevelDesign.db.converter.AccountTypeConverter;
import com.LowLevelDesign.db.enums.AccountStatus;
import com.LowLevelDesign.db.enums.AccountType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "account_details")
public class Account {
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;
  @Column(name = "user_name")
  private String userName;
  @Column(name = "account_password")
  private String password;
  @Column(name = "type")
  @Convert(converter = AccountTypeConverter.class)
  private AccountType accountType;
  @Column(name = "status")
  @Convert(converter = AccountStatusConverter.class)
  private AccountStatus accountStatus;
  @Column(name = "actual_name")
  private String name;
  @Column(name = "contact_no")
  private String contactNum;
  @Column(name = "email")
  private String email;
  @Column(name = "address")
  private String address;
  @Column(name = "created_at")
  @CreationTimestamp
  private Timestamp createdAt;
  @Column(name = "updated_at")
  @UpdateTimestamp
  private Timestamp updatedAt;
}
