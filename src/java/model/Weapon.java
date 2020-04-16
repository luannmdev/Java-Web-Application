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
public class Weapon implements Serializable{
    private String weapon_id, weapon_name, description, type, owner;

    public Weapon(String weapon_id, String weapon_name, String description, String type, String owner) {
        this.weapon_id = weapon_id;
        this.weapon_name = weapon_name;
        this.description = description;
        this.type = type;
        this.owner = owner;
    }

    public String getWeapon_id() {
        return weapon_id;
    }

    public void setWeapon_id(String weapon_id) {
        this.weapon_id = weapon_id;
    }

    public String getWeapon_name() {
        return weapon_name;
    }

    public void setWeapon_name(String weapon_name) {
        this.weapon_name = weapon_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
    
}
