/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedStack;
import adt.SiahxySortedArrayList;
import adt.StackInterface;
import entity.Session;
import entity.Song;
import java.util.Scanner;

/**
 *
 * @author Koh Hui Hui
 */
public class KaraokeSession {

    public static void main(String[] args) {

        StackInterface<Session> sessionList = new LinkedStack<>();
        SiahxySortedArrayList<Song> songList = new SiahxySortedArrayList<>();
        Scanner scan = new Scanner(System.in);
        char sesSelection;
        char sesSubMenu = 'n';

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
            System.out.println("\nKaraoke Session\n----------------");
            System.out.println("1.Add Song to Playlist");
            System.out.println("2.Start Singing");
            System.out.println("3.Show Playlist");
            System.out.println("4.Generate Reports");
            System.out.println("0.Back to Main Menu");
            System.out.print("\nEnter choice: ");
            sesSelection = scan.next().charAt(0);

            switch (sesSelection) {
                case '1':
                    int selectId = 0;
                    char addMore;
                    boolean found = false;

                    System.out.print("\n----------------------\nAdd Song to Playlist\n----------------------\n\n");

                    do {
                        System.out.println("\nSong List: " + songList.getNumberOfSongs());
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("NO.  ID\t\tSong\t\t\tSinger ");
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(songList);
                        System.out.println("----------------------------------------------------------------");

                        System.out.print("\nEnter ID to select song: ");
                        selectId = scan.nextInt();
//---------------------validation not added yet

                        for (int i = 1; i <= songList.getNumberOfSongs(); i++) {
                            if (songList.getEntry(i).getSongID() == selectId) {
                                found = true;
                                sessionList.push(new Session(songList.getEntry(i).getSongID(), songList.getEntry(i).getSongName(), songList.getEntry(i).getSinger()));
                            }
                        }

                        if (found) {
                            System.out.println("\nThe song was added successfully...\n");
                        } else {
                            System.out.println("\nSong ID does not exist\n");
                        }

                        do {
                            System.out.print("Do you want to continue? (y/n) ");
                            addMore = scan.next().charAt(0);
                            if (addMore != 'y' && addMore != 'n') {
                                System.out.println("\nInvalid input. \nPlease try again.\n");
                            }
                        } while (addMore != 'y' && addMore != 'n');

                    } while (addMore == 'y');
                    break;

                case '2':
                    System.out.print("\n-------------------\nLet's Start Singing\n-------------------\n\n");
//---------------------Current Song
//---------------------Next Song
//---------------------Rate Song
//---------------------Lyrics
                    break;
                case '3':

//---------------------To be removed
                    sessionList.push(new Session(1009, "blabla", "blabla"));
                    sessionList.push(new Session(1010, "blabla", "blabla"));

//---------------------Display the details
                    if (!sessionList.isEmpty()) {
                        System.out.print("\n--------\nPlaylist\n--------\n\n");
                        System.out.println("------------------------------------------------------");
                        System.out.println("NO.  ID\t\tSong\t\t\tSinger ");
                        System.out.println("------------------------------------------------------");
                        for (int i = 1; i <= sessionList.size(); i++) {
                            System.out.print(sessionList.getEach(i).getSessionID());
                        }
                        System.out.println("------------------------------------------------------");
                    } else {
                        System.out.println("\nYour playlist is currently empty\n\nIf you want to add song to your playlist,\nplease proceed to sub-menu to do so");
                    }
                    break;
                case '4':
                    System.out.print("\n-------\nReports\n-------\n\n");
                    break;
                case '0':
                    break;
                default:
                    sesSubMenu = 'y';
                    System.out.print("\nInvalid input. \nPlease choose an option from the list. \n\n");
            }

            if ((sesSelection != '0') && sesSelection == '1' || sesSelection == '2' || sesSelection == '3' || sesSelection == '4') {
                System.out.print("\nBack to Karaoke Session sub-menu (N to exit): ");
                sesSubMenu = scan.next().charAt(0);
            }
        } while (sesSelection != '0' && Character.toLowerCase(sesSubMenu) != 'n');
    }
}
