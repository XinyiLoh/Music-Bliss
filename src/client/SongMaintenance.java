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

        Song tempSong1 = new Song("Stay", "The Kid LAROI");
        Song tempSong2 = new Song("Gone", "Rosie");
        Song tempSong3 = new Song("Mood", "24KGoldin");
        songList.add(tempSong1);
        songList.add(tempSong2);
        songList.add(tempSong3);

        do {
            System.out.println("1. Add New Song ");
            System.out.println("2. Delete Song ");
            System.out.println("3. View All Song");
            System.out.println("4. Find Song ");
            System.out.print("Enter choice: ");
            selection = scan.nextInt();
//            if(selection != 1 && selection != 2 && selection != 3){
//                System.err.print("\nInvalid choice, please try again");
//            }
            scan.nextLine();
        } while (selection != 1 && selection != 2 && selection != 3);

        switch (selection) {
            case 1 -> {
                

                do {
                    String addSongName;
                    String addSinger;

                    System.out.print("Enter song's name: ");
                    addSongName = scan.nextLine();

                    System.out.print("\nEnter singer: ");
                    addSinger = scan.nextLine();

                    tempSong.setSongName(addSongName);
                    tempSong.setSinger(addSinger);
                    songList.add(new Song(addSongName, addSinger));

                    System.out.print("\nDo you wanna add more? [y/n]: ");
                    decision = scan.next().charAt(0);
                    scan.nextLine();
                } while ("y".equals(decision));
                break;
            }

            case 2 -> {            
                do {
                    int number;
                    System.out.println(songList);
                    
                    System.out.print("Enter song's no to delete: ");
                    number = scan.nextInt();
                    songList.remove(number);
                    
                    System.out.println("Delete Successful");
                    
                    System.out.print("\nDo you wanna add more? [y/n]: ");
                    decision = scan.next().charAt(0);

                } while ("y".equals(decision));
                break;
            }
            case 3 -> {
                System.out.print("\nList out the songList: " + songList.getNumberOfSongs());
                System.out.print("\nList out the songList: " + songList);
                break;
            }
            case 4 ->{
//                String findSong;
//                System.out.print("Find the song by typing Song Name: ");
//                findSong = scan.nextLine();
//                tempSong.compareTo(findSong);
            }
        }

        System.out.print("\nList out the songList: " + songList.getNumberOfSongs());
        System.out.print("\nList out the songList: " + songList);

    }

}
