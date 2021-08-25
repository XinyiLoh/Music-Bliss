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
 
public class Song implements Comparable<Song>{
    
    private static int songID = 1;
    private String songName;
    private String singer;

    public Song() {
        
    }

    public Song(String songName, String singer) {
        this.songName = songName;
        this.singer = singer;   

    }

//    public static int getSongID() {
//        return songID;
//    }
//
//    public static void setSongID(int songID) {
//        Song.songID = songID;
//    }

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

    @Override
    public int compareTo(Song other) {
        return this.getSongName().compareTo(other.getSongName());
    }
    
    public boolean equals(Object other){
        if(other instanceof Song){
            Song otherName = (Song)other;
            return(this.songName.equals(otherName.songName) && (this.singer==otherName.singer));
        }
        return false;
    }
    
    public String toString() {
        return songName + " - (" + singer + ")\n\n";
    }

    
    
    
}
