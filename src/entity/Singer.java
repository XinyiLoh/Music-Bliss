/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author USER
 */
public class Singer implements Comparable<Singer>{
    
    String singer;

    public Singer() {
    }

    public Singer(String singer) {
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.singer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Singer other = (Singer) obj;
        if (!Objects.equals(this.singer, other.singer)) {
            return false;
        }
        return true;
    }
    
    public String toString(){
        return  "("+singer + ")  ";
    }
    
    @Override
    public int compareTo(Singer o) {
         return (singer.compareTo(o.singer));
    }
}
