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
import entity.Rank;
import entity.Session;
import entity.Singer;
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

//        Loh Xin Yi - Member Maintainance
        SortedListInterface<Member> memberList = new SortedLinkedList<>();

        memberList.insert(new Member(1001, "Aurora", "A", "010-0000000", "Female", 100));
        memberList.insert(new Member(1002, "Bob", "B", "011-1111111", "Male", 700));
        memberList.insert(new Member(1003, "Cara", "C", "012-2222222", "Female", 300));
        memberList.insert(new Member(1004, "Daniel", "D", "013-3333333", "Male", 400));
        memberList.insert(new Member(1005, "Eva", "E", "014-4444444", "Female", 300));

//        Siah Xin Ying - Song Maintainance
        SiahxySortedListInterface<Song> songList = new SiahxySortedArrayList<>();
        SiahxySortedListInterface<Singer> singer1 = new SiahxySortedArrayList<>();
        singer1.add(new Singer("TAYLOR SWIFT"));
        singer1.add(new Singer("BON IVER"));

        SiahxySortedListInterface<Singer> singer2 = new SiahxySortedArrayList<>();
        singer2.add(new Singer("SELENA GOMEZ X BLACKPINK"));
        singer2.add(new Singer("BLACKPINK"));

        SiahxySortedListInterface<Singer> singer3 = new SiahxySortedArrayList<>();
        singer3.add(new Singer("24KGOLDN"));
        singer3.add(new Singer("24KGOLDN X JUSTIN"));
        singer3.add(new Singer("24KGOLDN X LIL GHOST"));

        SiahxySortedListInterface<Singer> singer4 = new SiahxySortedArrayList<>();
        singer4.add(new Singer("LUIS FONSI"));
        singer4.add(new Singer("LUIS FONSI X JUSTIN"));
        singer4.add(new Singer("J.FLA"));

        SiahxySortedListInterface<Singer> singer5 = new SiahxySortedArrayList<>();
        singer5.add(new Singer("LADY GAGA X BLACKPINK"));
        singer5.add(new Singer("BLACKPINK"));

        songList.add(new Song("EXILE", singer1));
        songList.add(new Song("ICE CREAM", singer2));
        songList.add(new Song("MOOD", singer3));
        songList.add(new Song("DESPACITO", singer4));
        songList.add(new Song("SOUR CANDY", singer5));

//        Koh Hui Hui - Karaoke Session
        StackInterface<Session> sessionList = new LinkedStack<>();
        StackInterface<Rank> rankList = new LinkedStack<>();
        StackInterface<Song> playlist = new LinkedStack<>();

        int playlistId = 1000;

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
//                Loh Xin Yi - Member Maintainance
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
                        System.out.println("6.Favourite Song List");
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

                                    if (memberList.found(memberfavouriteSongEntry)) {

                                        SiahxySortedListInterface<Song> favouriteSongList = new SiahxySortedArrayList<>();

                                        memberfavouriteSongEntry = memberList.getEntry(memberList.getPosition(memberfavouriteSongEntry));

                                        if (memberfavouriteSongEntry.getFavouriteSongList() != null) {
                                            favouriteSongList = memberfavouriteSongEntry.getFavouriteSongList();
                                        }

                                        System.out.println("\nFavourite Song List of " + memberfavouriteSongEntry.getFirstName() + " " + memberfavouriteSongEntry.getLastName());
                                        System.out.println("----------------------------------------------------------------");

                                        if (memberfavouriteSongEntry.getFavouriteSongList() == null) {
                                            System.out.println("No favourite song.");
                                        } else {
                                            System.out.print(memberfavouriteSongEntry.getFavouriteSongList());
                                            System.out.println("----------------------------------------------------------------");
                                            System.out.println("Total " + memberfavouriteSongEntry.getFavouriteSongList().getNumberOfSongs() + " Favourite Songs");
                                        }
                                        System.out.println("----------------------------------------------------------------");

                                        scan.nextLine();
                                        char fsChoice;
                                        do {
                                            System.out.println("\nOptions ");
                                            System.out.println("-------- ");
                                            System.out.println("1. Add Favourite Song ");
                                            System.out.println("2. Remove Favourite Song ");
                                            System.out.println("0. Cancel ");
                                            System.out.print("Enter choice: ");
                                            fsChoice = scan.nextLine().charAt(0);

                                            switch (fsChoice) {
                                                case '1':
                                                        try {
                                                    System.out.println("\nSong List: " + songList.getNumberOfSongs());
                                                    System.out.println("----------------------------------------------------------------------------------------");
                                                    System.out.println("NO. ID      Song               Singer ");
                                                    System.out.println("----------------------------------------------------------------------------------------");
                                                    System.out.print(songList);
                                                    System.out.println("----------------------------------------------------------------------------------------");

                                                    System.out.print("\nEnter ID to select song: ");
                                                    int favouriteSongID = scan.nextInt();
                                                    boolean found = false;
                                                    boolean existed = false;
                                                    for (int i = 1; i <= songList.getNumberOfSongs(); i++) {
                                                        if (songList.getEntry(i).getSongID() == favouriteSongID) {

                                                            if (favouriteSongList.isEmpty() == false) {
                                                                for (int j = 1; j <= favouriteSongList.getNumberOfSongs(); j++) {
                                                                    if (favouriteSongID == favouriteSongList.getEntry(j).getSongID()) {
                                                                        System.out.println("The song is existed in the favourite song list.\n");
                                                                        existed = true;
                                                                    }
                                                                }
                                                            }

                                                            if (!existed) {
                                                                favouriteSongList.add(songList.getEntry(i));
                                                                memberfavouriteSongEntry.setFavouriteSongList(favouriteSongList);
                                                                //memberfavouriteSongEntry.addFavouriteSong(songList.getEntry(i));
                                                                System.out.println("The song has added into favourite song list.\n");
                                                            }
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
                                                    System.out.println("\nFavourite Song List of " + memberfavouriteSongEntry.getFirstName() + " " + memberfavouriteSongEntry.getLastName());
                                                    System.out.println("----------------------------------------------------------------------------------------");
                                                    if (memberfavouriteSongEntry.getFavouriteSongList() == null) {
                                                        System.out.println("No favourite song.");
                                                    } else {
                                                        System.out.print(memberfavouriteSongEntry.getFavouriteSongList());
                                                        System.out.println("----------------------------------------------------------------------------------------");
                                                        System.out.println("Total " + memberfavouriteSongEntry.getFavouriteSongList().getNumberOfSongs() + " Favourite Songs");
                                                    }
                                                    System.out.println("----------------------------------------------------------------------------------------");

                                                    try {
                                                        System.out.print("\nEnter ID to select song: ");
                                                        int favouriteSongID = scan.nextInt();
                                                        boolean found = false;
                                                        for (int i = 1; i <= memberfavouriteSongEntry.getFavouriteSongList().getNumberOfSongs(); i++) {
                                                            if (memberfavouriteSongEntry.getFavouriteSongList().getEntry(i).getSongID() == favouriteSongID) {
                                                                memberfavouriteSongEntry.getFavouriteSongList().remove(i);
                                                                System.out.println("The favourite song has added removed.\n");
                                                                found = true;
                                                            }
                                                        }
                                                        if (!found) {
                                                            System.err.println("\n\nSong ID is not in the favourite song list.\n\n");
                                                        }
                                                    } catch (InputMismatchException a) {
                                                        System.err.println("Must enter numbers.");
                                                        scan.next();
                                                    }
                                                    scan.nextLine();
                                                    break;
                                                case '0':
                                                    System.err.print("Quit.\n");
                                                    break;
                                                default:
                                                    System.err.print("Invalid option.\n\n");
                                            }
                                        } while (Character.compare(fsChoice, '0') != 0);

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
//                Siah Xin Ying - Song Maintainance
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
                                System.out.println("----------------------------------------------------------------------------------------------");
                                System.out.println("NO. ID      Song               Singer ");
                                System.out.println("----------------------------------------------------------------------------------------------");
                                System.out.print(songList);
                                System.out.println("----------------------------------------------------------------------------------------------");

                                break;

                            case '2':

                                do {
                                    Song addSong = new Song();
                                    SiahxySortedListInterface<Singer> singerAdding = new SiahxySortedArrayList<>();
                                    Singer singerList = new Singer();
                                    String addSongName;
                                    String addSinger;
                                    int currID;
                                    char addSelection;

                                    System.out.println("\n\nAdd");
                                    System.out.println("-----------------");
                                    System.out.println("1. Add New Song");
                                    System.out.println("2. Add New Singer");
                                    System.out.print("Enter selection: ");
                                    addSelection = scan.next().charAt(0);
                                    scan.nextLine();

                                    switch (addSelection) {
                                        case '1':
                                            System.out.println("\n\nAdd New Song");
                                            System.out.println("-----------------");
                                            System.out.print("Enter New Song Name: ");
                                            addSongName = scan.nextLine().toUpperCase();

                                            System.out.print("Enter New Singer: ");
                                            addSinger = scan.nextLine().toUpperCase();

                                            addSong.setSongName(addSongName);

                                            singerAdding.add(new Singer(addSinger));
                                            songList.add(new Song(addSongName, singerAdding));
                                            System.out.println("Add Successfully.");
                                            break;

                                        case '2':
                                            System.out.println("\n\nAdd New Singer");
                                            System.out.println("-----------------");
                                            System.out.print("Enter Song Name: ");
                                            addSongName = scan.nextLine().toUpperCase();
                                            addSong.setSongName(addSongName);

                                            if (songList.contains(addSong)) {
                                                currID = songList.getEntry(songList.getPosition(addSong)).getSongID();
                                                addSong.setSongID(currID);
                                                System.out.print("Enter New Singer: ");
                                                addSinger = scan.nextLine().toUpperCase();

                                                singerAdding = songList.getEntry(songList.getPosition(addSong)).getSinger();

                                                singerList.setSinger(addSinger);
                                                singerAdding.add(singerList);
                                                addSong.addSinger(singerList);
                                                System.out.println("Add Successfully.");

                                            } else {
                                                System.err.println("The Singer Doesn't Exist.");
                                            }

                                            break;

                                        default:
                                            System.out.print("Quit...");
                                    }

                                    do {
                                        System.out.print("Do you want to add more? [y/n]: ");
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
                                    SiahxySortedListInterface<Singer> singerUpdate = new SiahxySortedArrayList<>();
                                    Singer singerUpdating = new Singer();
                                    int currID = 0;
                                    String currSongName = "";
                                    String currSinger = "";
                                    char updateSelection;
                                    System.out.println("\n\nUpdate Song");
                                    System.out.println("-----------------");
                                    System.out.print("Enter Song Name To Update: ");
                                    String songName = scan.nextLine().toUpperCase();
                                    updateSong.setSongName(songName);

                                    if (songList.contains(updateSong)) {

                                        updateSong = songList.getEntry(songList.getPosition(updateSong));

                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        System.out.print(updateSong);
                                        System.out.println("----------------------------------------------------------------------------------------------");

                                        System.out.println("1. Update Song Name");
                                        System.out.println("2. Update Singer");
                                        System.out.print("Enter selection: ");
                                        updateSelection = scan.next().charAt(0);

                                        scan.nextLine();

                                        switch (updateSelection) {
                                            case '1':
                                                System.out.print("Enter New Song Name: ");
                                                String replaceName = scan.nextLine().toUpperCase();
                                                updateSong.setSongName(replaceName);

                                                currID = updateSong.getSongID();
                                                updateSong.setSongID(currID);

                                                currSinger = singerUpdating.getSinger();
                                                singerUpdating.setSinger(currSinger);
                                                songList.replace(songList.getPosition(updateSong), updateSong);

                                                break;
//
                                            case '2':
                                                System.out.print("Enter Singer To Update: ");
                                                String replaceSinger = scan.nextLine().toUpperCase();
                                                singerUpdating.setSinger(replaceSinger);
                                                singerUpdate = songList.getEntry(songList.getPosition(updateSong)).getSinger();

                                                if (singerUpdate.contains(singerUpdating)) {

                                                    int position = singerUpdate.getPosition(singerUpdating);
                                                    System.out.print("Enter New Singer: ");
                                                    String newSinger = scan.nextLine().toUpperCase();
                                                    singerUpdating.setSinger(newSinger);

                                                    currID = updateSong.getSongID();
                                                    updateSong.setSongID(currID);

                                                    currSongName = updateSong.getSongName();
                                                    updateSong.setSongName(currSongName);

                                                    singerUpdate.replace(position, singerUpdating);
                                                    updateSong.setSinger(singerUpdate);
                                                    songList.replace(songList.getPosition(updateSong), updateSong);

                                                } else {
                                                    System.err.println("The Singer Doesn't Exist.");
                                                }
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
                                    SiahxySortedListInterface<Singer> Singer = new SiahxySortedArrayList<>();
                                    Singer removeSinger = new Singer();
                                    String songName;
                                    String singer;
                                    char removeSelection;

                                    System.out.println("\n\nRemove");
                                    System.out.println("-----------------");
                                    System.out.println("1. Remove Song");
                                    System.out.println("2. Remove Singer");
                                    System.out.print("Enter selection: ");
                                    removeSelection = scan.next().charAt(0);
                                    scan.nextLine();
                                    switch (removeSelection) {
                                        case '1':
                                            System.out.println("\n\nRemove Song");
                                            System.out.println("-----------------");
                                            System.out.print("Enter Song Name: ");
                                            songName = scan.nextLine().toUpperCase();

                                            removeSong.setSongName(songName);

                                            if (songList.contains(removeSong)) {

                                                removeSong = songList.getEntry(songList.getPosition(removeSong));
                                                System.out.println("----------------------------------------------------------------------------------------------");
                                                System.out.print(removeSong);
                                                System.out.println("----------------------------------------------------------------------------------------------");
                                                System.out.println("Delete Successfully.");
                                                songList.remove(songList.getPosition(removeSong));
                                            } else {
                                                System.err.println("The Song Doesn't Exist.");
                                            }
                                            break;

                                        case '2':
                                            System.out.println("\n\nRemove Singer");
                                            System.out.println("-----------------");
                                            System.out.print("Enter Song Name: ");
                                            songName = scan.nextLine().toUpperCase();

                                            removeSong.setSongName(songName);

                                            if (songList.contains(removeSong)) {

                                                removeSong = songList.getEntry(songList.getPosition(removeSong));
                                                System.out.print(removeSong);

                                                System.out.print("Enter Singer: ");
                                                singer = scan.nextLine().toUpperCase();

                                                removeSinger.setSinger(singer);
                                                Singer = songList.getEntry(songList.getPosition(removeSong)).getSinger();

                                                if (Singer.contains(removeSinger)) {

                                                    removeSinger = Singer.getEntry(Singer.getPosition(removeSinger));

                                                    System.out.print(removeSinger);
                                                    System.out.println("\n----------------------------------------------------------------------------------------------");
                                                    System.out.print(removeSong);
                                                    System.out.println("----------------------------------------------------------------------------------------------");
                                                    System.out.println("Delete Successfully.");
                                                    Singer.remove(Singer.getPosition(removeSinger));

                                                    removeSong.setSinger(Singer);
                                                    songList.replace(songList.getPosition(removeSong), removeSong);
                                                } else {
                                                    System.out.println("The Singer Doesn't Exist.");
                                                }
                                            } else {
                                                System.err.println("The Song Doesn't Exist.");
                                            }
                                            break;

                                        default:
                                            System.out.print("Quit...");
                                    }

                                    do {
                                        System.out.print("Do you want to remove more? [y/n]: ");
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

                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        System.out.print(searchSong);
                                        System.out.println("----------------------------------------------------------------------------------------------");
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
//                Koh Hui Hui - Karaoke Session
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
                        System.out.println("\n====================\nKaraoke Session\n====================");
                        System.out.println("1.Add Song to Playlist");
                        System.out.println("2.Start Singing");
                        System.out.println("3.Playlist");
                        System.out.println("4.Generate Reports");
                        System.out.println("0.Back to Main Menu");
                        System.out.println("====================");
                        System.out.print("Enter choice: ");
                        sesGoTo = scan.next().charAt(0);

                        switch (sesGoTo) {
//_______________________________________________________________________________________Add Song To Playlist
                            case '1':
//------------Add Song
                                int addId,
                                 selectSinger;
                                char addMore;

                                System.out.println("\nADD SONG TO PLAYLIST");

                                do {
                                    boolean found = false;

                                    try {
                                        SiahxySortedListInterface<Singer> version = new SiahxySortedArrayList<>();
                                        System.out.println("\nSong List: " + songList.getNumberOfSongs());
                                        System.out.println("----------------------------------------------------------------------------------------");
                                        System.out.println("NO. ID      Song               Singer ");
                                        System.out.println("----------------------------------------------------------------------------------------");
                                        System.out.print(songList);
                                        System.out.println("----------------------------------------------------------------------------------------");

                                        System.out.print("\nEnter ID to add song: ");
                                        addId = scan.nextInt();
//------------add if id exists
                                        for (int i = 1; i <= songList.getNumberOfSongs(); i++) {
                                            if (songList.getEntry(i).getSongID() == addId) {
                                                do {
                                                    System.out.print("\n" + songList.getEntry(i).getSinger());
                                                    System.out.print("\nEnter the number(singer) that you want: ");
                                                    selectSinger = scan.nextInt();
                                                    if (selectSinger > songList.getEntry(i).getSinger().getNumberOfSongs()) {
                                                        System.out.print("\nInvalid input. \nPlease choose an option from the list. \n\n");
                                                    }
                                                } while (selectSinger > songList.getEntry(i).getSinger().getNumberOfSongs());
                                                version.add(new Singer(songList.getEntry(i).getSinger().getEntry(selectSinger).getSinger()));
                                                playlist.push(new Song(playlistId));
                                                playlist.peek().setSongName(songList.getEntry(i).getSongName());
                                                playlist.peek().setSinger(version);
                                                System.out.println("\n" + songList.getEntry(i).getSongName() + " was added to Playlist.");
                                                System.out.println(songList.getEntry(i).getSinger().getEntry(selectSinger).getSinger() + "'s version was chosen.\n");
                                                found = true;
                                            }
                                        }
                                        if (!found) {
                                            System.out.println("\nSong ID does not exist.\n");
                                        }
                                    } catch (InputMismatchException a) {
                                        System.err.println("\nPlease enter numeric input.\n");
                                        System.err.println("\nSong was not added.\n");
                                        scan.next();
                                    }
//------------add more songs
                                    playlistId++;

                                    do {
                                        System.out.print("Do you want to continue? (y/n) ");
                                        addMore = scan.next().charAt(0);
                                        if (Character.toLowerCase(addMore) != 'y' && Character.toLowerCase(addMore) != 'n') {
                                            System.out.println("\nInvalid input. \nPlease try again.\n");
                                        }
                                    } while (Character.toLowerCase(addMore) != 'y' && Character.toLowerCase(addMore) != 'n');

                                } while (Character.toLowerCase(addMore) == 'y');
                                break;
//_______________________________________________________________________________________Start Singing
                            case '2':
                                char playlistOption = '0';

                                System.out.println("\nLET'S START SINGING");
//------------Display Now Playing and Next Song
//------------In karaoke, usually it plays the newest added song
                                if (playlist.isEmpty()) {
                                    System.out.println("\nThe playlist is currently empty,\nplease add more songs to the playlist to continue.");
                                } else if (playlist.size() == 1) {
                                    System.out.println("\nNow Playing: \n" + playlist.peek().getSongName() + " by " + playlist.peek().getSinger());
                                } else if (playlist.size() > 1) {
//------------Next song is displayed using peekNext()
                                    System.out.println("\nNow Playing: \n" + playlist.peek().getSongName() + " by " + playlist.peek().getSinger());
                                    System.out.println("\nNext Song: \n" + playlist.peekNext().getSongName() + " by " + playlist.peekNext().getSinger());
                                }
                                do {
                                    if (!(playlist.isEmpty())) {
                                        do {
                                            System.out.println("\n(1) Next Song\n(2)Rate Song\n(0) Exit");
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
                                            if (playlist.size() == 1) {
                                                System.out.println("\nNow Playing: \n" + playlist.peek().getSongName() + " by " + playlist.peek().getSinger());
                                                System.out.println("\nThe playlist now has only 1 song, \nif you want to add more songs, please proceed to sub-menu to do so.");
                                            } else if (playlist.size() > 1) {
                                                playlist.pop();
                                                System.out.println("\nNow Playing: \n" + playlist.peek().getSongName() + " by " + playlist.peek().getSinger());
                                                if (playlist.size() > 1) {
                                                    System.out.println("\nNext Song: \n" + playlist.peekNext().getSongName() + " by " + playlist.peekNext().getSinger());
                                                }
                                            }
                                            break;
                                        case '2':
//------------rate song
                                            int i;
                                            int j;
                                            int songRate;
                                            String starRate = null;
                                            Song newRate = new Song();
                                            boolean replaceRate = false;
                                            SiahxySortedListInterface ratedSong = new SiahxySortedArrayList();
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
                                                songRate = scan.nextInt();
                                                switch (songRate) {
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
                                                for (int n = 1; n <= rankList.size(); n++) {
                                                    if (rankList.getEach(n).getRatedSong().contains(playlist.peek())) {
//------------If there are same songs, it will take the newest rate
                                                        if (rankList.getEach(n).getRatedSong().getEntry(0).getSongID() == playlist.peek().getSongID()) {
                                                            rankList.getEach(n).setStarRate(starRate);
                                                        }
                                                        System.out.print("\nSong is rated as " + starRate + "\n");
                                                        replaceRate = true;
                                                    }
                                                }
//------------If there are NO same songs, it will push the rated song to rank list
                                                if (!(replaceRate)) {
                                                    ratedSong.add(new Song(playlist.peek().getSongName(), playlist.peek().getSinger()));
                                                    rankList.push(new Rank(ratedSong, starRate));
                                                    System.out.print("\nSong is rated as " + starRate + "\n");
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
//_______________________________________________________________________________________Playlist

                            case '3':
//------------display the playlist
                                char editPlaylist = '0';
                                char confirmClear;

                                do {
                                    if (!playlist.isEmpty()) {
                                        System.out.println("\nPLAYLIST\n");
                                        System.out.println(playlist.size() + " songs");
                                        System.out.println("-------------------------------------------------------------");
                                        System.out.println("#   ID      Title             Artist ");
                                        System.out.println("-------------------------------------------------------------");
                                        for (int i = 1; i <= playlist.size(); i++) {
                                            System.out.print(i);
                                            System.out.print(playlist.getEach(i));
                                        }
                                        do {
                                            System.out.println("\n(1) - Duplicate Song\n(2) - Clear Playlist\n(0) - Exit");
                                            System.out.print("Enter choice: ");
                                            editPlaylist = scan.next().charAt(0);
                                            if (editPlaylist != '1' && editPlaylist != '2' && editPlaylist != '0') {
                                                System.out.println("\nInvalid input. \nPlease choose an option from the list.\n");
                                            }
                                        } while (editPlaylist != '1' && editPlaylist != '2' && editPlaylist != '0');
                                    } else {
                                        System.out.println("\nYour playlist is currently empty.\n\nIf you want to add song to your playlist,\nplease proceed to sub-menu to do so.");
                                        editPlaylist = '0';
                                    }
                                    switch (editPlaylist) {
                                        case '1':
//------------duplicate song
                                            boolean found = false;
                                            int dupId;
                                            int count = 0;

                                            System.out.println("\nDUPLICATE SONG\n");
                                            try {
                                                System.out.print("Enter ID to duplicate song: ");
                                                dupId = scan.nextInt();

//                                                for (int i = 1; i <= playlist.getNumberOfSongs(); i++) {
//                                                    if (playlist.getEntry(i).getSongID() == dupId && found == false) {
//                                                        playlist.add(playlist.getEntry(i));
//                                                        System.out.println("\n" + playlist.getEntry(i).getSongName() + " was duplicated.");
//                                                        found = true;
//                                                    }
//                                                }
                                                if (!found) {
                                                    System.out.println("\nSong ID does not exist.\n");
                                                }
                                            } catch (InputMismatchException a) {
                                                System.err.println("\nPlease enter numeric input.\n");
                                                System.err.println("\nSong was not duplicated.\n");
                                                scan.next();
                                            }
                                            break;
                                        case '2':
//------------clear playlist
                                            System.out.println("\nCLEAR PLAYLIST\n");

                                            System.out.print("Are you sure? (Y to proceed): ");
                                            confirmClear = scan.next().charAt(0);
                                            if (Character.toLowerCase(confirmClear) == 'y') {
                                                playlist.clear();
                                                System.out.println("\nYour playlist is empty now.\n\nIf you want to add song to your playlist,\nplease proceed to sub-menu to do so.");
                                            }
                                            break;
                                        case '0':
                                            break;
                                    }
                                } while (editPlaylist == '1' || editPlaylist == '2');
                                break;
//_______________________________________________________________________________________Generate Report
                            case '4':
                                String reportDate,
                                 reportTime,
                                 reportTitle;
//------------show song rank in the report based on the star rates
                                System.out.println("\nREPORT");
                                if (!(rankList.isEmpty())) {
//                                    Calendar cal = Calendar.getInstance();
//                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
//                                    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
//                                    reportDate = dateFormat.format(cal.getTime());
//                                    reportTime = timeFormat.format(cal.getTime());
                                    reportTitle = "Song Rank";
                                    System.out.println("---------------------------------------------------------------------------------------");
//                                    System.out.println("\nReport Date: " + reportDate
//                                            + "\t\t" + "Report Time: " + reportTime + "\t\t" + "Report Title: " + reportTitle);
                                    System.out.println("---------------------------------------------------------------------------------------");
                                    for (int i = 1; i <= rankList.size(); i++) {
                                        switch (rankList.getEach(i).getSessionRate()) {
                                            case 5:
                                                System.out.println("\nSongs rated as " + fiveStar + ":");
                                                System.out.println("----------------------------------------------------------------");
                                                System.out.print(rankList.getEach(i));
                                                System.out.println("----------------------------------------------------------------");
                                                break;
                                            case 4:
                                                System.out.println("\nSongs rated as " + fourStar + ":");
                                                System.out.println("----------------------------------------------------------------");
                                                System.out.print(rankList.getEach(i));
                                                System.out.println("----------------------------------------------------------------");
                                                break;
                                            case 3:
                                                System.out.println("\nSongs rated as " + threeStar + ":");
                                                System.out.println("----------------------------------------------------------------");
                                                System.out.print(rankList.getEach(i));
                                                System.out.println("----------------------------------------------------------------");
                                                break;
                                            case 2:
                                                System.out.println("\nSongs rated as " + twoStar + ":");
                                                System.out.println("----------------------------------------------------------------");
                                                System.out.print(rankList.getEach(i));
                                                System.out.println("----------------------------------------------------------------");
                                                break;
                                            case 1:
                                                System.out.println("\nSongs rated as " + oneStar + ":");
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

                        if ((sesGoTo != '0') && sesGoTo == '1' || sesGoTo == '2' || sesGoTo == '3' || sesGoTo == '4') {
                            System.out.print("\nY - Sub-Menu | N - Main Menu: ");
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
