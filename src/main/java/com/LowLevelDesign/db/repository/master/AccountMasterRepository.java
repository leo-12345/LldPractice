package com.LowLevelDesign.db.repository.master;

import com.LowLevelDesign.db.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMasterRepository extends JpaRepository<Account, Long> {
  @Override
  <S extends Account> S save(S s);

}
