package com.workintech.bank.dao;

import com.workintech.bank.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress,Integer> {
}
