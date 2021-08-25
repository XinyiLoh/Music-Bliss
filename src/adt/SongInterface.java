/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Siah Xin Ying
 */
public interface SongInterface<T extends Comparable<T>> {

    public boolean add(T newEntry);

//    public boolean remove(T song);
    
//    public int getPosition(T song);
    
    public T getPosition(int givenPosition);
            
    public int find(T givenPosition);
    
    public boolean contains(T anEntry);
    
    public T remove(int givenPosition);
    
    public boolean replace(int givenPosition, T newEntry);

    public void clear();

    public int getNumberOfSongs();

    public boolean isEmpty();

    public boolean isFull();

    
 
}

