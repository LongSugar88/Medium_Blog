package com.example.demo.repository;

import com.example.demo.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepository extends CrudRepository<Account, Long> {
    Account findAccountsByEmail(String email);
    Iterable<Account> findAllByNameContaining(String name);

}
