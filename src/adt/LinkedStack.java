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
public class LinkedStack<T> implements StackInterface<T> {

    private Node topNode;
    private int entryCount;

    public LinkedStack() {
        topNode = null;
        entryCount = 0;
    }

    @Override
    public void push(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.setNextNode(topNode);
        topNode = newNode;
        entryCount++;
    }

    @Override
    public T pop() {
        T result = peek();
        if (!(isEmpty())) {
            topNode = topNode.getNextNode();
        }
        entryCount--;
        return result;
    }

    @Override
    public T peek() {
        T result = null;
        if (!(isEmpty())) {
            result = topNode.getData();
        }
        return result;
    }

    @Override
    public T peekNext() {
        T result = null;
        if (!(isEmpty())) {
            result = topNode.getNextNode().getData();
        }
        return result;
    }

    @Override
    public int size() {
        return entryCount;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
        entryCount = 0;
    }

    @Override
    public T getEach(int index) {

        T each = null;
        Node currentNode = topNode;

        if (!(isEmpty())) {
            if (index == 1) {
                each = currentNode.getData();
            }
            if (index > 1 && index <= entryCount) {
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.getNextNode();
                }
                each = currentNode.getData();
            }
        }
        return each;
    }

    @Override
    public String getAll() {
        String list = "";
        Node currentNode = topNode;

        while (!(isEmpty())) {
            list += "\n" + currentNode.getData();
            currentNode = currentNode.getNextNode();
        }

        return list;
    }

    @Override
    public boolean find(T anEntry) {
        boolean found = false;
        Node currentNode = topNode;

        while (!found && !(isEmpty())) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }

        return found;
    }

    @Override
    public void duplicate(int index) {
        Node newNode = new Node(getEach(index));
        newNode.setNextNode(topNode);
        topNode = newNode;
        entryCount++;
    }

    private class Node {

        private T data;
        private Node nextNode;

        private Node(T data) {
            this.data = data;
            this.nextNode = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.nextNode = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node next) {
            this.nextNode = next;
        }
    }
}
