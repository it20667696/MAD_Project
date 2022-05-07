package com.example.mad_project;

public class PatientReg {

    Integer id1;
    String mobile;

    public PatientReg(String mobile) {
        this.mobile = mobile;
    }

    public PatientReg(Integer id, String mobile) {
        this.id1 = id;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id1;
    }

    public void setId(Integer id) {
        this.id1 = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
