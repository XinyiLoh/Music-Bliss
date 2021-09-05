/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.SiahxySortedListInterface;
import adt.StackInterface;

/**
 *
 * @author Koh Hui Hui
 */
public class Session {

    private SiahxySortedListInterface<Song> playlist;
    private SiahxySortedListInterface<Singer> version;
    private StackInterface<Rank> ranklist;

    public Session() {

    }

    public Session(SiahxySortedListInterface<Song> playlist) {
        this.playlist = playlist;
    }

    public Session(SiahxySortedListInterface<Song> playlist, int sessionRate) {
        this.playlist = playlist;
    }

    public Session(SiahxySortedListInterface<Song> playlist, SiahxySortedListInterface<Singer> version, int sessionRate) {
        this.playlist = playlist;
        this.version = version;
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

    @Override
    public String toString() {
        return playlist + "\n" + ranklist + "\n";
    }
}
