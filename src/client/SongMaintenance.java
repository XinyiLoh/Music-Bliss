/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.SiahxySortedArrayList;
import adt.SiahxySortedListInterface;
import entity.Song;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Siah Xin Ying
 */
public class SongMaintenance {

    public static void main(String[] args) {

        SiahxySortedListInterface<Song> songList = new SiahxySortedArrayList<Song>();
        Scanner scan = new Scanner(System.in);
        int selection = 0;
        char decision;
        char option = 0;

        songList.add(new Song("STAY", "THE KID LAROI"));
        songList.add(new Song("GONE", "ROSIE"));
        songList.add(new Song("MOOD", "24KGOLDIN"));
        songList.add(new Song("NUNU NANA", "JESSI"));
        songList.add(new Song("REALLY REALLY", "WINNER"));
        songList.add(new Song("BE KIND", "MARSHMELLO & HALSEY"));
        songList.add(new Song("GET YOU THE MOON", "KINA"));
        songList.add(new Song("THE OCEAN", "SHY MARTIN & MIKE PERRY"));
        songList.add(new Song("NO ONE", "LEE HI & B.I"));
        songList.add(new Song("A THOUSAND YEARS", "CHRISTINA PERRI"));
        songList.add(new Song("OFFICIALLY MISSING YOU", "TAMIA"));

        do {
            do {
                System.out.println("1. Song List ");
                System.out.println("2. Add Song ");
                System.out.println("3. Update Song ");
                System.out.println("4. Remove Song ");
                System.out.println("5. Search");
                System.out.print("Enter choice: ");

                try {
                    selection = scan.nextInt();

                    if (selection < 1 || selection > 5) {
                        System.err.println("\nInvalid choice, please try again");
                    }
                } catch (InputMismatchException a) {
                    System.err.println("Must enter a number");
                    scan.next();
                }
            } while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5);

            switch (selection) {
                case 1: {

                    System.out.println("\nSong List: " + songList.getNumberOfSongs());
                    System.out.println("------------------------------------------------------");
                    System.out.println("NO.  ID     Song            Singer ");
                    System.out.println("------------------------------------------------------");
                    System.out.print(songList);
                    System.out.println("------------------------------------------------------");

                    System.out.print("Back? [y/n]: ");
                    option = scan.next().charAt(0);

                    break;
                }

                case 2: {
                    do {
                        Song addSong = new Song();
                        String addSongName;
                        String addSinger;
                        scan.nextLine();

                        System.out.println("\n\nAdd New Song");
                        System.out.println("-----------------");
                        System.out.print("Enter Song: ");
                        addSongName = scan.nextLine().toUpperCase();

                        System.out.print("Enter Singer: ");
                        addSinger = scan.nextLine().toUpperCase();

                        addSong.setSongName(addSongName);
                        addSong.setSinger(addSinger);
                        songList.add(new Song(addSongName, addSinger));

                        System.out.print("Do you wanna add more? [y/n]: ");
                        decision = scan.next().charAt(0);
                        scan.nextLine();
                    } while (decision != 'n' && decision != 'N');

                    System.out.print("\nBack? [y/n]: ");
                    option = scan.next().charAt(0);
                    break;
                }
                case 3: {

                    scan.nextLine();
                    Song updateSong = new Song();
                    String songName;

                    System.out.println("\n\nUpdate Song");
                    System.out.println("-----------------");
                    System.out.print("Enter Song: ");
                    songName = scan.nextLine().toUpperCase();

                    updateSong.setSongName(songName);

                    if (songList.contains(updateSong)) {

                        updateSong = songList.getEntry(songList.getPosition(updateSong));
                        int updateSelection;

                        System.out.println(updateSong);

                        do {
                            int currID = 0;
                            String currSongName = "";
                            String currSinger = "";
                            String replaceName;
                            String replaceSinger;
                            System.out.println("1. Update Song");
                            System.out.println("2. Update Singer");
                            System.out.println("3. Update Both");
                            System.out.print("Enter selection: ");
                            updateSelection = scan.nextInt();
                            scan.nextLine();

                            switch (updateSelection) {
                                case 1:
                                    System.out.print("Enter Song name: ");
                                    replaceName = scan.nextLine().toUpperCase();
                                    updateSong.setSongName(replaceName);

                                    currID = updateSong.getSongID();
                                    updateSong.setSongID(currID);
                                    currSinger = updateSong.getSinger();
                                    updateSong.setSinger(currSinger);
                                    songList.replace(songList.getPosition(updateSong), updateSong);
                                    break;

                                case 2:
                                    System.out.print("Enter Singer: ");
                                    replaceSinger = scan.nextLine().toUpperCase();
                                    updateSong.setSinger(replaceSinger);

                                    currID = updateSong.getSongID();
                                    updateSong.setSongID(currID);
                                    currSongName = updateSong.getSongName();
                                    updateSong.setSongName(currSongName);
                                    songList.replace(songList.getPosition(updateSong), updateSong);
                                    break;

                                case 3:
                                    System.out.print("Enter Song name: ");
                                    replaceName = scan.nextLine().toUpperCase();
                                    updateSong.setSongName(replaceName);

                                    System.out.print("Enter Singer: ");
                                    replaceSinger = scan.nextLine().toUpperCase();
                                    updateSong.setSinger(replaceSinger);

                                    currID = updateSong.getSongID();
                                    updateSong.setSongID(currID);
                                    songList.replace(songList.getPosition(updateSong), updateSong);
                                    break;
                            }
                            System.out.print("\nDo you wanna replace more? [y/n]: ");
                            decision = scan.next().charAt(0);
                            scan.nextLine();

                        } while (decision != 'n' && decision != 'N');

                    } else {
                        System.out.print("\nError ");
                    }

                    System.out.print("\nBack? [y/n]: ");
                    option = scan.next().charAt(0);
                    scan.nextLine();
                    break;
                }
                case 4: {
                    do {
                        scan.nextLine();
                        Song removeSong = new Song();
                        String songName;

                        System.out.println("\n\nUpdate Song");
                        System.out.println("-----------------");
                        System.out.print("Enter Song: ");
                        songName = scan.nextLine().toUpperCase();

                        removeSong.setSongName(songName);

                        if (songList.contains(removeSong)) {

                            removeSong = songList.getEntry(songList.getPosition(removeSong));

                            System.out.println(removeSong);

                            System.out.println("Remove Successfully");
                            songList.remove(songList.getPosition(removeSong));

                        } else {
                            System.out.println("Sorry.");
                        }

                        System.out.print("\nDo you wanna delete more? [y/n]: ");
                        decision = scan.next().charAt(0);

                    } while (decision != 'n' && decision != 'N');

                    System.out.print("\nBack? [y/n]: ");
                    option = scan.next().charAt(0);
                    break;
                }

                case 5: {
                    do {
                        scan.nextLine();
                        Song searchSong = new Song();
                        String songName;
                        System.out.println("\n\nSearch");
                        System.out.println("-----------------");
                        System.out.print("Enter the Song: ");
                        songName = scan.nextLine().toUpperCase();

                        searchSong.setSongName(songName);

                        if (songList.contains(searchSong)) {

                            searchSong = songList.getEntry(songList.getPosition(searchSong));

                            System.out.println("------------------------------------------------------");
                            System.out.print(searchSong);
                            System.out.println("------------------------------------------------------");
                        } else {
                            System.out.println("Sorry");
                        }

                        System.out.print("\nDo you wanna search more? [y/n]: ");
                        decision = scan.next().charAt(0);
                    } while (decision != 'n' && decision != 'N');
                    System.out.print("\nBack? [y/n]: ");
                    option = scan.next().charAt(0);

                }

            }
        } while (option != 'n');
    }

}
