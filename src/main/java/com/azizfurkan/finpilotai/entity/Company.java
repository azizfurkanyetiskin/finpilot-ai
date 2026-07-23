package com.azizfurkan.finpilotai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String taxNumber;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    private String address;
}
