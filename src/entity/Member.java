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
public class Member implements Comparable<Member>{
    private int iD;
    private String firstName;
    private String lastName;
    private String mobile;
    private String gender;
    private String joinDate;
    private int rewardPoints;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    
    public Member(){
        
    }
    
    public Member(int iD){
        this.iD = iD;
    }

    public Member(int iD, String firstName, String lastName, String mobile, String gender, int rewardPoints) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.gender = gender;
        this.rewardPoints = rewardPoints;
        this.joinDate = sdf.format(cal.getTime());
    }
    
    @Override
    public int compareTo(Member m){
        
        return (int) (this.iD - m.iD);
        //return (int) (this.rewardPoints - m.rewardPoints);
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
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

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = sdf.format(cal.getTime());
    }
    
    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String toString() {
        return iD + " " + firstName + " " + lastName + " " + mobile + " " + gender + " " + joinDate + " " + rewardPoints;
    }

}
