/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Loh Xin Yi
 */
public class Member {
    private static int iD = 1000;
    private String firstName;
    private String lastName;
    private String mobile;
    private String gender;
    private Calendar joinDate;

    public Member(String firstName, String lastName, String mobile, String gender, Calendar joinDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.gender = gender;
        this.joinDate = joinDate;
    }

    public static int getiD() {
        return iD;
    }

    public static void setiD(int iD) {
        Member.iD = iD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static String getJoinDate(Calendar date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        return sdf.format(date.getTime());
    }

    public void setJoinDate(Calendar joinDate) {
        this.joinDate = joinDate;
    }
    
    
}
