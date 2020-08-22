package com.example.demo.ImplService;

import com.example.demo.iService.IAccountService;
import com.example.demo.model.Account;
import com.example.demo.model.CustomUserDetails;
import com.example.demo.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService, UserDetailsService {
    @Autowired
    IAccountRepository iAccountRepository;

    @Override
    public Account save(Account account) {
        return iAccountRepository.save(account);
    }

    @Override
    public Iterable<Account> findAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public Account findOne(Long id) {
        return iAccountRepository.findById(id).get();
    }

    @Override
    public Account findAccountsByEmail(String email) {
        return iAccountRepository.findAccountsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = iAccountRepository.findAccountsByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException(email);
        }
        return new CustomUserDetails(account);
    }

    @Override
    public Iterable<Account> findAllByNameContaining(String name) {
        return null;
    }

    @Override
    public Account findAccountByEmail(String email) {
        return iAccountRepository.findAccountsByEmail(email);
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
