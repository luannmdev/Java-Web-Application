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
public class MissionDetail implements Serializable{

    private Mission myMission;
    private Robot myRobot;
    private Weapon myWeapon;

    public MissionDetail(Mission myMission, Robot myRobot, Weapon myWeapon) {
        this.myMission = myMission;
        this.myRobot = myRobot;
        this.myWeapon = myWeapon;
    }

    public Mission getMyMission() {
        return myMission;
    }

    public void setMyMission(Mission myMission) {
        this.myMission = myMission;
    }

    public Robot getMyRobot() {
        return myRobot;
    }

    public void setMyRobot(Robot myRobot) {
        this.myRobot = myRobot;
    }

    public Weapon getMyWeapon() {
        return myWeapon;
    }

    public void setMyWeapon(Weapon myWeapon) {
        this.myWeapon = myWeapon;
    }
    
    
}
