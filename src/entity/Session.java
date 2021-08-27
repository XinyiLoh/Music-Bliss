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

    private Song playlist;

    public Session(Song playlist) {
        this.playlist = playlist;
    }

    public Song getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Song playlist) {
        this.playlist = playlist;
    }

    @Override
    public String toString() {
        return playlist.toString();
    }
}
