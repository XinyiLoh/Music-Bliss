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
public class MemberMaintenance {

    public static void main(String[] args) {

        SortedListInterface<Member> memberList = new SortedLinkedList<>();

        memberList.insert(new Member(1001, "Aurora", "A", "010-0000000", "Female", 100));
        memberList.insert(new Member(1002, "Bob", "B", "011-1111111", "Male", 700));
        memberList.insert(new Member(1003, "Cara", "C", "012-2222222", "Female", 300));
        memberList.insert(new Member(1004, "Daniel", "D", "013-3333333", "Male", 400));
        memberList.insert(new Member(1005, "Eva", "E", "014-4444444", "Female", 300));

        System.out.println("memberList: \n" + memberList);

        SiahxySortedListInterface<Song> songList = new SiahxySortedArrayList<Song>();

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
                        System.out.println("0.Back to Main Menu");
                        System.out.println("====================");
                        System.out.print("Enter choice: ");
                        option = scan.nextLine().charAt(0);

                        switch (option) {
                            case '1':
                                System.out.println("\n\nMember List");
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                System.out.println("     ID   First Name    Last name          Mobile     Gender                 Join Date     Reward Points");
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                System.out.print(memberList);
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                break;

                            case '2':

                                System.out.println("\n\nAdd Member");
                                System.out.println("---------------");

                                //Manually key in ID
                                //System.out.print("Please Enter ID: ");
                                //int id = scan.nextInt();
                                //scan.nextLine();
                                int id = memberList.getEntry(memberList.totalEntries()).getiD() + 1;

                                System.out.print("Please Enter First Name: ");
                                String fname = scan.nextLine();
                                String extractFname = fname.replaceAll("[^A-Za-z]+", "");

                                System.out.print("Please Enter Last Name: ");
                                String lname = scan.nextLine();
                                String extractLname = lname.replaceAll("[^A-Za-z]+", "");

                                boolean phone = false;
                                String pnum = "0";

                                while (!phone) {
                                    System.out.print("Please Enter Phone Number: ");
                                    pnum = scan.nextLine();

                                    if (Pattern.matches("\\d{10}", pnum)) {
                                        pnum = pnum.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
                                        phone = true;
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
                                                    String updatePnum = "0";

                                                    while (!updatePhone) {
                                                        System.out.print("Please Enter Phone Number: ");
                                                        updatePnum = scan.nextLine();

                                                        if (Pattern.matches("\\d{10}", updatePnum)) {
                                                            updatePnum = updatePnum.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
                                                            updateEntry.setMobile(updatePnum);
                                                            updatePhone = true;
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
                                                        System.out.print("Please Enter Reward Points: ");
                                                        try {
                                                            rp = scan.nextInt();
                                                            updateEntry.setRewardPoints(rp);
                                                            rewardP = true;
                                                        } catch (InputMismatchException a) {
                                                            System.err.println("Must enter numbers.");
                                                            scan.next();
                                                        }
                                                    }
                                                    System.out.print("Update Successfully.\n");
                                                    break;
                                                case '0':
                                                    System.err.print("Update Cancel.");
                                                    break;
                                                default:
                                                    System.err.print("Incorrect Input, Please try again.\n\n");
                                            }

                                            memberList.delete(updateEntry);
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

                            case '0':
                                break;
                            default:
                                System.err.print("Incorrect Input, Please try again.\n\n");
                        }

                    } while (Character.compare(option, '0') != 0);

                    break;
                case '2':
//                    int songSelection = 0;
//                    do {
//
//                        System.out.println("\n\n====================");
//                        System.out.println("Song Maintenance");
//                        System.out.println("====================");
//                        System.out.println("1. Song List ");
//                        System.out.println("2. Add Song ");
//                        System.out.println("3. Update Song ");
//                        System.out.println("4. Remove Song ");
//                        System.out.println("5. Search");
//                        System.out.println("0. Back to Main Menu");
//                        System.out.println("====================");
//                        System.out.print("Enter choice: ");
//
//                        songSelection = scan.nextInt();
//                        scan.next();
//
//                    } while (songSelection != 1 && songSelection != 2 && songSelection != 3 && songSelection != 4 && songSelection != 5);
//
//                    switch (songSelection) {
//                        case 1: {
//
//                            System.out.println("\nSong List: " + songList.getNumberOfSongs());
//                            System.out.println("------------------------------------------------------");
//                            System.out.println("NO.  ID     Song            Singer ");
//                            System.out.println("------------------------------------------------------");
//                            System.out.print(songList);
//                            System.out.println("------------------------------------------------------");
//
//                            break;
//                        }
//                    }
//                    break;
                case '3':
                    System.out.print("Session Schedule");
                    break;
                case '0':
                    System.out.print("Bye ^^ ");
                default:
                    System.err.print("Incorrect Input, Please try again.\n\n");
            }

        } while (Character.compare(selection, '0') != 0);

    }

}
