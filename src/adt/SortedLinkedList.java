/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import adt.SortedListInterface;

/**
 *
 * @author Loh Xin Yi
 */
public class SortedLinkedList<T extends Comparable<T>> implements SortedListInterface<T>  {
    
    private Node head;
    private int noOfEntries;

    public SortedLinkedList() {
        head = null;
        noOfEntries = 0;
    }
    
    public boolean insert(T newEntry){
       
        head = insert(newEntry,head);
        noOfEntries++;
        return true;
    }
    
    private Node insert(T newEntry, Node currLocation) {
        
        if ((currLocation == null) || newEntry.compareTo(currLocation.data) < 0) {
            currLocation = new Node(newEntry, currLocation);
        } else {
            Node nodeAfter = insert(newEntry, currLocation.next);
            currLocation.next = nodeAfter;

        }
        return currLocation;
    }
    
    public boolean update(T anEntry){
        throw new UnsupportedOperationException();
        }

    public boolean delete(T anEntry){
        throw new UnsupportedOperationException();
        }

    public boolean found(T anEntry){
        throw new UnsupportedOperationException();
        }

    public int totalEntries(){
        return noOfEntries;
        }

    public boolean emptyList(){
        return (noOfEntries == 0);
    }
    
    public String toString() {
        
        String outputStr = "";
        Node currLocation = head;
        while (currLocation != null) {
          outputStr += currLocation.data + "\n";
          currLocation = currLocation.next;
        }
        
        return outputStr;
    }
//    
//     public T getEntry(int givenPosition) {
//        T result = null;
//
//        if (!(isEmpty())) {
//            if ((givenPosition >= 1) && (givenPosition <= length)) {
//                Node currentNode = firstNode;
//                for (int i = 0; i < givenPosition - 1; i++) {
//                    currentNode = currentNode.next;
//                }
//                result = currentNode.data;
//            }
//        }
//
//        return result;
//
//    }

    private class Node {

        private T data;
        private Node next;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}
