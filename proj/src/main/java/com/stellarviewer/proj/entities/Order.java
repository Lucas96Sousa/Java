package com.stellarviewer.proj.entities;

import java.io.Serializable;
import java.time.Instant;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name ="tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private User client;

    public Order(){}


    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return this.moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Order)) return false;
        if (!super.equals(object)) return false;
        Order order = (Order) object;
        return java.util.Objects.equals(getId(), order.getId());
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getId());
    }

    
}
