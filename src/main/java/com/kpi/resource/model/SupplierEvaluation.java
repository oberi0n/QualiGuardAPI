package com.kpi.resource.model;


import java.math.BigDecimal;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplierevaluation")
public class SupplierEvaluation extends PanacheEntity {

    @Column(name = "comments")
    public String comments;

    @Column(name = "evaluationDate")
    public java.time.LocalDate evaluationDate;

    @Column(name = "overallScore")
    public BigDecimal overallScore;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "kpi_id", foreignKey = @ForeignKey(name = "FK_kpi_id_supplierevaluation"))
    //@JoinColumn(name = "kpi_id")
    @ManyToOne
    public Kpi kpi;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "supplier_id", foreignKey = @ForeignKey(name = "FK_supplier_id_supplierevaluation"))
    //@JoinColumn(name = "supplier_id")
    @ManyToOne
    public Supplier supplier;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "contract_id", foreignKey = @ForeignKey(name = "fk_supplier_evaluation_contract"))
    //@JoinColumn(name = "contract_id")
    @ManyToOne
    public Contract contract;

    // Utility methods like findAll(), findById(), etc. can be added here.
}

