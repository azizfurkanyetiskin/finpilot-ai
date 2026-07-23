package com.azizfurkan.finpilotai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String taxNumber;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    private String address;

    @ManyToOne
    private Company company;
}
