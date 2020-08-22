package com.example.demo.ImplService;

import com.example.demo.iService.IAccountService;
import com.example.demo.model.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Iterable<Account> findAll() {
        return null;
    }

    @Override
    public Account findOne(Long id) {
        return null;
    }

    @Override
    public Account findAccountsByEmail(String email) {
        return null;
    }

    @Override
    public Iterable<Account> findAllByNameContaining(String name) {
        return null;
    }

    @Override
    public Account findAccountByEmail(String email) {
        return null;
    }

    @Override
    public Boolean existsAccountByEmail(String email) {
        return null;
    }

    @Override
    public List<Account> getAllAccountLikedThisStatus(Long id) {
        return null;
    }

    @Override
    public List<Account> getAllAccountLikedThisComment(Long comment_id) {
        return null;
    }
}
