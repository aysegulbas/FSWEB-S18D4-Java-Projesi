package com.workintech.bank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="account",schema="spring")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private int account_id;
    @Column(name="account_name")
    private String account_name;
    @Column(name="money_amount")
    private int money_amount;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})//account silindiğinde customer silinmiycek
    @JoinColumn(name ="customer_id" )
    private Customer customer;//customer çağırırken accountları da çağırıyoruz, burda tekrar customer çağırıken loopa giriyor o yüzden jsonignore dedik customerda

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAccount_id() {
        return account_id;
    }
}
