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

    public void push(T newElement);

    public T pop();

    public T peek();

    public int size();

    public T getEach(int index);

    public boolean isEmpty();

    public void clear();

    public String getAll();
}
