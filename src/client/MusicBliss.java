/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedStack;
import adt.SiahxySortedArrayList;
import adt.SiahxySortedListInterface;
import adt.SortedLinkedList;
import adt.SortedListInterface;
import adt.StackInterface;
import entity.Member;
import entity.Session;
import entity.Song;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Music Bliss
 */
public class MusicBliss {

    public static void main(String[] args) {

        SortedListInterface<Member> memberList = new SortedLinkedList<>();
        SiahxySortedListInterface<Song> favouriteSongList = new SiahxySortedArrayList<>();

        memberList.insert(new Member(1001, "Aurora", "A", "010-0000000", "Female", 100,favouriteSongList));
        memberList.insert(new Member(1002, "Bob", "B", "011-1111111", "Male", 700,favouriteSongList));
        memberList.insert(new Member(1003, "Cara", "C", "012-2222222", "Female", 300,favouriteSongList));
        memberList.insert(new Member(1004, "Daniel", "D", "013-3333333", "Male", 400,favouriteSongList));
        memberList.insert(new Member(1005, "Eva", "E", "014-4444444", "Female", 300,favouriteSongList));

        SiahxySortedListInterface<Song> songList = new SiahxySortedArrayList<>();

        songList.add(new Song("STAY", "THE KID LAROI"));
        songList.add(new Song("GONE", "ROSIE"));
        songList.add(new Song("MOOD", "24KGOLDIN"));
        songList.add(new Song("ATTENTION", "CHARLIE PUTH"));
        songList.add(new Song("REALLY REALLY", "WINNER"));

        StackInterface<Session> sessionList = new LinkedStack<>();
        StackInterface<Session> rankList = new LinkedStack<>();

        Scanner scan = new Scanner(System.in);
        char selection;

        do {

            System.out.println("\n\n𝓜𝓾𝓼𝓲𝓬 𝓑𝓵𝓲𝓼𝓼      ");
            System.out.println("_________________________________");
            System.out.println("            Main Menu            ");
            System.out.println("_________________________________");
            System.out.println("1.      Member Maintenance");
            System.out.println("2.      Song Maintenance");
            System.out.println("3.      Karaoke Session");
            System.out.println("0.      Exit");
            System.out.println("_________________________________");

            System.out.print("Enter choice: ");
            selection = scan.nextLine().charAt(0);

            switch (selection) {
                case '1':
                    char option;

                    do {
                        System.out.println("\n\n====================");
                        System.out.println("Member Maintenance");
                        System.out.println("====================");
                        System.out.println("1.Member List");
                        System.out.println("2.Add Member");
                        System.out.println("3.Update Member");
                        System.out.println("4.Remove Member");
                        System.out.println("5.Search Member");
                        System.out.println("6.Favorite Song List");
                        System.out.println("0.Back to Main Menu");
                        System.out.println("====================");
                        System.out.print("Enter choice: ");
                        option = scan.nextLine().charAt(0);

                        switch (option) {
                            case '1':
                                System.out.println("\n\nMember List: " + memberList.totalEntries());
                                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                System.out.println("     ID   First Name    Last name          Mobile     Gender                 Join Date     Reward Points       Level");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                System.out.print(memberList);
                                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                break;

                            case '2':

                                System.out.println("\n\nAdd Member");
                                System.out.println("---------------");

                                int id = memberList.getEntry(memberList.totalEntries()).getiD() + 1;

                                System.out.print("Please Enter First Name: ");
                                String fname = scan.nextLine();
                                String extractFname = fname.replaceAll("[^A-Za-z]+", "");

                                System.out.print("Please Enter Last Name: ");
                                String lname = scan.nextLine();
                                String extractLname = lname.replaceAll("[^A-Za-z]+", "");

                                boolean phone = false;
                                boolean pass = true;
                                String pnum = "0";

                                while (!phone) {
                                    pass = true;
                                    System.out.print("Please Enter Phone Number: ");
                                    pnum = scan.nextLine();

                                    if (Pattern.matches("\\d{10}", pnum)) {
                                        pnum = pnum.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
                                        Member equalsPhone = new Member(pnum);
                                        for (int i = 1; i <= memberList.totalEntries(); i++) {
                                            if (memberList.getEntry(i).equals(equalsPhone)) {
                                                pass = false;
                                                System.err.print("Phone Number already existed.\n");
                                                break;
                                            }
                                        }

                                        if (pass) {
                                            phone = true;
                                        }

                                    } else {
                                        System.err.println("Must enter 10 numbers.");
                                    }
                                }

                                boolean selectGender = false;
                                String gender = "Not Selected";

                                while (!selectGender) {
                                    System.out.print("Please Enter Gender (M = Male/ F = Female): ");
                                    char genderCode = scan.nextLine().charAt(0);

                                    if (genderCode == 'M' || genderCode == 'F' || genderCode == 'f' || genderCode == 'm') {
                                        if (genderCode == 'M' || genderCode == 'm') {
                                            gender = "Male";
                                        } else {
                                            gender = "Female";
                                        }
                                        selectGender = true;
                                    } else {
                                        System.err.println("Must enter F or M character only.");
                                    }
                                }

                                boolean reward = false;
                                int rw = 0;

                                while (!reward) {
                                    System.out.print("Please Enter Reward Points: ");
                                    try {
                                        rw = scan.nextInt();
                                        reward = true;
                                    } catch (InputMismatchException a) {
                                        System.err.println("Must enter numbers.");
                                        scan.next();
                                    }
                                }

                                Member newMember = new Member(id, extractFname, extractLname, pnum, gender, rw, favouriteSongList);

                                if (memberList.insert(newMember)) {
                                    System.out.println("\nNew Member Added Successfully.");
                                } else {
                                    System.err.println("\nAdd Failed.");
                                }  
                                
                                scan.nextLine();
                                break;

                            case '3':
                                System.out.println("\n\nUpdate Member");
                                System.out.println("-----------------");
                                int updateID;
                                Member updateEntry = new Member();
                                System.out.print("Enter Member ID : ");

                                try {

                                    updateID = scan.nextInt();
                                    updateEntry.setiD(updateID);

                                    if (memberList.found(updateEntry)) {
                                        updateEntry = memberList.getEntry(memberList.getPosition(updateEntry));
                                        char updateChoice;

                                        scan.nextLine();
                                        do {
                                            memberList.delete(updateEntry);
                                            System.out.println("\n" + updateEntry);

                                            System.out.println("\nUpdate");
                                            System.out.println("-------");
                                            System.out.println("1.First Name");
                                            System.out.println("2.Last Name");
                                            System.out.println("3.Phone Number");
                                            System.out.println("4.Gender");
                                            System.out.println("5.Reward Points");
                                            System.out.println("0.Cancel");
                                            System.out.println("--------------------");

                                            System.out.print("Enter choice: ");
                                            updateChoice = scan.nextLine().charAt(0);

                                            switch (updateChoice) {
                                                case '1':
                                                    System.out.print("Please Enter First Name: ");
                                                    String updateFname = scan.nextLine();
                                                    String extractUpdateFname = updateFname.replaceAll("[^A-Za-z]+", "");
                                                    updateEntry.setFirstName(extractUpdateFname);
                                                    System.out.print("Update Successfully.\n");
                                                    break;
                                                case '2':
                                                    System.out.print("Please Enter Last Name: ");
                                                    String updateLname = scan.nextLine();
                                                    String extractUpdateLname = updateLname.replaceAll("[^A-Za-z]+", "");
                                                    updateEntry.setLastName(extractUpdateLname);
                                                    System.out.print("Update Successfully.\n");
                                                    break;
                                                case '3':
                                                    boolean updatePhone = false;
                                                    String updatePnum;

                                                    while (!updatePhone) {
                                                        pass = true;
                                                        System.out.print("Please Enter Phone Number: ");
                                                        updatePnum = scan.nextLine();

                                                        if (Pattern.matches("\\d{10}", updatePnum)) {
                                                            updatePnum = updatePnum.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
                                                            Member equalsPhone = new Member(updatePnum);
                                                            for (int i = 1; i <= memberList.totalEntries(); i++) {
                                                                if (memberList.getEntry(i).equals(equalsPhone)) {
                                                                    pass = false;
                                                                    System.err.print("Phone Number already existed.\n");
                                                                    break;
                                                                }
                                                            }

                                                            if (pass) {
                                                                updateEntry.setMobile(updatePnum);
                                                                updatePhone = true;
                                                            }

                                                        } else {
                                                            System.err.println("Must enter 10 numbers.");
                                                        }
                                                    }

                                                    System.out.print("Update Successfully.\n");
                                                    break;
                                                case '4':
                                                    boolean selectGend = false;
                                                    String gend = "Not Selected";

                                                    while (!selectGend) {
                                                        System.out.print("Please Enter Gender (M = Male/ F = Female): ");
                                                        char genderCode = scan.nextLine().charAt(0);

                                                        if (genderCode == 'M' || genderCode == 'F' || genderCode == 'f' || genderCode == 'm') {
                                                            if (genderCode == 'M' || genderCode == 'm') {
                                                                gend = "Male";
                                                            } else {
                                                                gend = "Female";
                                                            }
                                                            updateEntry.setGender(gend);
                                                            selectGend = true;
                                                        } else {
                                                            System.err.println("Must enter F or M character only.");
                                                        }
                                                    }
                                                    System.out.print("Update Successfully.\n");
                                                    break;
                                                case '5':
                                                    boolean rewardP = false;
                                                    int rp = 0;

                                                    while (!rewardP) {
                                                        System.out.print("Please Enter Operation (A = Add/ M = Minus): ");
                                                        char rpOperation = scan.nextLine().charAt(0);

                                                        if (rpOperation == 'A' || rpOperation == 'a' || rpOperation == 'M' || rpOperation == 'm') {
                                                            if (rpOperation == 'A' || rpOperation == 'a') {
                                                                System.out.print("Please Enter Number of Reward Points want to add: ");
                                                                try {
                                                                    rp = scan.nextInt();
                                                                    updateEntry.addRewardPoints(rp);
                                                                    updateEntry.setMembership();
                                                                    rewardP = true;
                                                                } catch (InputMismatchException a) {
                                                                    System.err.println("Must enter numbers.");
                                                                    scan.next();
                                                                }
                                                            } else {
                                                                System.out.print("Please Enter Number of Reward Points want to minus: ");
                                                                try {
                                                                    rp = scan.nextInt();
                                                                    if (!updateEntry.minusRewardPoints(rp)) {
                                                                        System.err.println("Insufficient Reward Points.");
                                                                    }
                                                                    rewardP = true;
                                                                } catch (InputMismatchException a) {
                                                                    System.err.println("Must enter numbers.");
                                                                    scan.next();
                                                                }
                                                            }
                                                        } else {
                                                            System.err.println("Must enter F or M character only.");
                                                        }

                                                    }
                                                    System.out.print("Update Successfully.\n");
                                                    scan.nextLine();
                                                    break;
                                                case '0':
                                                    System.err.print("Update Cancel.");
                                                    break;
                                                default:
                                                    System.err.print("Incorrect Input, Please try again.\n\n");
                                            }

                                            memberList.insert(updateEntry);

                                        } while (Character.compare(updateChoice, '0') != 0);

                                    } else {
                                        System.err.println("Member ID not found.");
                                    }

                                } catch (InputMismatchException a) {
                                    System.err.println("Must enter numbers.");
                                    scan.next();
                                }
                                scan.nextLine();
                                break;
                            case '4':

                                System.out.println("\n\nRemove Member");
                                System.out.println("-----------------");
                                Member removeEntry = new Member();
                                System.out.print("Enter Member ID : ");

                                try {
                                    int removeID = scan.nextInt();
                                    removeEntry.setiD(removeID);

                                    if (memberList.found(removeEntry)) {
                                        if (memberList.delete(removeEntry)) {
                                            System.out.println("Delete Successfully.");
                                        } else {
                                            System.err.println("Delete Failed.");
                                        }
                                    } else {
                                        System.err.println("Member ID not found.");
                                    }

                                } catch (InputMismatchException a) {
                                    System.err.println("Must enter numbers.");
                                    scan.next();
                                }
                                scan.nextLine();
                                break;
                            case '5':
                                System.out.println("\n\nSearch Member");
                                System.out.println("-----------------");
                                System.out.println("1. By ID");
                                System.out.println("2. By Phone Number");
                                System.out.println("-----------------");
                                Member searchEntryID = new Member();
                                Member searchEntryPhone = new Member();
                                System.out.print("Enter Option: ");

                                try {
                                    int search = scan.nextInt();

                                    if (search == 1) {
                                        System.out.print("Enter Member ID: ");
                                        int searchID = scan.nextInt();
                                        searchEntryID.setiD(searchID);
                                    } else if (search == 2) {
                                        scan.nextLine();
                                        System.out.print("Enter Member Mobile: ");
                                        String searchPhone = scan.nextLine();
                                        searchPhone = searchPhone.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
                                        searchEntryPhone.setMobile(searchPhone);
                                    } else {
                                        System.err.print("Invalid option.\n");
                                    }

                                    boolean finding = false;
                                    for (int i = 1; i <= memberList.totalEntries(); i++) {

                                        if (memberList.found(searchEntryID) || memberList.getEntry(i).equals(searchEntryPhone)) {
                                            searchEntryID = memberList.getEntry(memberList.getPosition(searchEntryID));
                                            searchEntryPhone = memberList.getEntry(i);
                                            System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                            if (searchEntryID != null) {
                                                System.out.print(searchEntryID);
                                            } else {
                                                System.out.print(searchEntryPhone);
                                            }
                                            System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
                                            finding = true;
                                            break;
                                        }

                                    }

                                    if (!finding && (search == 1 || search == 2)) {
                                        System.err.println("Member not found.\n");
                                        scan.nextLine();
                                        break;
                                    }

                                } catch (InputMismatchException a) {
                                    System.err.println("Must enter numbers.");
                                    scan.next();
                                }
                                scan.nextLine();
                                break;
                            case '6':
                                System.out.println("\n\nFavourite Song List");
                                System.out.println("-------------------");
                                Member memberfavouriteSongEntry = new Member();
                                System.out.print("Enter Member ID : ");

                                try {
                                    int memberfavouriteSongID = scan.nextInt();
                                    memberfavouriteSongEntry.setiD(memberfavouriteSongID);
                                    memberfavouriteSongEntry = memberList.getEntry(memberList.getPosition(memberfavouriteSongEntry));
                                    favouriteSongList = memberfavouriteSongEntry.getFavouriteSongList();

                                    if (memberList.found(memberfavouriteSongEntry)) {
                                        scan.nextLine();
                                        char fsChoice;
                                        do{
                                            System.out.println("\nOptions ");
                                            System.out.println("-------- ");
                                            System.out.println("1. Add Favourite Song ");
                                            System.out.println("2. Remove Favourite Song ");
                                            System.out.println("0. Cancel ");
                                            System.out.print("Enter choice: ");
                                            fsChoice = scan.nextLine().charAt(0);

                                            switch(fsChoice){
                                                case '1':
                                                        try {
                                                            System.out.println("\nSong List: " + songList.getNumberOfSongs());
                                                            System.out.println("----------------------------------------------------------------");
                                                            System.out.println("NO. ID      Song               Singer ");
                                                            System.out.println("----------------------------------------------------------------");
                                                            System.out.print(songList);
                                                            System.out.println("----------------------------------------------------------------");
                                                   
                                                            System.out.print("\nEnter ID to select song: ");
                                                            int favouriteSongID = scan.nextInt();
                                                            boolean found = false;
                                                            for (int i = 1; i <= songList.getNumberOfSongs(); i++) {
                                                                if (songList.getEntry(i).getSongID() == favouriteSongID) {
                                                                    favouriteSongList.add(songList.getEntry(i));
                                                                    memberfavouriteSongEntry.setFavouriteSongList(favouriteSongList);
                                                                    //memberList.delete(memberfavouriteSongEntry);
                                                                    //memberList.insert(memberfavouriteSongEntry);
                                                                    System.out.println("The song has added into favourite song list.\n");
                                                                    found = true;
                                                                }
                                                            }
                                                            if (!found) {
                                                                System.err.println("Song ID does not exist.\n\n");
                                                            }
                                                        } catch (InputMismatchException a) {
                                                            System.err.println("Must enter numbers.");
                                                            scan.next();
                                                        }
                                                    scan.nextLine();
                                                    break;
                                                case '2':
                                                    try {
                                                        memberfavouriteSongEntry = memberList.getEntry(memberList.getPosition(memberfavouriteSongEntry));
                                                        System.out.println("\nFavourite Song List of " + memberfavouriteSongEntry.getFirstName() + " " + memberfavouriteSongEntry.getLastName()); 
                                                        System.out.println("----------------------------------------------------------------");
                                                        System.out.print(favouriteSongList); 
                                                        System.out.println("Total " + favouriteSongList.getNumberOfSongs() + " Favourite Songs");
                                                        System.out.print("\nEnter ID to select song: ");
                                                            int favouriteSongID = scan.nextInt();
                                                            boolean found = false;
                                                            for (int i = 1; i <= favouriteSongList.getNumberOfSongs(); i++) {
                                                                if(favouriteSongList.getEntry(i).getSongID() == favouriteSongID){
                                                                    favouriteSongList.remove(i);
                                                                    memberfavouriteSongEntry.setFavouriteSongList(favouriteSongList);
                                                                    //memberList.delete(memberfavouriteSongEntry);
                                                                    //memberList.insert(memberfavouriteSongEntry);
                                                                    System.out.println("The favourite song has added removed.\n");
                                                                    found = true;
                                                                }
                                                            }
                                                            if (!found) {
                                                                System.err.println("Song ID is not in the favourite song list.\n\n");
                                                            }
                                                        } catch (InputMismatchException a) {
                                                            System.err.println("Must enter numbers.");
                                                            scan.next();
                                                        }
                                                    scan.nextLine();
                                                    break;
                                                case '0':
                                                    System.err.print("Quit.\n");   
                                                    favouriteSongList.clear();
                                                    break;
                                                default:
                                                    System.err.print("Invalid option.\n\n");
                                            }
                                        }while(Character.compare(fsChoice, '0') != 0);
                                       
                                    } else {
                                        System.err.println("Member ID not found.");
                                    }

                                } catch (InputMismatchException a) {
                                    System.err.println("Must enter numbers.");
                                    scan.next();
                                }
                                scan.nextLine();
                                break;
                            case '0':
                                break;
                            default:
                                System.err.print("Incorrect Input, Please try again.\n");
                        }

                    } while (Character.compare(option, '0') != 0);

                    break;
                case '2':
                    char songOption;
                    char decision;
                    do {

                        System.out.println("\n\n====================");
                        System.out.println("Song Maintenance");
                        System.out.println("====================");
                        System.out.println("1. Song List ");
                        System.out.println("2. Add Song ");
                        System.out.println("3. Update Song ");
                        System.out.println("4. Remove Song ");
                        System.out.println("5. Search Song");
                        System.out.println("0. Back to Main Menu");
                        System.out.println("====================");
                        System.out.print("Enter choice: ");
                        songOption = scan.nextLine().charAt(0);

                        switch (songOption) {
                            case '1':

                                System.out.println("\nSong List: " + songList.getNumberOfSongs());
                                System.out.println("----------------------------------------------------------------");
                                System.out.println("NO. ID      Song               Singer ");
                                System.out.println("----------------------------------------------------------------");
                                System.out.print(songList);
                                System.out.println("----------------------------------------------------------------");

                                break;

                            case '2':

                                do {
                                    Song addSong = new Song();
                                    String addSongName;
                                    String addSinger;

                                    System.out.println("\n\nAdd New Song");
                                    System.out.println("-----------------");
                                    System.out.print("Enter Song Name: ");
                                    addSongName = scan.nextLine().toUpperCase();

                                    System.out.print("Enter Singer: ");
                                    addSinger = scan.nextLine().toUpperCase();
                                    addSong.setSongName(addSongName);
                                    addSong.setSinger(addSinger);
                                    songList.add(new Song(addSongName, addSinger));
                                    System.out.println("Add Successfully.");

                                    do {
                                        System.out.print("Do you wanna add more? [y/n]: ");
                                        decision = scan.next().charAt(0);
                                        if (decision != 'n' && decision != 'N' && decision != 'y' && decision != 'Y') {
                                            System.err.print("Incorrect Input, Please try again.\n\n");
                                        }
                                    } while (decision != 'n' && decision != 'N' && decision != 'y' && decision != 'Y');
                                    scan.nextLine();
                                } while (decision != 'n' && decision != 'N');
                                break;

                            case '3':
                                do {
                                    Song updateSong = new Song();
                                    int currID = 0;
                                    String currSongName = "";
                                    String currSinger = "";
                                    char updateSelection;

                                    System.out.println("\n\nUpdate Song");
                                    System.out.println("-----------------");
                                    System.out.print("Enter Song Name: ");
                                    String songName = scan.nextLine().toUpperCase();
                                    updateSong.setSongName(songName);

                                    if (songList.contains(updateSong)) {

                                        updateSong = songList.getEntry(songList.getPosition(updateSong));

                                        System.out.println("------------------------------------------------------");
                                        System.out.print(updateSong);
                                        System.out.println("------------------------------------------------------");

                                        System.out.println("1. Update Song Name");
                                        System.out.println("2. Update Singer");
                                        System.out.println("3. Update Both");
                                        System.out.print("Enter selection: ");
                                        updateSelection = scan.next().charAt(0);

                                        scan.nextLine();

                                        switch (updateSelection) {
                                            case '1':
                                                System.out.print("Enter Song Name: ");
                                                String replaceName = scan.nextLine().toUpperCase();
                                                updateSong.setSongName(replaceName);

                                                currID = updateSong.getSongID();
                                                updateSong.setSongID(currID);
                                                currSinger = updateSong.getSinger();
                                                updateSong.setSinger(currSinger);
                                                songList.replace(songList.getPosition(updateSong), updateSong);
                                                break;

                                            case '2':
                                                System.out.print("Enter Singer: ");
                                                String replaceSinger = scan.nextLine().toUpperCase();
                                                updateSong.setSinger(replaceSinger);

                                                currID = updateSong.getSongID();
                                                updateSong.setSongID(currID);
                                                currSongName = updateSong.getSongName();
                                                updateSong.setSongName(currSongName);
                                                songList.replace(songList.getPosition(updateSong), updateSong);
                                                break;

                                            case '3':
                                                System.out.print("Enter Song Name: ");
                                                replaceName = scan.nextLine().toUpperCase();
                                                updateSong.setSongName(replaceName);

                                                System.out.print("Enter Singer: ");
                                                replaceSinger = scan.nextLine().toUpperCase();
                                                updateSong.setSinger(replaceSinger);

                                                currID = updateSong.getSongID();
                                                updateSong.setSongID(currID);
                                                songList.replace(songList.getPosition(updateSong), updateSong);
                                                break;
                                            default:
                                                System.out.print("Quit...");
                                        }
                                        System.out.println("Update Successfully.");
                                    } else {
                                        System.err.println("The Song Doesn't Exist.");
                                    }

                                    do {
                                        System.out.print("Do you want to update more? [y/n]: ");
                                        decision = scan.next().charAt(0);
                                        if (decision != 'n' && decision != 'N' && decision != 'y' && decision != 'Y') {
                                            System.err.print("Incorrect Input, Please try again.\n\n");
                                        }
                                    } while (decision != 'n' && decision != 'N' && decision != 'y' && decision != 'Y');
                                    scan.nextLine();
                                } while (decision != 'n' && decision != 'N');

                                break;

                            case '4':
                                do {
                                    Song removeSong = new Song();
                                    String songName;

                                    System.out.println("\n\nRemove Song");
                                    System.out.println("-----------------");
                                    System.out.print("Enter Song Name: ");
                                    songName = scan.nextLine().toUpperCase();

                                    removeSong.setSongName(songName);

                                    if (songList.contains(removeSong)) {

                                        removeSong = songList.getEntry(songList.getPosition(removeSong));
                                        System.out.println("------------------------------------------------------");
                                        System.out.print(removeSong);
                                        System.out.println("------------------------------------------------------");
                                        System.out.println("Delete Successfully.");
                                        songList.remove(songList.getPosition(removeSong));

                                    } else {
                                        System.err.println("The Song Doesn't Exist.");
                                    }
                                    do {
                                        System.out.print("\nDo you want to delete more? [y/n]: ");
                                        decision = scan.next().charAt(0);
                                        if (decision != 'n' && decision != 'N' && decision != 'y' && decision != 'Y') {
                                            System.err.print("Incorrect Input, Please try again.\n\n");
                                        }
                                    } while (decision != 'n' && decision != 'N' && decision != 'y' && decision != 'Y');
                                    scan.nextLine();
                                } while (decision != 'n' && decision != 'N');

                                break;

                            case '5':
                                do {
                                    Song searchSong = new Song();
                                    String songName;

                                    System.out.println("\n\nSearch");
                                    System.out.println("-----------------");
                                    System.out.print("Enter the Song Name: ");
                                    songName = scan.nextLine().toUpperCase();

                                    searchSong.setSongName(songName);

                                    if (songList.contains(searchSong)) {

                                        searchSong = songList.getEntry(songList.getPosition(searchSong));

                                        System.out.println("------------------------------------------------------");
                                        System.out.print(searchSong);
                                        System.out.println("------------------------------------------------------");
                                    } else {
                                        System.err.println("The Song Doesn't Exist.");
                                    }
                                    do {
                                        System.out.print("\nDo you want to search more? [y/n]: ");
                                        decision = scan.next().charAt(0);
                                        if (decision != 'n' && decision != 'N' && decision != 'y' && decision != 'Y') {
                                            System.err.print("Incorrect Input, Please try again.\n\n");
                                        }
                                    } while (decision != 'n' && decision != 'N' && decision != 'y' && decision != 'Y');
                                    scan.nextLine();
                                } while (decision != 'n' && decision != 'N');
                                break;
                            case '0':
                                break;
                            default:
                                System.err.print("Incorrect Input, Please try again.\n\n");
                        }

                    } while (Character.compare(songOption, '0') != 0);
                    break;
                case '3':
                    char sesGoTo;
                    char backSesSubMenu = 'n';

                    do {
//------------Star Rate
                        String oneStar = "One-Star (Poor)";
                        String twoStar = "Two-Star (Fair)";
                        String threeStar = "Three-Star (Good)";
                        String fourStar = "Four-Star (Excellent)";
                        String fiveStar = "Five-Star (Superior)";

//------------Select Module
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
//------------Add Song
                                int selectId;
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
//------------add if id exists
                                        for (int i = 1; i <= songList.getNumberOfSongs(); i++) {
                                            if (songList.getEntry(i).getSongID() == selectId) {
                                                found = true;
//------------push selected song from song list to karaoke list
                                                sessionList.push(new Session(songList.getEntry(i).getSongID(), songList.getEntry(i).getSongName(), songList.getEntry(i).getSinger()));
                                                System.out.println("\nThe song was added successfully.\n");
                                            }
                                        }
                                        if (!found) {
                                            System.out.println("\nSong ID does not exist.\n");
                                        }
                                    } catch (InputMismatchException a) {
                                        System.err.println("\nPlease enter numeric input only.\n");
                                        scan.next();
                                    }

//------------add more songs
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
                                char playlistOption = '0';

                                System.out.println("\n\t\tLET'S START SINGING");
//------------Display NOW PLAYING and NEXT SONG
                                if (sessionList.isEmpty()) {
                                    System.out.println("\nThe playlist is currently empty,\nplease add more songs to the playlist to continue.");
                                } else if (sessionList.size() == 1) {
                                    System.out.println("\nNow Playing: \n" + sessionList.peek().getSessionName() + " by " + sessionList.peek().getSessionSinger());
                                } else if (sessionList.size() > 1) {
//------------Next song is displayed using peekNext()
                                    System.out.println("\nNow Playing: \n" + sessionList.peek().getSessionName() + " by " + sessionList.peek().getSessionSinger());
                                    System.out.println("\nNext Song: \n" + sessionList.peekNext().getSessionName() + " by " + sessionList.peekNext().getSessionSinger());
                                }

                                do {
                                    if (!(sessionList.isEmpty())) {
                                        do {
                                            System.out.println("\nNext Song (1) | Rate (2) | Exit (0)");
                                            System.out.print("Enter choice: ");
                                            playlistOption = scan.next().charAt(0);
                                            if (playlistOption != '1' && playlistOption != '2' && playlistOption != '0') {
                                                System.out.println("\nInvalid input. \nPlease choose an option from the list.\n");
                                            }
                                        } while (playlistOption != '1' && playlistOption != '2' && playlistOption != '0');
                                    }

                                    switch (playlistOption) {
                                        case '1':
//------------skip to Next Song
//------------In karaoke, to start singing next song, the current song will be removed using pop
                                            if (sessionList.size() == 1) {
                                                System.out.println("\nNow Playing: \n" + sessionList.peek().getSessionName() + " by " + sessionList.peek().getSessionSinger());
                                                System.out.println("\nThe playlist now has only 1 song, \nif you want to add more songs, please proceed to sub-menu to do so.");
                                            } else if (sessionList.size() > 1) {
                                                sessionList.pop();
                                                System.out.println("\nNow Playing: \n" + sessionList.peek().getSessionName() + " by " + sessionList.peek().getSessionSinger());
                                                if (sessionList.size() > 1) {
                                                    System.out.println("\nNext Song: \n" + sessionList.peekNext().getSessionName() + " by " + sessionList.peekNext().getSessionSinger());
                                                }
                                            }
                                            break;
                                        case '2':
//------------rate song
                                            int i;
                                            int j;
                                            int curSongRate;
                                            String starRate = null;
                                            boolean replaceRate = false;

                                            System.out.println("\nRate Song\n");
                                            System.out.println("Star\t    Classification\n--------------------------");
//------------display stars
                                            for (i = 5; i >= 1; i--) {
                                                for (j = 1; j <= i; j++) {
                                                    System.out.print("*");
                                                }
                                                switch (i) {
                                                    case 1:
                                                        System.out.println("\t    Poor");
                                                        break;
                                                    case 2:
                                                        System.out.println("\t    Fair");
                                                        break;
                                                    case 3:
                                                        System.out.println("\t    Good");
                                                        break;
                                                    case 4:
                                                        System.out.println("\t    Excellent");
                                                        break;
                                                    case 5:
                                                        System.out.println("\t    Superior");
                                                        break;
                                                }
                                            }
                                            try {
                                                System.out.print("\nEnter your rating (1 to 5): ");
                                                curSongRate = scan.nextInt();
                                                switch (curSongRate) {
                                                    case 1:
                                                        starRate = oneStar;
                                                        break;
                                                    case 2:
                                                        starRate = twoStar;
                                                        break;
                                                    case 3:
                                                        starRate = threeStar;
                                                        break;
                                                    case 4:
                                                        starRate = fourStar;
                                                        break;
                                                    case 5:
                                                        starRate = fiveStar;
                                                        break;
                                                }
                                                if (curSongRate == (int) curSongRate) {
                                                    for (int n = 1; n <= rankList.size(); n++) {
                                                        if (rankList.getEach(n).getSessionID() == sessionList.peek().getSessionID()) {
//------------If there are same songs, it will take the newest rate
                                                            rankList.getEach(n).setSessionRate(curSongRate);
                                                            System.out.print("\nSong is rated as " + starRate);
                                                            replaceRate = true;
                                                        }
                                                    }
                                                    if (!(replaceRate)) {
                                                        sessionList.peek().setSessionRate(curSongRate);
                                                        rankList.push(sessionList.peek());
                                                        System.out.print("\nSong is rated as " + starRate + "\n");
                                                    }
                                                }
                                            } catch (InputMismatchException a) {
                                                System.err.println("\nPlease enter numeric input only.\n");
                                                scan.next();
                                            }
                                            break;

                                        case '0':
                                            break;
                                    }
                                } while (playlistOption == '1' || playlistOption == '2');
                                break;

                            case '3':
//------------display the playlist
                                char editPlaylist = '0';
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
                                        System.out.println("\nClear Playlist (1) | Duplicate Song (2) | Exit (0)");
                                        System.out.print("Enter choice: ");
                                        editPlaylist = scan.next().charAt(0);
                                        if (editPlaylist != '1' && editPlaylist != '2' && editPlaylist != '0') {
                                            System.out.println("\nInvalid input. \nPlease choose an option from the list.\n");
                                        }
                                    } while (editPlaylist != '1' && editPlaylist != '2' && editPlaylist != '0');
                                } else {
                                    System.out.println("\nYour playlist is currently empty.\n\nIf you want to add song to your playlist,\nplease proceed to sub-menu to do so.");
                                }
                                switch (editPlaylist) {
                                    case '1':
//------------clear playlist
                                        System.out.print("Are you sure? (Y to proceed): ");
                                        confirmClear = scan.next().charAt(0);
                                        if (Character.toLowerCase(confirmClear) == 'y') {
                                            sessionList.clear();
                                            System.out.println("\nYour playlist is empty now.\n\nIf you want to add song to your playlist,\nplease proceed to sub-menu to do so.");

                                        }
                                        break;
                                    case '2':
//------------users can duplicate songs by entering id
                                        boolean found = false;
                                        int dupId;
                                        int count = 0;
                                        try {
                                            System.out.print("\nEnter ID to select song: ");
                                            dupId = scan.nextInt();

                                            if (sessionList.size() == 1) {
                                                found = true;
                                                sessionList.duplicate(1);
                                                System.out.println("\nThe selected song was duplicated.\n");
                                            } else {
                                                for (int i = 1; i <= sessionList.size(); i++) {
                                                    if (sessionList.getEach(i).getSessionID() == dupId && count == 0) {
                                                        found = true;
                                                        count++;
                                                        sessionList.duplicate(i);
                                                        System.out.println("\nThe selected song was duplicated.\n");
                                                    }
                                                }
                                            }
//------------show again the list after duplicate
                                            System.out.println(sessionList.size() + " songs");
                                            System.out.println("----------------------------------------------------------------");
                                            System.out.println("#\tID\t\tTITLE\t\t\tARTIST");
                                            System.out.println("----------------------------------------------------------------");
                                            for (int i = 1; i <= sessionList.size(); i++) {
                                                System.out.print(i + "\t");
                                                System.out.print(sessionList.getEach(i));
                                            }
                                            if (!found) {
                                                System.out.println("\nSong ID does not exist.\n");
                                            }
                                        } catch (InputMismatchException a) {
                                            System.err.println("\nPlease enter numeric input only.\n");
                                            scan.next();
                                        }
                                        break;
                                    case '0':
                                        break;
                                }
                                break;

                            case '4':
//------------show song rank in the report based on the star rates
                                System.out.println("\n\t\tREPORTS (SONG RANK)");
                                if (!(rankList.isEmpty())) {
                                    for (int i = 1; i <= rankList.size(); i++) {
                                        switch (rankList.getEach(i).getSessionRate()) {
                                            case 5:
                                                System.out.println("\n" + fiveStar);
                                                System.out.println("----------------------------------------------------------------");
                                                System.out.print(rankList.getEach(i));
                                                System.out.println("----------------------------------------------------------------");
                                                break;
                                            case 4:
                                                System.out.println("\n" + fourStar);
                                                System.out.println("----------------------------------------------------------------");
                                                System.out.print(rankList.getEach(i));
                                                System.out.println("----------------------------------------------------------------");
                                                break;
                                            case 3:
                                                System.out.println("\n" + threeStar);
                                                System.out.println("----------------------------------------------------------------");
                                                System.out.print(rankList.getEach(i));
                                                System.out.println("----------------------------------------------------------------");
                                                break;
                                            case 2:
                                                System.out.println("\n" + twoStar);
                                                System.out.println("----------------------------------------------------------------");
                                                System.out.print(rankList.getEach(i));
                                                System.out.println("----------------------------------------------------------------");
                                                break;
                                            case 1:
                                                System.out.println("\n" + oneStar);
                                                System.out.println("----------------------------------------------------------------");
                                                System.out.print(rankList.getEach(i));
                                                System.out.println("----------------------------------------------------------------");
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println("\nYou have not rated any song yet.\n");
                                }
                                break;
                            case '0':
                                break;
                            default:
                                backSesSubMenu = 'y';
                                System.out.print("\nInvalid input. \nPlease choose an option from the list. \n\n");
                        }

                        if ((sesGoTo != '0') && sesGoTo == '1' || sesGoTo == '2' || sesGoTo == '3' || sesGoTo
                                == '4') {
                            System.out.print("\nBack to Karaoke Session sub-menu (N to exit): ");
                            backSesSubMenu = scan.next().charAt(0);
                        }
                    } while (sesGoTo != '0' && Character.toLowerCase(backSesSubMenu) != 'n');
                    scan.nextLine();
                    break;
                case '0':
                    System.out.print("Bye ^^ ");
                    break;
                default:
                    System.err.print("Incorrect Input, Please try again.\n\n");
            }

        } while (Character.compare(selection, '0') != 0);

    }

}
