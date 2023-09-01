package com.workintech.bank.controller;

import com.workintech.bank.entity.Adress;
import com.workintech.bank.entity.Customer;
import com.workintech.bank.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adress")
public class AdressContoller {
    private AdressService adressService;
@Autowired
    public AdressContoller(AdressService adressService) {
        this.adressService = adressService;
    }
    @GetMapping("/")
    public List<Adress> get(){
        return adressService.findAll();
    }
    @GetMapping("/{id}")
    public Adress getById(@PathVariable int id){
        Adress adress=adressService.findById(id);
        return adress;
    }
    @DeleteMapping("/{id}")
    public Adress delete(@PathVariable int id){
        Adress adress=getById(id);
        adressService.delete(adress);
        return adress;
    }
    @PostMapping("/customers")
    public Adress save(@RequestBody Adress adress){
        return adressService.save(adress);
    }
    @PutMapping("/{id}")
    public Adress update(@RequestBody Adress adress,@PathVariable int id){
        Adress foundAddress=getById(id);
        if(foundAddress!=null){
            adress.setId(id);
            return adressService.save(adress);

        }
    return null;
    }
}
