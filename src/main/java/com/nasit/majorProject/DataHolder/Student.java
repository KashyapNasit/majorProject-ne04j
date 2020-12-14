package com.nasit.majorProject.DataHolder;

import java.util.Date;

public class Student {
    private String regno;
    private String name;
    private String father_name;
    private Date dob;
    private String phone;
    private String mobile;
    private String email;
    private String address;
    private String blood_group;
    private String sex;
    private String state;
    private String category;
    private double cpi;
    private double spi;

    public double getCpi() {
        return cpi;
    }

    public Student setCpi(double cpi) {
        this.cpi = cpi;
        return this;
    }

    public double getSpi() {
        return spi;
    }

    public Student setSpi(double spi) {
        this.spi = spi;
        return this;
    }

    public String getRegno() {
        return regno;
    }

    public Student setRegno(String regno) {
        this.regno = regno;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public String getFather_name() {
        return father_name;
    }

    public Student setFather_name(String father_name) {
        this.father_name = father_name;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public Student setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Student setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Student setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Student setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public Student setBlood_group(String blood_group) {
        this.blood_group = blood_group;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Student setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getState() {
        return state;
    }

    public Student setState(String state) {
        this.state = state;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Student setCategory(String category) {
        this.category = category;
        return this;
    }
}
