package com.example.demo.iService;

import com.example.demo.model.Account;

import java.util.List;

public interface IAccountService {
    Account save(Account account);

    Iterable<Account> findAll();

    Account findOne(Long id);

    Account findAccountsByEmail(String email);

    Iterable<Account> findAllByNameContaining(String name);

    Account findAccountByEmail(String email);

    Boolean existsAccountByEmail(String email);

    List<Account> getAllAccountLikedThisStatus(Long id);


    List<Account> getAllAccountLikedThisComment(Long comment_id);
}
