package com.workintech.bank.service;

import com.workintech.bank.entity.Account;
import com.workintech.bank.entity.Adress;

import java.util.List;

public interface AdressService {
    List<Adress> findAll();
    void delete(Adress adress);
    Adress findById(int id);
    Adress save(Adress adress);
}
