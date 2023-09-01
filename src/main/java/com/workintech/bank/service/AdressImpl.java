package com.workintech.bank.service;

import com.workintech.bank.dao.AdressRepository;
import com.workintech.bank.entity.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressImpl implements AdressService{
    private AdressRepository adressRepository;
    @Autowired

    public AdressImpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public List<Adress> findAll() {
        return adressRepository.findAll();
    }

    @Override
    public void delete(Adress adress) {
        adressRepository.delete(adress);

    }

    @Override
    public Adress findById(int id) {
        Optional<Adress>optionalAdress=adressRepository.findById(id);
        if(optionalAdress.isPresent()){return optionalAdress.get();}
        return null;
    }

    @Override
    public Adress save(Adress adress) {
        return adressRepository.save(adress);
    }
}
