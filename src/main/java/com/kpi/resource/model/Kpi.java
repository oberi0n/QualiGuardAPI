package com.kpi.resource.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "kpi")
public class Kpi extends PanacheEntity {

    @Column(name = "description")
    public String description;

    @Column(name = "kpiType")
    public String kpiType;

    @Column(name = "name")
    public String name;

    @Column(name = "unit")
    public String unit;

    @Column(name = "value")
    public String value;

    // Utility methods can be added here.
}
