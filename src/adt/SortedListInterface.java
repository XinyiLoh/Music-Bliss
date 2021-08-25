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
public interface SortedListInterface<T> {
    //search

    public boolean insert(T newEntry);
    
    public boolean delete(T anEntry);
    
    public boolean update(T anEntry);

    public void clearList();

    public boolean found(T anEntry);

    public int totalEntries();

    public boolean emptyList();
    
    public T getEntry(int givenPosition);

}
