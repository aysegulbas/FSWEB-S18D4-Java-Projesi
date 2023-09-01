package com.workintech.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="adress",schema="spring")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="adress_id")
    private int id;
    @Column(name="street")
    private String street;
    @Column(name="no")
    private int no;
    @Column(name="city")
    private String city;
    @Column(name="country")
    private String country;
    @Column(name="description")
    private String description;
    @JsonIgnore
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
    mappedBy = "adress")
    private Customer customer;

    public void setId(int id) {
        this.id = id;
    }
}
