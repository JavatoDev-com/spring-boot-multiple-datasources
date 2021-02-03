package com.javatodev.api.repository.bank;

import com.javatodev.api.model.bank.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
