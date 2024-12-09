package com.kpi.resource.model;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ApplicationSettings extends PanacheEntity {
    
    @Column(nullable = false)
    public String instanceId;

    @Column(nullable = false)
    public String settingName;

    @Column(nullable = false)
    public String value;

    public String settingType;

    public String description;
}

