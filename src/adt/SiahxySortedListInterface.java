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
public interface SiahxySortedListInterface<T extends Comparable<T>> {

    public boolean add(T newEntry);

    public T remove(int givenPosition);   
    
    public T getEntry(int givenPosition);

    public int getPosition(T givenPosition);
    
    public boolean replace(int givenPosition, T newEntry);

    public boolean contains(T anEntry);

    public void clear();

    public int getNumberOfSongs();

    public boolean isEmpty();

    public boolean isFull();

    
}
