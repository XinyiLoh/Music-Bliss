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

    public boolean delete(T anEntry){
        
        if(head == null){
            
            return false;
            
        }else if (noOfEntries == 1) {
            
            clearList();
            noOfEntries--;
            return true;
            
        } else if (head.data.equals(anEntry)) {
            
            head = head.next;
            noOfEntries--;
            return true;
            
        } else{
            
            Node prevLocation = null;
            Node currLocation = head;
        
            while (currLocation != null && currLocation.data.compareTo(anEntry)<0) {
              prevLocation = currLocation;
              currLocation = currLocation.next;
            }
        
            if(currLocation != null && currLocation.data.equals(anEntry)){
                if(currLocation == head){
                    head = head.next;
                }else{
                    prevLocation.next = currLocation.next;
                }
                noOfEntries--;
                return true;
            }
            
            return false;
        }
    }
    
        
    public boolean update(T anEntry){
        throw new UnsupportedOperationException();
        }
    
    @Override
    public void clearList(){
        head = null;
        noOfEntries = 0;
    }

    public boolean found(T anEntry){
        throw new UnsupportedOperationException();
    }
    

    @Override
    public int totalEntries(){
        return noOfEntries;
        }

    @Override
    public boolean emptyList(){
        return (noOfEntries == 0);
    }
    
    @Override
    public T getEntry(int givenPosition) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        
        String outputStr = "";
        Node currLocation = head;
        while (currLocation != null) {
          outputStr += currLocation.data + "\n";
          currLocation = currLocation.next;
        }
        
        return outputStr;
    }
    
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
