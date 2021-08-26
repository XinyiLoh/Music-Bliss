/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Loh Xin Yi
 */
public interface SortedListInterface<T extends Comparable<T>> {
    
    public boolean insert(T newEntry);
    
    public boolean found(T anEntry);
    
    public int getPosition(T anEntry);
    
    public T getEntry(int givenPosition);
    
    public boolean delete(T anEntry);

    public void clearList();
    
    public boolean emptyList();

    public int totalEntries();
}
