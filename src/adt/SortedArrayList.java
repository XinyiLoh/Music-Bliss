/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.io.Serializable;

/**
 *
 * @author Siah Xin Ying
 *
 *
 */
public class SortedArrayList<T extends Comparable<T>> implements SongInterface<T>, Serializable {

    private T[] songArray;
    private int numberOfSongs;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int FACTOR = 2;
    private static final int DEFAULT_ERROR_CODE = -1;

    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayList(int initialCapacity) {
        numberOfSongs = 0;
        songArray = (T[]) new Comparable[initialCapacity];
    }

    public boolean add(T newEntry) {
        if (isEmpty()) {
            songArray[numberOfSongs] = newEntry;
            numberOfSongs++;
            return true;
        } else {
            int i = 0;
            while (i < numberOfSongs && songArray[i].compareTo(newEntry) > 0) {
                i++;
            }
            if (isArrayFull()) {
                doubleArray();
            }
            makeRoom(i + 1);
            songArray[i] = newEntry;
            numberOfSongs++;
            return true;
        }
    }

//    public boolean remove(T anEntry) {
//        if (!isEmpty()) {
//            return false;
//        } else {
//            int i = 0;
//            while (i < numberOfSongs && songArray[i].compareTo(anEntry) < 0) {
//                i++;
//            }
//            if (songArray[i].equals(anEntry)) {
//                removeGap(i + 1);
//                numberOfSongs--;
//                return true;
//            }
//            return false;
//        }
//    }
    public void clear() {
        numberOfSongs = 0;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        for (int i = 0; !found && (i < numberOfSongs); i++) {
            if (anEntry.equals(songArray[i])) {
                found = true;
            }
        }

        return found;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    private boolean isArrayFull() {
        return numberOfSongs == songArray.length;
    }

//    private void doubleArray() {
//        T[] oldList = songArray;
//        int oldSize = oldList.length;
//
//        songArray = (T[]) new Object[FACTOR * oldSize];
//
//        for (int i = 0; i < oldSize; i++) {
//            songArray[i] = oldList[i];
//        }
//    }
    private void doubleArray() {
        int arrayLength = songArray.length;

        T[] tempArray = (T[]) new Object[FACTOR * arrayLength];
        for (int i = 0; i < numberOfSongs; i++) {
            tempArray[i] = songArray[i];
        }

        songArray = tempArray;
    }

    public boolean isEmpty() {
        return numberOfSongs == 0;
    }

    public boolean isFull() {
        return false;
    }

    public String toString() {
//        String outputStr = "";
//        for (int i = 0; i < numberOfSongs; ++i) {
//            outputStr += songArray[i] + "\n";
//        }
//
//        return outputStr;
        String outputStr = "";
        for (int position = 1; position <= getNumberOfSongs(); ++position) {
            outputStr += position + ". " + getPosition(position);
        }
        return outputStr;
    }

    public T getPosition(int givenPosition) {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfSongs)) {
            result = songArray[givenPosition - 1];
        }

        return result;
    }

    public int find(T givenPosition) {
        int result = DEFAULT_ERROR_CODE;
        for (int i = 0; i < numberOfSongs; i++) {
            if (songArray[i].equals(givenPosition)) {
                result = i;
            }
        }
        return result;
    }

    public T remove(int givenPosition) {
        try {
            if (givenPosition < 0 || givenPosition > numberOfSongs) {
                throw new IndexOutOfBoundsException("Invalid Input.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        T result = songArray[givenPosition];
        for (int i = givenPosition; i < numberOfSongs; i++) {
            songArray[i - 1] = songArray[i];
        }
        songArray[numberOfSongs] = null;
        numberOfSongs--;
        return result;
    }

    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfSongs)) {
            int i = 0;
            while (i < numberOfSongs && songArray[i].compareTo(newEntry) > 0) {
                i++;
            }
            songArray[givenPosition - 1] = newEntry;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfSongs - 1;

        for (int i = lastIndex; i >= newIndex; i--) {
            songArray[i + 1] = songArray[i];
        }
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfSongs - 1;

        for (int i = removedIndex; i < lastIndex; i++) {
            songArray[i] = songArray[i + 1];
        }
    }

}
