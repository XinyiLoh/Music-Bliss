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

        Song tempSong1 = new Song("STAY", "THE KID LAROI");
        Song tempSong2 = new Song("GONE", "ROSIE");
        Song tempSong3 = new Song("MOOD", "24KGOLDIN");
        Song tempSong4 = new Song("NUNU NANA", "JESSI");
        Song tempSong5 = new Song("REALLY REALLY", "WINNER");
        Song tempSong6 = new Song("BE KIND", "MARSHMELLO & HALSEY");
        Song tempSong7 = new Song("GET YOU THE MOON", "KINA");
        Song tempSong8 = new Song("THE OCEAN", "SHY MARTIN & MIKE PERRY");
        Song tempSong9 = new Song("NO ONE", "LEE HI & B.I");
        Song tempSong10 = new Song("A THOUSAND YEARS", "CHRISTINA PERRI");
        Song tempSong11 = new Song("OFFICIALLY MISSING YOU", "TAMIA");

        songList.add(tempSong1);

        songList.add(tempSong2);

        songList.add(tempSong3);

        songList.add(tempSong4);

        songList.add(tempSong5);

        songList.add(tempSong6);

        songList.add(tempSong7);

        songList.add(tempSong8);

        songList.add(tempSong9);

        songList.add(tempSong10);

        songList.add(tempSong11);

        do {
            do {
                System.out.println("1. Add New Song ");
                System.out.println("2. Delete Song ");
                System.out.println("3. Find Song ");
                System.out.println("4. Edit Song ");
                System.out.println("5. View All Song");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                try {
                    selection = scan.nextInt();

                    if (selection < 0 || selection > 5) {
                        System.err.println("\nInvalid choice, please try again");
                    }
                } catch (InputMismatchException a) {
                    System.err.println("Must enter a number");
                    scan.next();
                }
            } while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5);

            switch (selection) {
                case 1: {
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

                    System.out.print("Do you back? [y/n]: ");
                    option = scan.next().charAt(0);

                    break;
                }

                case 2: {
                    do {
                        int number;

                        System.out.println(songList.toString());
                        System.out.print("Enter song's number to delete: ");
                        number = scan.nextInt();
                        songList.remove(number);

                        System.out.print("\nDo you wanna delete more? [y/n]: ");
                        decision = scan.next().charAt(0);

                    } while (decision != 'n' && decision != 'N');
                    System.out.print("\nDo you back? [y/n]: ");
                    option = scan.next().charAt(0);
                    break;
                }
                case 3: {

                    String findSong;
                    System.out.print("Find the song by typing Song Name: ");
                    findSong = scan.nextLine();
                    tempSong.compareTo(tempSong);

                }
                case 4: {
                    do {
                        int index;
                        String replaceName;
                        String replaceSinger;

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

                        songList.replace(index, tempSong);

                        System.out.print("\nDo you wanna replace more? [y/n]: ");
                        decision = scan.next().charAt(0);
                        scan.nextLine();
                    } while (decision != 'n' && decision != 'N');
                    System.out.print("\nDo you back? [y/n]: ");
                    option = scan.next().charAt(0);
                    break;
                }

                case 5: {

                    System.out.print("\nList out the songList: " + songList.getNumberOfSongs() + "\n");
                    System.out.println("\nList out the songList: \n" + songList.toString());
                    System.out.print("\nDo you back? [y/n]: ");
                    option = scan.next().charAt(0);
                    break;
                }

                case 6: {

                }

            }
        } while (option
                != 'n');
    }

//    public static String list() {
//        String outputStr = "";
//        for (int position = 1; position <= songList.getNumberOfSongs(); ++position) {
//            outputStr += position + ". " + songList.getPosition(position);
//        }
//        return outputStr;
//    }
}
