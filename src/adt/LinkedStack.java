/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Koh Hui Hui
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node topNode;
    private int numberEntry;

    public LinkedStack() {
        topNode = null;
        numberEntry = 0;
    }

    @Override
    public void push(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.next = topNode;
        topNode = newNode;
    }

    @Override
    public T pop() {
        T result = peek();
        if (topNode != null) {
            topNode = topNode.next;
        }
        return result;
    }

    @Override
    public T peek() {
        T result = null;
        if (topNode != null) {
            result = topNode.data;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
