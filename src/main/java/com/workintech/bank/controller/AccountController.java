package com.workintech.bank.controller;

import com.workintech.bank.entity.Account;
import com.workintech.bank.entity.Customer;
import com.workintech.bank.service.AccountService;
import com.workintech.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountService accountService;
    private CustomerService customerService;
    @Autowired
    public AccountController(AccountService accountService,CustomerService customerService) {
        this.accountService = accountService;
        this.customerService=customerService;
    }


    @GetMapping("/")
    public List<Account> get(){
        return accountService.findAll();
    }
    @GetMapping("/{id}")
    public Account getById(@PathVariable int id){
        Account account=accountService.findById(id);
        return account;
    }
    @DeleteMapping("/{id}")
    public Account delete(@PathVariable int id){
        Account account=getById(id);
        //Account account=accountService.getById(id)
        accountService.delete(account);
        return account;
    }
    @PostMapping("/{customerId}")//Parametre olarak gelen id ile ilgili customeri bulur ve Account objesini Customer ile ilişkilendirip veri tabanına kaydeder.
    public Account save(@RequestBody Account account,@PathVariable int customerId){
        Customer customer=customerService.findById(customerId);
        customer.add(account);
        account.setCustomer(customer);//accounta customer ekliyoruz (nasıl customera account ekliyorsak), accounta senin sahibin bu dedik
        return accountService.save(account);
    }
    @PutMapping("/{customerId}")////Parametre olarak gelen id ile ilgili customeri bulur ve Account objesinin yeni bilgilerini güncelleyip Customer ile ilişkilendirip veri tabanına kaydeder.
    public Account update(@RequestBody Account account,@PathVariable int customerId){
        Customer customer=customerService.findById(customerId);
        //hangi accountu değiştirmeye çalışıyoruz onu bulucaz, customer üzerindeki account objesini de değiştirmemiz lazım
        //Account foundAccount=customer.getAccountList().stream().filter(account1 -> account1.getAccount_id()==account.getAccount_id()).collect(Collectors.toList()).get(0);
        Account foundAccount=null;
        for(Account account1:customer.getAccountList()){
           if(account1.getAccount_id()==account.getAccount_id()){
               foundAccount=account1;
           }
        }
        if(foundAccount==null){
            //throw exception
        }
        int index=customer.getAccountList().indexOf(foundAccount);
        customer.getAccountList().set(index,account);//endekse git account adlı updated account bilgileri ile değiştir
        account.setCustomer(customer);//account customer ilişkisi kuruyoruz, en yukarda id ile bulduğumuz customer
        return accountService.save(account);
    }
}
