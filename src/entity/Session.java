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
public class Session {

    private SiahxySortedListInterface<Song> playlist;
    private SiahxySortedListInterface<Singer> version;
    private int sessionRate;

    public Session() {

    }

    public Session(SiahxySortedListInterface<Song> playlist) {
        this.playlist = playlist;
    }

    public Session(SiahxySortedListInterface<Song> playlist, int sessionRate) {
        this.playlist = playlist;
        this.sessionRate = sessionRate;
    }

    public Session(SiahxySortedListInterface<Song> playlist, SiahxySortedListInterface<Singer> version, int sessionRate) {
        this.playlist = playlist;
        this.version = version;
        this.sessionRate = sessionRate;
    }

//    public Session(int sessionID, String sessionName, String sessionSinger) {
//        this.sessionID = sessionID;
//        this.sessionName = sessionName;
//        this.sessionSinger = sessionSinger;
//    }
//
//    public int getSessionID() {
//        return sessionID;
//    }
//
//    public void setSessionID(int sessionID) {
//        this.sessionID = sessionID;
//    }
//
//    public String getSessionName() {
//        return sessionName;
//    }
//
//    public void setSessionName(String sessionName) {
//        this.sessionName = sessionName;
//    }
//
//    public String getSessionSinger() {
//        return sessionSinger;
//    }
//
//    public void setSessionSinger(String sessionSinger) {
//        this.sessionSinger = sessionSinger;
//    }
    public int getSessionRate() {
        return sessionRate;
    }

    public void setSessionRate(int sessionRate) {
        this.sessionRate = sessionRate;
    }

    public SiahxySortedListInterface<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(SiahxySortedListInterface<Song> playlist) {
        this.playlist = playlist;
    }

    public SiahxySortedListInterface<Singer> getVersion() {
        return version;
    }

    public void setVersion(SiahxySortedListInterface<Singer> version) {
        this.version = version;
    }

//    @Override
//    public String toString() {
//        return String.format("%-15d %-23s %-10s\n", sessionID, sessionName, sessionSinger);
//    }
    @Override
    public String toString() {
        return playlist + "\n";
    }
}
