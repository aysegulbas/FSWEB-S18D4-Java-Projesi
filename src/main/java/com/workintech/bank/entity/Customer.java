package com.workintech.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="customer",schema="spring")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int id;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="email")
    private String email;
    @Column(name="salary")
    private int salary;
    @OneToOne(cascade = CascadeType.ALL)//customer silinirse adreste silincek
    @JoinColumn(name="adress_id")
    private Adress adress;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "customer")//customer silinirse tüm accountlar silincek
    private List<Account> accountList;

    public void setId(int id) {
        this.id = id;
    }
public void  add(Account account){
        if(accountList==null){
            accountList=new ArrayList<>();
        }accountList.add(account);
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
