/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Siah Xin Ying
 */
public class Song implements Comparable<Song> {

    private static int id = 1000;
    private int songID;
    private String songName;
    private String singer;

    public Song() {
    }

    public Song(int songID) {
        this.songID = songID;
    }

    public Song(String songName, String singer) {
        this.songName = songName;
        this.singer = singer;
        this.songID = id;
        id++;
    }

    public int compareTo(Song other) {
        return (songName.compareTo(other.songName));
    }

//    public int compareTo(Song s) {
//        return (int) (this.songID - s.songID);
//    }
    
    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public boolean equals(Object other) {
        if (other instanceof Song) {
            Song otherName = (Song) other;
            return (this.songName.equals(otherName.songName) && (this.singer == otherName.singer));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.songName);
        hash = 37 * hash + Objects.hashCode(this.singer);
        return hash;
    }

    public String toString() {
        return String.format("%-7d %-24s %-90s\n", songID, songName, singer);
//        return  songName + " - (" + singer + ")\n\n";
    }

}
