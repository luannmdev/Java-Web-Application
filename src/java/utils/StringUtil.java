/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author LuanNMSE62431
 */
public class StringUtil {

    public static String getString(String value) {
        return value == null ? "" : value;
    }

    public static int getInt(String value) {
        int newValue = -1;
        try {
            newValue = Integer.parseInt(value);   
        } catch (Exception e) {
        }
        return newValue;
    }
public static double getDouble(String value) {
        double newValue = -1;
        try {
            newValue = Double.parseDouble(value);   
        } catch (Exception e) {
        }
        return newValue;
    }
    public static String getString(Object value) {
        return value == null ? "" : String.valueOf(value);
    }
}
