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
    private int size;

    public LinkedStack() {
        topNode = null;
        size = 0;
    }

    @Override
    public void push(T newElement) {
        Node newNode = new Node(newElement);
        newNode.next = topNode;
        topNode = newNode;
        size++;
    }

    @Override
    public T pop() {
        T result = peek();
        if (topNode != null) {
            topNode = topNode.next;
        }
        size--;
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
    public T peekNext() {
        T result = null;
        if (topNode != null) {
            result = topNode.next.data;
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getEach(int index) {

        T each = null;
        Node curNode = topNode;

        if (curNode != null) {
            if (index == 1) {
                each = curNode.data;
            }
            if (index > 1 && index <= size) {
                for (int i = 0; i < index - 1; i++) {
                    curNode = curNode.next;
                }
                each = curNode.data;
            }
        }
        return each;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }

    @Override
    public String getAll() {
        String list = "";
        Node currentNode = topNode;

        while (currentNode != null) {
            list += "\n" + currentNode.data;
            currentNode = currentNode.next;
        }

        return list;
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
