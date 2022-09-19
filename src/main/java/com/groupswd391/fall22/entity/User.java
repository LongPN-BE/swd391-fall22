package com.groupswd391.fall22.entity;

import javax.persistence.*;
import java.sql.Date;



@Entity
@Table(name = "tbl_major")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String role_ID;
    String major_ID;
    String firstname;
    String lastname;
    String email;
    String phone;
    Date dob;
    Integer legit;
    boolean status;
    String img;

    public User() {
    }

    public User(String id, String role_ID, String major_ID,
                String firstname, String lastname,
                String email, String phone, Date dob,
                Integer legit, boolean status, String img) {
        this.id = id;
        this.role_ID = role_ID;
        this.major_ID = major_ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.legit = legit;
        this.status = status;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole_ID() {
        return role_ID;
    }

    public void setRole_ID(String role_ID) {
        this.role_ID = role_ID;
    }

    public String getMajor_ID() {
        return major_ID;
    }

    public void setMajor_ID(String major_ID) {
        this.major_ID = major_ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getLegit() {
        return legit;
    }

    public void setLegit(Integer legit) {
        this.legit = legit;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
