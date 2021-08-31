/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedStack;
import adt.SiahxySortedArrayList;
import adt.SiahxySortedListInterface;
import entity.Singer;

import entity.Song;
import entity.coverVersion;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class test {

    public static void main(String[] args) {

        SiahxySortedListInterface<Song> songList = new SiahxySortedArrayList<>();
//        SiahxySortedListInterface<Singer> singerList = new SiahxySortedArrayList<>();
        Scanner scan = new Scanner(System.in);

        SiahxySortedListInterface<Singer> singer1 = new SiahxySortedArrayList<>();
        singer1.add(new Singer("BBox"));
        singer1.add(new Singer("ADSEF"));

        SiahxySortedListInterface<Singer> singer2 = new SiahxySortedArrayList<>();
        singer2.add(new Singer("ROSIE"));

        SiahxySortedListInterface<Singer> singer3 = new SiahxySortedArrayList<>();
        singer3.add(new Singer("BBox"));

        SiahxySortedListInterface<Singer> singer4 = new SiahxySortedArrayList<>();
        singer4.add(new Singer("BBox"));

        SiahxySortedListInterface<Singer> singer5 = new SiahxySortedArrayList<>();
        singer5.add(new Singer("BBox"));

        songList.add(new Song("STAY", singer1));
        songList.add(new Song("GONE", singer2));
        songList.add(new Song("MOOD", singer3));
        songList.add(new Song("ATTENTION", singer4));
        songList.add(new Song("REALLY REALLY", singer5));

        System.out.print(songList);

        //---------Add------------
        Song addSong = new Song();
        SiahxySortedListInterface<Singer> singerAdding = new SiahxySortedArrayList<>();
        Singer singerList = new Singer();
        String addSongName;
        String addSinger;
        int currID;
//
//        System.out.println("\n\nAdd New Song");
//        System.out.println("-----------------");
//        System.out.print("Enter Song Name: ");
//        addSongName = scan.nextLine().toUpperCase();
//
//        System.out.print("Enter Singer: ");
//        addSinger = scan.nextLine().toUpperCase();
//
//        addSong.setSongName(addSongName);
//
//        singerAdding.add(new Singer(addSinger));
//        songList.add(new Song(addSongName, singerAdding));
//        System.out.println("Add Successfully.");

        System.out.println("\n\nAdd New Song");
        System.out.println("-----------------");
        System.out.print("Enter Song Name: ");
        addSongName = scan.nextLine().toUpperCase();
        addSong.setSongName(addSongName);

//        currID = addSong.getSongID();
//        addSong.setSongID(currID);
        
        currID = songList.getEntry(songList.getPosition(addSong)).getSongID();
        addSong.setSongID(currID);

        System.out.println(currID);
        System.out.println(addSong);
        
        if (songList.contains(addSong)) {
            System.out.print("Enter Singer: ");
            addSinger = scan.nextLine().toUpperCase();

            singerAdding = songList.getEntry(songList.getPosition(addSong)).getSinger();

            singerList.setSinger(addSinger);
            singerAdding.add(singerList);
            addSong.setSinger(singerAdding);
            songList.replace(songList.getPosition(addSong), addSong);

        }

        System.out.print(songList);
//--------Update--------
//        Song updateSong = new Song();
//        SiahxySortedListInterface<Singer> singerUpdate = new SiahxySortedArrayList<>();
//        Singer singerUpdating = new Singer();
//        int currID = 0;
//        String currSongName = "";
//        String currSinger = "";
//        char updateSelection;
//
//        System.out.println("\n\nUpdate Song");
//        System.out.println("-----------------");
//        System.out.print("Enter Song Name: ");
//        String songName = scan.nextLine().toUpperCase();
//        updateSong.setSongName(songName);
//
//        if (songList.contains(updateSong)) {
//
//            updateSong = songList.getEntry(songList.getPosition(updateSong));
//
//            System.out.println("------------------------------------------------------");
//            System.out.print(updateSong);
//            System.out.println("------------------------------------------------------");
//
//            System.out.println("1. Update Song Name");
//            System.out.println("2. Update Singer");
//            System.out.print("Enter selection: ");
//            updateSelection = scan.next().charAt(0);
//
//            scan.nextLine();
//
//            switch (updateSelection) {
//                case '1':
////                    System.out.print("Enter Song Name: ");
////                    String replaceName = scan.nextLine().toUpperCase();
////                    updateSong.setSongName(replaceName);
////
////                    currID = updateSong.getSongID();
////                    updateSong.setSongID(currID);
////
////                    currSinger = singerUpdating.getSinger();
////                    singerUpdating.setSinger(currSinger);
////                    songList.replace(songList.getPosition(updateSong), updateSong);
////
////                    break;
////
//                case '2':
//                    System.out.print("Select Singer To Update: ");
//                    String replaceSinger = scan.nextLine().toUpperCase();
//                    singerUpdating.setSinger(replaceSinger);
//                    singerUpdate = songList.getEntry(songList.getPosition(updateSong)).getSinger();
//
//                    if (singerUpdate.contains(singerUpdating)) {
//
//                        int position = singerUpdate.getPosition(singerUpdating);
//                        System.out.print("Enter New Singer: ");
//                        String newSinger = scan.nextLine().toUpperCase();
//                        singerUpdating.setSinger(newSinger);
//                        
//                        currID = updateSong.getSongID();
//                        updateSong.setSongID(currID);
//
//                        currSongName = updateSong.getSongName();
//                        updateSong.setSongName(currSongName);
//
//                        singerUpdate.replace(position, singerUpdating);
//                        updateSong.setSinger(singerUpdate);
//                        songList.replace(songList.getPosition(updateSong), updateSong);
//                        
//                        System.out.print(songList);
//
//                    }
//                    break;
//
//                case '3':

//                    break;
//                default:
//                    System.out.print("Quit...");
//            }
//            System.out.println("Update Successfully.");
//        } else {
//            System.err.println("The Song Doesn't Exist.");
//        }
//
//        scan.nextLine();
//-----------Remove-------------
//        Song removeSong = new Song();
//        SiahxySortedListInterface<Singer> Singer = new SiahxySortedArrayList<>();
//        Singer removeSinger = new Singer();
//        String songName;
//        String singer;
//
////        System.out.println("\n\nRemove Song");
////        System.out.println("-----------------");
////        System.out.print("Enter Song Name: ");
////        songName = scan.nextLine().toUpperCase();
////
////        removeSong.setSongName(songName);
////
////        if (songList.contains(removeSong)) {
////
////            removeSong = songList.getEntry(songList.getPosition(removeSong));
////            System.out.println("------------------------------------------------------");
////            System.out.print(removeSong);
////            System.out.println("------------------------------------------------------");
////            System.out.println("Delete Successfully.");
////            songList.remove(songList.getPosition(removeSong));
////
////            System.out.print(songList);
////
////        }
//
//        System.out.println("\n\nRemove Song");
//        System.out.println("-----------------");
//        System.out.print("Enter Song Name: ");
//        songName = scan.nextLine().toUpperCase();
//
//        removeSong.setSongName(songName);
//
//        if (songList.contains(removeSong)) {
//
//            removeSong = songList.getEntry(songList.getPosition(removeSong));
//            System.out.print(removeSong);
//
//            System.out.print("Enter Singer: ");
//            singer = scan.nextLine().toUpperCase();
//
//            removeSinger.setSinger(singer);
//            Singer = songList.getEntry(songList.getPosition(removeSong)).getSinger();
// 
//            
//            if (Singer.contains(removeSinger)) {
//
//                removeSinger = Singer.getEntry(Singer.getPosition(removeSinger));
//
//                System.out.print(removeSinger);
//                System.out.println("------------------------------------------------------");
//                System.out.print(removeSong);
//                System.out.println("------------------------------------------------------");
//                System.out.println("Delete Successfully.");
//                Singer.remove(Singer.getPosition(removeSinger));
//
//                removeSong.setSinger(Singer);
//                songList.replace(songList.getPosition(removeSong), removeSong);
//                System.out.print(songList);
//            }else{
//                System.out.println("Error");
//            }
//        }
    }
}
