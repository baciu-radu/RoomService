package com.ps.bk.hotel.room.utils;

public class StringUtils {
    public static boolean isNumber(String number){
        try{
            Integer.parseInt(number);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean isNullOrEmpty(String roomNumber) {
        if (roomNumber==null || roomNumber.isEmpty()){
            return true;
        }else return false;
    }
}
