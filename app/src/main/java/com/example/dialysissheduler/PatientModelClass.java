package com.example.dialysissheduler;

public class PatientModelClass {


    Integer id;
    String Patient_id;
    String Creatine_level;
    String Gfr;
    String Urea;
    String Pottasium;
    String Sodium;

    public PatientModelClass(String Patient_id, String Creatine_level,String Gfr,String Urea,String Pottasium,String Sodium) {
        this.Patient_id = Patient_id;
        this.Creatine_level = Creatine_level;
        this.Gfr = Gfr;
        this.Urea = Urea;
        this.Pottasium = Pottasium;
        this.Sodium= Sodium;
    }

    public PatientModelClass(Integer id, String Patient_id, String Creatine_level,String Gfr,String Urea,String Pottasium,String Sodium) {
        this.id = id;
        this.Patient_id= Patient_id;
        this.Creatine_level = Creatine_level;
        this.Gfr = Gfr;
        this.Urea = Urea;
        this.Pottasium = Pottasium;
        this.Sodium= Sodium;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatient_id() {
        return Patient_id;
    }

    public void setPatient_id(String Patient_id) {
        this.Patient_id = Patient_id;
    }

    public String getCreatine_level() {
        return Creatine_level;
    }

    public void setCreatine_level(String Creatine_level){
        this.Creatine_level = Creatine_level;
    }

    public String getGfr() {
        return Gfr;
    }

    public void setGfr(String Gfr) {
        this.Gfr = Gfr;
    }
    public String getUrea() {
        return Urea;
    }

    public void setUrea(String Urea) {
        this.Urea = Urea;
    }
    public String getPottasium() {
        return Pottasium;
    }

    public void setPottasium(String Pottasium) {
        this.Pottasium = Pottasium;
    }


    public String getSodium() {
        return Sodium;
    }

    public void setSodium(String Sodium) {
        this.Sodium = Sodium;
    }








}
