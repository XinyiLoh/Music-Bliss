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
    
    @Override
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

    @Override
    public boolean found(T anEntry){
        
        boolean search = false;
        Node currLocation = head;
        
        while (currLocation != null && (anEntry.compareTo(currLocation.data) > 0 || anEntry.compareTo(currLocation.data) < 0)) {
            currLocation = currLocation.next;
        }

        if (currLocation != null && anEntry.compareTo(currLocation.data) == 0) {
            search = true;
        }

        return search;
    }
    
    @Override
    public int getPosition(T anEntry){
        Node currLocation = head;
        int position = 1;

        if (emptyList()) {
            position = 0;
            
        } else if (noOfEntries == 1) {
            return position;
        }

        while (currLocation != null && (anEntry.compareTo(currLocation.data) > 0 || anEntry.compareTo(currLocation.data) < 0)) {
            currLocation = currLocation.next;
            position++;
        }

        return position;
    }
    
    @Override
    public T getEntry(int givenPosition) {
        
        T entry = null;

        if (!(emptyList())) {
            if ((givenPosition >= 1) && (givenPosition <= noOfEntries)) {
                
                Node currLocation = head;
                
                if(givenPosition == 1){
                    entry = currLocation.data;
                    
                }else{
                    for (int i = 0; i < givenPosition - 1; i++) {
                        currLocation = currLocation.next;
                    }
                    entry = currLocation.data;
                }
            }
        }

        return entry;
    }

    @Override
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
        
            while (currLocation != null && anEntry.compareTo(currLocation.data) != 0) {
              prevLocation = currLocation;
              currLocation = currLocation.next;
            }
        
            if(currLocation != null && anEntry.compareTo(currLocation.data) == 0){
                if(currLocation == head){
                    head = head.next;
                }else if(getPosition(anEntry) == noOfEntries){
                    prevLocation.next = null;
                }else{
                    prevLocation.next = currLocation.next;
                }
                noOfEntries--;
                return true;
            }
            return false;
        }
    }
        
    @Override
    public void clearList(){
        head = null;
        noOfEntries = 0;
    }
    
    @Override
    public boolean emptyList(){
        return (noOfEntries == 0);
    }

    @Override
    public int totalEntries(){
        return noOfEntries;
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
