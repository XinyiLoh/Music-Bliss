/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.SiahxySortedArrayList;
import adt.SiahxySortedListInterface;
import java.util.Objects;

/**
 *
 * @author Siah Xin Ying
 */
public class Song implements Comparable<Song> {

    private static int id = 1000;
    private int songID;
    private String songName;
    private SiahxySortedListInterface<Singer> Singer = new SiahxySortedArrayList();

    public Song() {
    }

    public Song(int songID) {
        this.songID = songID;
    }

    public Song(int songID, String songName) {
        this.songID = songID;
        this.songName = songName;
    }

    public Song(String songName, SiahxySortedListInterface<Singer> singer) {
        this.songName = songName;
        this.songID = id;
        id++;
        this.Singer = singer;
    }

    @Override
    public int compareTo(Song other) {
        return (songName.compareTo(other.songName));

    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Song.id = id;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public void addSinger(Singer s) {
        Singer.add(s);
    }

    public SiahxySortedListInterface<Singer> getSinger() {
        return Singer;
    }

    public void setSinger(SiahxySortedListInterface<Singer> Singer) {
        this.Singer = Singer;
    }

    public boolean equals(Object other) {
        if (other instanceof Song) {
            Song otherName = (Song) other;
            return (this.songName.equals(otherName.songName));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.songName);
        return hash;
    }

    public String toString() {
        return String.format("  %-7d %-18s", songID, songName) + Singer + "\n";
    }

}
