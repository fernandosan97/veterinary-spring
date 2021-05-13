package com.veterinary.veterinary.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class InvoiceModel {
    @Id
    @Column(name = "idinvoice")
    private Integer id;

    @Column(name = "idappointment")
    private Integer idAppointment;

    private Double total;

    private String status;

    @Column(name = "created_at")
    private String createdAt;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setIdAppointment(Integer idAppointment) {
        this.idAppointment = idAppointment;
    }

    public Integer getIdAppointment() {
        return this.idAppointment;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
}
