package com.LowLevelDesign.db.repository.slave;

import com.LowLevelDesign.db.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountSlaveRepository extends JpaRepository<Account, Long> {
  @Override
  Optional<Account> findById(Long id);

  Optional<Account> findByUserName(String userName);
}
