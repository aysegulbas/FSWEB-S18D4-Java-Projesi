package com.workintech.bank.service;

import com.workintech.bank.entity.Account;
import com.workintech.bank.entity.Adress;
import com.workintech.bank.entity.Customer;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    void delete(Account account);
    Account findById(int id);
    Account save(Account account);
}
