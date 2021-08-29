/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Koh Hui Hui
 */
public interface StackInterface<T> {

    public void push(T newEntry);

    public T pop();

    public T peek();

    public T peekNext();

    public int size();

    public boolean isEmpty();

    public void clear();

    public T getEach(int index);

    public String getAll();

    public boolean find(T anEntry);

    public void duplicate(int index);

}
