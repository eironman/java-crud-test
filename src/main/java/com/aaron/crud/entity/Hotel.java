package com.aaron.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel {
    @Id
    @GeneratedValue
    private Long id;
    private Integer beds;
    private String name;

    public Hotel() {
        super();
    }

    public Hotel(Long id, Integer beds, String name) {
        super();
        this.id = id;
        this.beds = beds;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBeds() {
        return this.beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}