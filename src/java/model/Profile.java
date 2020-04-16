/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author LuanNMSE62431
 */
public class Profile implements Serializable{

    private String userName;
    private String fullName;
    private String phone;
    private String sex;
    private String birthday;
    private String password;
    private String role;
    private String picture;
    private String robot_id;
    private boolean status;
    private boolean free;

    public Profile(String userName, String fullName, String phone, String sex, String birthday, String password, String role, String picture, String robot_id, boolean status, boolean free) {
        this.userName = userName;
        this.fullName = fullName;
        this.phone = phone;
        this.sex = sex;
        this.birthday = birthday;
        this.password = password;
        this.role = role;
        this.picture = picture;
        this.robot_id = robot_id;
        this.status = status;
        this.free = free;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRobot_id() {
        return robot_id;
    }

    public void setRobot_id(String robot_id) {
        this.robot_id = robot_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
    
    
    
}
