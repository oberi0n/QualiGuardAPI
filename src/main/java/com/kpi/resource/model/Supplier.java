package com.kpi.resource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier extends PanacheEntity {


    @Column(name = "address")
    public String address;

    @Column(name = "businessSector")
    public String businessSector;

    @Column(name = "contact")
    public String contact;

    @Column(name = "contactEmail")
    public String contactEmail;

    @Column(name = "contactName")
    public String contactName;

    @Column(name = "contactPhone")
    public String contactPhone;

    @Column(name = "email")
    public String email;

    @Column(name = "name")
    public String name;

    @Column(name = "phoneNumber")
    public String phoneNumber;

    @Column(name = "status")
    public String status;

    // Optionally, add utility methods like findAll(), findById(), etc. using PanacheEntity
}

