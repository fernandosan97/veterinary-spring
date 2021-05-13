package com.veterinary.veterinary.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class AppointmentModel {
    @Id
    @Column(name = "idappointment")
    private Integer id;

    @Column(name = "idpet")
    private Integer idPet;

    private String motive;

    private String date;

    @Column(name = "created_at")
    private String createdAt;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public Integer getIdPet() {
        return this.idPet;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getMotive() {
        return this.motive;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
}
