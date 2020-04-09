package com.example.sudhir_project_phase;

public class Person {
    private  String imageURL;
    private String id;
    private String email;
    private String phone;
    private String  gender;
    private String password;
    private String username;

    public Person( String email, String phone, String gender, String password, String username,String imageURL) {
     //  this.id = id;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.username = username;
        this.imageURL=imageURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




}
