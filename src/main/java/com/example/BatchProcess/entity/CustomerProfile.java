package com.example.BatchProcess.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "MG_CUSTOMERS")
@Table(name = "MG_CUSTOMERS", schema = "batchdb")
public class CustomerProfile {

    @Id
    private String userId;
    private String title;
    private String professional;
    private String age;

    public CustomerProfile(String userId, String title, String professional, String age) {
        this.userId = userId;
        this.title = title;
        this.professional = professional;
        age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        age = age;
    }
}
