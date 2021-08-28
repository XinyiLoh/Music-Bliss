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
import java.util.InputMismatchException;
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
        char sesGoTo;
        char backSesSubMenu = 'n';

        songList.add(new Song("STAY", "THE KID LAROI"));
        songList.add(new Song("GONE", "ROSIE"));
        songList.add(new Song("MOOD", "24KGOLDIN"));
        songList.add(new Song("ATTENTION", "CHARLIE PUTH"));
        songList.add(new Song("REALLY REALLY", "WINNER"));

        do {
            System.out.println("\nKaraoke Session\n----------------");
            System.out.println("1.Add Song to Playlist");
            System.out.println("2.Start Singing");
            System.out.println("3.Playlist");
            System.out.println("4.Generate Reports");
            System.out.println("0.Back to Main Menu");
            System.out.print("\nEnter choice: ");
            sesGoTo = scan.next().charAt(0);

            switch (sesGoTo) {
                case '1':
                    int selectId = 0;
                    char addMore;

                    System.out.println("\n\t\tADD SONG TO PLAYLIST");

                    do {
                        boolean found = false;
                        System.out.println("\nSong List: " + songList.getNumberOfSongs());
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("NO. ID      Song               Singer ");
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(songList);
                        System.out.println("----------------------------------------------------------------");

                        try {
                            System.out.print("\nEnter ID to select song: ");
                            selectId = scan.nextInt();

                            for (int i = 1; i <= songList.getNumberOfSongs(); i++) {
                                if (songList.getEntry(i).getSongID() == selectId) {
                                    found = true;
                                    sessionList.push(new Session(songList.getEntry(i).getSongID(), songList.getEntry(i).getSongName(), songList.getEntry(i).getSinger()));
                                    System.out.println("\nThe song was added successfully...\n");
                                }
                            }
                            if (!found) {
                                System.out.println("\nSong ID does not exist\n");
                            }
                        } catch (InputMismatchException a) {
                            System.err.println("\nPlease enter numeric input only\n");
                            scan.next();
                        }

                        do {
                            System.out.print("Do you want to continue? (y/n) ");
                            addMore = scan.next().charAt(0);
                            if (Character.toLowerCase(addMore) != 'y' && Character.toLowerCase(addMore) != 'n') {
                                System.out.println("\nInvalid input. \nPlease try again.\n");
                            }
                        } while (Character.toLowerCase(addMore) != 'y' && Character.toLowerCase(addMore) != 'n');

                    } while (Character.toLowerCase(addMore) == 'y');
                    break;

                case '2':
                    System.out.println("\n\t\tLET'S START SINGING\n");
//---------------------Current Song
//---------------------Next Song
//---------------------Rate Song
//---------------------Lyrics
                    break;
                case '3':
                    int clearPlaylist = 0;
                    char confirmClear;

                    if (!sessionList.isEmpty()) {
                        System.out.println("\nPLAYLIST\n");
                        System.out.println(sessionList.size() + " songs");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("#\tID\t\tTITLE\t\t\tARTIST");
                        System.out.println("----------------------------------------------------------------");
                        for (int i = 1; i <= sessionList.size(); i++) {
                            System.out.print(i + "\t");
                            System.out.print(sessionList.getEach(i));
                        }
                        do {
                            System.out.println("\nClear Playlist (1) | Exit (0)");
                            System.out.print("Enter choice: ");
                            clearPlaylist = scan.next().charAt(0);
                            if (clearPlaylist != '1' && clearPlaylist != '0') {
                                System.out.println("\nInvalid input. \nPlease try again.\n");
                            }
                        } while (clearPlaylist != '1' && clearPlaylist != '0');
                    } else {
                        System.out.println("\nYour playlist is currently empty\n\nIf you want to add song to your playlist,\nplease proceed to sub-menu to do so");
                    }
                    if (clearPlaylist == '1') {
                        System.out.print("Are you sure? (Y to proceed): ");
                        confirmClear = scan.next().charAt(0);
                        if (Character.toLowerCase(confirmClear) == 'y') {
                            sessionList.clear();
                            System.out.println("\nYour playlist is empty now\n\nIf you want to add song to your playlist,\nplease proceed to sub-menu to do so");
                        }
                    }
                    break;
                case '4':
                    System.out.println("\n\t\tREPORTS\n");
                    break;
                case '0':
                    break;
                default:
                    backSesSubMenu = 'y';
                    System.out.print("\nInvalid input. \nPlease choose an option from the list. \n\n");
            }

            if ((sesGoTo != '0') && sesGoTo == '1' || sesGoTo == '2' || sesGoTo == '3' || sesGoTo == '4') {
                System.out.print("\nBack to Karaoke Session sub-menu (N to exit): ");
                backSesSubMenu = scan.next().charAt(0);
            }
        } while (sesGoTo != '0' && Character.toLowerCase(backSesSubMenu) != 'n');
    }
}
