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

    private int sessionID;
    private String sessionName;
    private String sessionSinger;
    private SiahxySortedListInterface<Song> playlist;
    private int sessionRate;

    public Session() {

    }

    public Session(int sessionID, String sessionName, String sessionSinger) {
        this.sessionID = sessionID;
        this.sessionName = sessionName;
        this.sessionSinger = sessionSinger;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionSinger() {
        return sessionSinger;
    }

    public void setSessionSinger(String sessionSinger) {
        this.sessionSinger = sessionSinger;
    }

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

    @Override
    public String toString() {
        return String.format("%-15d %-23s %-10s\n", sessionID, sessionName, sessionSinger);
    }
}
