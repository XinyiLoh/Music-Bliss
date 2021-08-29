/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.SiahxySortedArrayList;
import adt.SiahxySortedListInterface;
import adt.SortedLinkedList;
import adt.SortedListInterface;
import entity.Member;
import entity.Song;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Loh Xin Yi
 */
public class MusicBliss {

    public static void main(String[] args) {

        SortedListInterface<Member> memberList = new SortedLinkedList<>();

        memberList.insert(new Member(1001, "Aurora", "A", "010-0000000", "Female", 100));
        memberList.insert(new Member(1002, "Bob", "B", "011-1111111", "Male", 700));
        memberList.insert(new Member(1003, "Cara", "C", "012-2222222", "Female", 300));
        memberList.insert(new Member(1004, "Daniel", "D", "013-3333333", "Male", 400));
        memberList.insert(new Member(1005, "Eva", "E", "014-4444444", "Female", 300));

        SiahxySortedListInterface<Song> songList = new SiahxySortedArrayList<>();

        songList.add(new Song("STAY", "THE KID LAROI"));
        songList.add(new Song("GONE", "ROSIE"));
        songList.add(new Song("MOOD", "24KGOLDIN"));
        songList.add(new Song("ATTENTION", "CHARLIE PUTH"));
        songList.add(new Song("REALLY REALLY", "WINNER"));

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

//                                boolean trueID = false;
//                                int id = 0;
//                                while(!trueID){
//                                    System.out.print("Please Enter ID: ");
//                                    try {
//                                            id = scan.nextInt();
//                                            scan.nextLine();
//                                            trueID = true;
//                                    } catch (InputMismatchException a) {
//                                        System.err.println("Must enter numbers only.");
//                                        scan.next();
//                                    }
//                                }
                                
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
                                        for(int i = 1; i <= memberList.totalEntries(); i++){
                                            if(memberList.getEntry(i).equals(equalsPhone)){
                                                pass = false;
                                                System.err.print("Phone Number already existed.\n");
                                                break;
                                            }
                                        }
                                        
                                        if(pass){ 
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

                                Member newMember = new Member(id, extractFname, extractLname, pnum, gender, rw);

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
                                                            for(int i = 1; i <= memberList.totalEntries(); i++){
                                                                if(memberList.getEntry(i).equals(equalsPhone)){
                                                                    pass = false;
                                                                    System.err.print("Phone Number already existed.\n");
                                                                    break;
                                                                }
                                                            }

                                                            if(pass){ 
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
                                                                    if(!updateEntry.minusRewardPoints(rp)){
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
                                    
                                    if(search == 1){
                                        System.out.print("Enter Member ID: ");
                                        int searchID = scan.nextInt();
                                        searchEntryID.setiD(searchID);
                                    }else if(search == 2){
                                        scan.nextLine();
                                        System.out.print("Enter Member Mobile: ");
                                        String searchPhone = scan.nextLine();
                                        searchPhone = searchPhone.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
                                        searchEntryPhone.setMobile(searchPhone);
                                    }else{
                                        System.err.print("Invalid option.\n");
                                    }
                                    
                                    boolean finding = false;
                                    for(int i = 1; i <= memberList.totalEntries(); i++){
                                        
                                        if (memberList.found(searchEntryID) || memberList.getEntry(i).equals(searchEntryPhone)) {
                                            searchEntryID = memberList.getEntry(memberList.getPosition(searchEntryID));
                                            searchEntryPhone = memberList.getEntry(i);
                                            System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                            if(searchEntryID != null){
                                                System.out.print(searchEntryID);
                                            }else{
                                                System.out.print(searchEntryPhone);
                                            }
                                            System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
                                            finding = true;
                                            break;
                                        }
                                        
                                    }

                                    if(!finding && (search == 1 || search == 2)){
                                        System.err.println("Member not found.\n");
                                        break;
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
                    System.out.print("Session Schedule");
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
