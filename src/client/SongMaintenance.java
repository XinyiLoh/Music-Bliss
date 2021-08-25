/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.SongInterface;
import adt.SortedArrayList;
import entity.Song;
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

        Song tempSong1 = new Song("STAY", "THE KID LAROI");
        Song tempSong2 = new Song("GONE", "ROSIE");
        Song tempSong3 = new Song("MOOD", "24KGOLDIN");
        songList.add(tempSong1);
        songList.add(tempSong2);
        songList.add(tempSong3);

        do {
            System.out.println("1. Add New Song ");
            System.out.println("2. Delete Song ");
            System.out.println("3. View All Song");
            System.out.println("4. Find Song ");
            System.out.println("5. Edit Song ");
            System.out.print("Enter choice: ");
            selection = scan.nextInt();
//            if(selection != 1 && selection != 2 && selection != 3){
//                System.err.print("\nInvalid choice, please try again");
//            }
            scan.nextLine();
        } while (selection != 1 && selection != 2 && selection != 3 && selection !=4);

        switch (selection) {
            case 1: {
                
                do {
                    String addSongName;
                    String addSinger;

                    System.out.print("Enter song's name: ");
                    addSongName = scan.nextLine().toUpperCase();

                    System.out.print("Enter singer: ");
                    addSinger = scan.nextLine().toUpperCase();

                    tempSong.setSongName(addSongName);
                    tempSong.setSinger(addSinger);
                    songList.add(new Song(addSongName, addSinger));

                    System.out.print("\nDo you wanna add more? [y/n]: ");
                    decision = scan.next().charAt(0);
                    scan.nextLine();
                } while (decision != 'n' && decision != 'N');
                break;
            }

            case 2: {            
                do {
                    int number;
                    System.out.println(songList);
                    
                    System.out.print("Enter song's no to delete: ");
                    number = scan.nextInt();
                    songList.remove(number);
                    
                    System.out.println("Delete Successful");
                    
                    System.out.print("\nDo you wanna delete more? [y/n]: ");
                    decision = scan.next().charAt(0);

                } while (decision != 'n' && decision != 'N');
                break;
            }
            case 3: {
                System.out.print("\nList out the songList: " + songList.getNumberOfSongs());
                System.out.println("\nList out the songList: \n" + songList);
                break;
            }
            case 4: {
                String findSong;
                System.out.print("Find the song by typing Song Name: ");
                findSong = scan.nextLine();
                tempSong.equals(findSong);
                
                System.out.print(tempSong);
            }
        }

        System.out.print("\nList out the songList: " + songList.getNumberOfSongs());
        System.out.println("\nList out the songList: " + songList);

    }

}
