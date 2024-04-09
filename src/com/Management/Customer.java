package com.Management;

/**
 * ClassName:Customer
 * Package: com.Management
 * Description:
 *
 * @Author Joan Jia
 * @Create 2024/3/29 14:11
 * @Version 1.0
 */
public class Customer {
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    public Customer(){

    }
    public Customer(String n,char g,int age,String p,String email) {
        this.name=n;
        this.gender=g;
        this.age=age;
        this.phone=p;
        this.email=email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
