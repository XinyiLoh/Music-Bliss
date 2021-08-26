/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.SongInterface;
import adt.SortedArrayList;
import entity.Song;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Siah Xin Ying
 */
public class SongMaintenance {

    public static void main(String[] args) {

        SongInterface<Song> songList = new SortedArrayList<Song>();
        Song tempSong = new Song();
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
                    System.out.print("\nList out the songList: " + songList.getNumberOfSongs() + "\n");

                    System.out.println("\n\nSong List");
                    System.out.println("------------------------------------------------------");
                    System.out.println(" ID     Song                            Singer ");
                    System.out.println("------------------------------------------------------");
                    System.out.print(songList);
                    System.out.println("------------------------------------------------------");

                    System.out.print("Back? [y/n]: ");
                    option = scan.next().charAt(0);

                    break;
                }

                case 2: {
                    do {
                        String addSongName;
                        String addSinger;
                        scan.nextLine();

                        System.out.print("Enter song's name: ");
                        addSongName = scan.nextLine().toUpperCase();

                        System.out.print("Enter singer: ");
                        addSinger = scan.nextLine().toUpperCase();

                        tempSong.setSongName(addSongName);
                        tempSong.setSinger(addSinger);
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
                    do {
                        int index;
                        int s;
                        String replaceName;
                        String replaceSinger;

                        System.out.println("1. Edit Song");
                        System.out.println("2. Edit Singer");
                        System.out.println("3. Edit Both");
                        System.out.print("Enter selection: ");
                        s = scan.nextInt();
                        scan.nextLine();

                        System.out.println(songList);
                        

                        switch (s) {
//                            case 1: {
//                                System.out.print("Enter Song number: ");
//                                index = scan.nextInt();
//                                scan.nextLine();
//                                System.out.print("Enter Song name: ");
//                                replaceName = scan.nextLine().toUpperCase();
//                                tempSong.setSongName(replaceName);
//                                int currID = songList.getPosition(index).getSongID();
//                                String currSinger = songList.getPosition(index).getSinger();
//                                tempSong.setSongID(currID);
//                                tempSong.setSinger(currSinger);
//                                songList.replace(index, tempSong);
//                                break;
//                            }
//                            case 2: {
//                                System.out.print("Enter Song number: ");
//                                index = scan.nextInt();
//                                scan.nextLine();
//                                System.out.print("Enter Singer: ");
//                                replaceSinger = scan.nextLine().toUpperCase();
//                                tempSong.setSinger(replaceSinger);
//                                int currID = songList.getPosition(index).getSongID();
//                                String currSong = songList.getPosition(index).getSongName();
//                                tempSong.setSongID(currID);
//                                tempSong.setSongName(currSong);
//                                songList.replace(index, tempSong);
//                                break;
//                            }
                            case 3: {
                                System.out.print("Enter Song number: ");
                                index = scan.nextInt();
                                scan.nextLine();
                                System.out.println(songList.toString());
                                System.out.print("Enter Song number: ");
                                index = scan.nextInt();
                                scan.nextLine();
                                System.out.print("Enter Song name: ");
                                replaceName = scan.nextLine().toUpperCase();
                                tempSong.setSongName(replaceName);
                                System.out.print("Enter Singer: ");
                                replaceSinger = scan.nextLine().toUpperCase();
                                tempSong.setSinger(replaceSinger);
                                int currID = songList.getPosition(index).getSongID();
                                tempSong.setSongID(currID);
                                songList.replace(index, tempSong);
                                break;
                            }
                            default:
                                break;
                        }

                        System.out.print("\nDo you wanna replace more? [y/n]: ");
                        decision = scan.next().charAt(0);
                        scan.nextLine();
                    } while (decision != 'n' && decision != 'N');

                    System.out.print("\nBack? [y/n]: ");
                    option = scan.next().charAt(0);
                    scan.nextLine();
                    break;
                }
                case 4: {
                    do {
                        int number;
                        System.out.print("Enter Song ID : ");

                        System.out.println(songList);
                        System.out.print("Enter song's number to delete: ");
                        number = scan.nextInt();

                        try {
                            if (number < 0 || number > songList.getNumberOfSongs()) {
                                throw new IndexOutOfBoundsException("Invalid Input.");
                            } else {
                                songList.remove(number);
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        }
                        scan.nextLine();

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
                        int findSong;
                        System.out.print("Enter the number to search: ");
                        findSong = scan.nextInt();

                        System.out.println("------------------------------------------------------");
                        System.out.println(" ID     Song                            Singer ");
                        System.out.println("------------------------------------------------------");
                        System.out.print(songList.getPosition(findSong));
                        System.out.println("------------------------------------------------------");

                        System.out.print("\nDo you wanna search more? [y/n]: ");
                        decision = scan.next().charAt(0);
                    } while (decision != 'n' && decision != 'N');
                    System.out.print("\nBack? [y/n]: ");
                    option = scan.next().charAt(0);

                }

            }
        } while (option != 'n');
    }

//    public static String list() {
//        String outputStr = "";
//        for (int position = 1; position <= songList.getNumberOfSongs(); ++position) {
//            outputStr += position + ". " + songList.getPosition(position);
//        }
//        return outputStr;
//    }
}
