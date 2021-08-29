/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
            return (this.songName.equals(otherName.songName));
        }
        return false;
    }

    public String toString() {
        return String.format("%-7d %-18s %-50s\n", songID, songName, singer);
    }

}
