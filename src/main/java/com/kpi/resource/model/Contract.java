package com.kpi.resource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract extends PanacheEntity {

    @Column(name = "nameContract")
    public String nameContract;

    @Column(name = "amount")
    public Double amount;

    @Column(name = "endDate")
    public java.time.LocalDate endDate;

    @Column(name = "specificTerms")
    public String specificTerms;

    @Column(name = "startDate")
    public java.time.LocalDate startDate;

    @Column(name = "status")
    public String status;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id", foreignKey = @ForeignKey(name = "FK_supplier_id_contract"))
    public Supplier supplier;

    // Utility methods like findAll(), findById(), etc. can be added here.
}


