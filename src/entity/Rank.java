/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.SiahxySortedListInterface;

/**
 *
 * @author Koh Hui Hui
 */
public class Rank {

    private SiahxySortedListInterface<Song> ratedSong;
    private String starRate;

    public Rank(SiahxySortedListInterface<Song> ratedSong, String starRate) {
        this.ratedSong = ratedSong;
        this.starRate = starRate;
    }

    public SiahxySortedListInterface<Song> getRatedSong() {
        return ratedSong;
    }

    public void setRatedSong(SiahxySortedListInterface<Song> ratedSong) {
        this.ratedSong = ratedSong;
    }

    public String getStarRate() {
        return starRate;
    }

    public void setStarRate(String starRate) {
        this.starRate = starRate;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
