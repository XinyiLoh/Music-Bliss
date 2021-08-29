/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Koh Hui Hui
 */
public class Session {

    private int sessionID;
    private String sessionName;
    private String sessionSinger;
    private int sessionRate;
    private int streamTimes = 0;

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

    public int getStreamTimes() {
        return streamTimes;
    }

    public void setStreamTimes() {
        this.streamTimes++;
    }

    @Override
    public String toString() {
        return String.format("%-15d %-23s %-10s %-10d %-10d\n", sessionID, sessionName, sessionSinger, sessionRate, streamTimes);
    }
}
