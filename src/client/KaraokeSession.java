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
        int selectSong = 0;

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
            System.out.println("1.Add Song into Playlist");
            System.out.println("2.Start Singing");
            System.out.println("3.Show Playlist");
            System.out.println("4.Generate reports");
            System.out.println("0.Back to Main Menu");
            System.out.print("\nEnter choice: ");
            sesSelection = scan.nextLine().charAt(0);

            switch (sesSelection) {
                case '1':
                    System.out.print("\n----------------------\nAdd Song into Playlist\n----------------------\n\n");
                    System.out.println("\nSong List: " + songList.getNumberOfSongs());
                    System.out.println("------------------------------------------------------");
                    System.out.println("NO. ID\t\tSong\t\t\tSinger ");
                    System.out.println("------------------------------------------------------");
                    System.out.print(songList);
                    System.out.println("------------------------------------------------------");

                    System.out.print("\nSelect Song - Enter the number of the song: ");
                    selectSong = scan.nextInt();

//                    sessionList.push(new Session());
//                    sessionList.push("hi");
//                    sessionList.push("hi");
//                    sessionList.push("hi");
//                    sessionList.push("hi");
//                    sessionList.push("hi");
//                    System.out.print(sessionList.toString());
                    break;
                case '2':
                    System.out.print("\n-------------------\nLet's Start Singing\n-------------------\n\n");
//                    Current Song
//                    Next Song
//                    Rate Song
//                    Lyrics
                    break;
                case '3':
                    System.out.print("\n--------\nPlaylist\n--------\n\n");
                    System.out.println("------------------------------------------------------");
                    System.out.println("NO. ID\t\tSong\t\t\tSinger ");
                    System.out.println("------------------------------------------------------");
                    System.out.print(sessionList);
                    System.out.println("------------------------------------------------------");
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
                System.out.print("Back to Karaoke Session sub-menu (N to exit): ");
                sesSubMenu = scan.nextLine().charAt(0);
            }
        } while (sesSelection != '0' && Character.toLowerCase(sesSubMenu) != 'n');
    }
}
