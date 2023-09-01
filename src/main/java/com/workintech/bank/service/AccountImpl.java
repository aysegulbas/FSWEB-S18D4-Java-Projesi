package com.workintech.bank.service;

import com.workintech.bank.dao.AccountRepository;
import com.workintech.bank.entity.Account;
import com.workintech.bank.entity.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountImpl implements AccountService {
    private AccountRepository accountRepository;
@Autowired
    public AccountImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void delete(Account account) {
    accountRepository.delete(account);
    }

    @Override
    public Account findById(int id) {
        Optional<Account> optionalAccount=accountRepository.findById(id);
        if(optionalAccount.isPresent()){return optionalAccount.get();}
        return null;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
