/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.SiahxySortedListInterface;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Loh Xin Yi
 */
public class Member implements Comparable<Member> {

    private int iD;
    private String firstName;
    private String lastName;
    private String mobile;
    private String gender;
    private String joinDate;
    private int rewardPoints;
    private int totalRewardPoints = 0;
    private String membership;
    private SiahxySortedListInterface<Song> favouriteSongList;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

    public Member() {

    }

    public Member(int iD) {
        this.iD = iD;
    }

    public Member(String mobile) {
        this.mobile = mobile;
    }

    public Member(int iD, String firstName, String lastName, String mobile, String gender, int rewardPoints) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.gender = gender;
        this.rewardPoints = rewardPoints;
        this.totalRewardPoints += rewardPoints;
        this.joinDate = sdf.format(cal.getTime());
        if (totalRewardPoints <= 100) {
            this.membership = "Basic";
        } else if (totalRewardPoints > 100 && totalRewardPoints <= 300) {
            this.membership = "Bronze";
        } else if (totalRewardPoints > 300 && totalRewardPoints <= 500) {
            this.membership = "Silver";
        } else if (totalRewardPoints > 500) {
            this.membership = "Gold";
        }
    }

    @Override
    public int compareTo(Member m) {
        return (int) (this.iD - m.iD);
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

    public void addRewardPoints(int addRewardPoints) {

        this.rewardPoints = rewardPoints + addRewardPoints;
        this.totalRewardPoints += addRewardPoints;

    }

    public boolean minusRewardPoints(int minusRewardPoints) {

        if (rewardPoints <= 0 || rewardPoints < minusRewardPoints) {
            return false;
        } else {
            this.rewardPoints = rewardPoints - minusRewardPoints;
            return true;
        }
    }

    public int getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership() {

        if (this.totalRewardPoints <= 100) {
            this.membership = "Basic";
        } else if (this.totalRewardPoints > 100 && totalRewardPoints <= 300) {
            this.membership = "Bronze";
        } else if (this.totalRewardPoints > 300 && totalRewardPoints <= 500) {
            this.membership = "Silver";
        } else if (this.totalRewardPoints > 500) {
            this.membership = "Gold";
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        if (!Objects.equals(this.mobile, other.mobile)) {
            return false;
        }
        return true;
    }

    public void setFavouriteSongList(SiahxySortedListInterface<Song> favouriteSongList) {
        this.favouriteSongList = favouriteSongList;
    }

    public SiahxySortedListInterface<Song> getFavouriteSongList() {
        return favouriteSongList;
    }

    @Override
    public String toString() {

        return String.format("%7d %12s %12s %15s %10s %25s %15d %13s", iD, firstName, lastName, mobile, gender, joinDate, rewardPoints, membership);
    }

}
