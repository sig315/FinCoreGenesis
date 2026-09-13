package com.fincore.fincoregenesis.repository;

import com.fincore.fincoregenesis.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByAccountNumber(String accountNumber);

}