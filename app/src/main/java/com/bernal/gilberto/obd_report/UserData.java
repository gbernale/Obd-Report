package com.bernal.gilberto.obd_report;

/**
 * Created by Registered User on 2/27/2017.
 */

public class UserData {
    public   String username;
    public   String useraddress;
    public   String userRole;

    public UserData() {
    }


    public UserData(String username, String useraddress, String userPhone) {
        this.username = username;
        this.useraddress = useraddress;
        this.userRole = userPhone;
    }

    public String getUsername() {
        return username;
    }

    public String getUseraddress(){
        return  useraddress;
    }

    public  String getUserPhone(){
        return userRole;
    }

}
