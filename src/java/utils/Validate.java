/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author LuanNMSE62431
 */
public class Validate {

    public static boolean checkName(String name) {
        // accept unicode, whihespace, min 3 max 50;
        return name.matches("[\\p{L}\\s]{3,50}");
    }

    public static boolean checkString(String st) {
        // accept unicode, whihespace, min 3 max 50;
        if ((st != "") && (st != null)) {
            return true;
        }
        return false;
    }

    public static boolean checkUserName(String userName) {
        return userName.matches("[\\p{L}\\s\\d]{3,50}");
    }

    public static boolean checkMobile(String mobile) {
        return mobile.matches("\\d{9,11}");
    }

    public static boolean checkEmail(String email) {
        return email.matches("\\w+@\\w+[.]\\w+");
    }
//    public static boolean checkEmailOrPhone(String emailOrPhone) {
//        if (!emailOrPhone.matches("\\w+@\\w+[.]\\w+")) {
//            if (!emailOrPhone.matches("\\d{9,11}")) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean checkPassword(String password) {
        return password.matches("\\w{4,20}");
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
