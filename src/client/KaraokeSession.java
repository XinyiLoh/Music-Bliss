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
        StackInterface<Session> rankList = new LinkedStack<>();
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
            String oneStar = "One-Star (Poor)";
            String twoStar = "Two-Star (Fair)";
            String threeStar = "Three-Star (Good)";
            String fourStar = "Four-Star (Excellent)";
            String fiveStar = "Five-Star (Superior)";

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
                                    sessionList.peek().setStreamTimes();
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
                    if (sessionList.isEmpty()) {
                        System.out.println("\nThe playlist is currently empty,\nplease add more songs to the playlist to continue.");
                    } else if (sessionList.size() == 1) {
                        System.out.println("\nNow Playing: \n" + sessionList.peek().getSessionName() + " by " + sessionList.peek().getSessionSinger());
                    } else if (sessionList.size() > 1) {
                        System.out.println("\nNow Playing: \n" + sessionList.peek().getSessionName() + " by " + sessionList.peek().getSessionSinger());
                        System.out.println("\nNext Song: \n" + sessionList.peekNext().getSessionName() + " by " + sessionList.peekNext().getSessionSinger());
                    }

                    do {
                        if (sessionList.size() >= 1) {
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
                                int i;
                                int j;
                                int curSongRate = 0;
                                String starRate = null;

                                System.out.println("\nRate Song\n");
                                System.out.println("Star\t    Classification\n--------------------------");
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
//                                Problem:Same song is rated differently
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
                                        if (rankList.find(sessionList.peek())) { //if the current song is rated already
                                            for (int n = 1; n <= rankList.size(); n++) {
                                                if (rankList.getEach(n).getSessionID() == sessionList.peek().getSessionID()) {
                                                    rankList.getEach(n).setSessionRate(curSongRate);    //the new rate will be replaced
                                                    System.out.print("\nSong is rated as " + starRate);
                                                }
                                            }
                                        } else {
                                            sessionList.peek().setSessionRate(curSongRate);
                                            rankList.push(sessionList.peek());
                                            System.out.print("\nSong is rated as " + starRate);
                                        }
//                                        System.out.println(rankList.getAll());
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
                    char clearPlaylist = '0';
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
                                System.out.println("\nInvalid input. \nPlease choose an option from the list.\n");
                            }
                        } while (clearPlaylist != '1' && clearPlaylist != '0');
                    } else {
                        System.out.println("\nYour playlist is currently empty.\n\nIf you want to add song to your playlist,\nplease proceed to sub-menu to do so.");
                    }
                    if (clearPlaylist == '1') {
                        System.out.print("Are you sure? (Y to proceed): ");
                        confirmClear = scan.next().charAt(0);
                        if (Character.toLowerCase(confirmClear) == 'y') {
                            sessionList.clear();
                            System.out.println("\nYour playlist is empty now.\n\nIf you want to add song to your playlist,\nplease proceed to sub-menu to do so.");
                        }
                    }
                    break;
                case '4':
                    char viewReport;
                    System.out.println("\n\t\tREPORTS");
                    do {
                        System.out.println("\n1. Your most streamed songs");
                        System.out.println("2. The rated songs");
                        System.out.println("0. Exit");
                        System.out.print("\nEnter choice: ");
                        viewReport = scan.next().charAt(0);
                        switch (viewReport) {
                            case '1':
                                break;
                            case '2':
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
                                System.out.print("\nInvalid input. \nPlease choose an option from the list.\n");
                                break;
                        }
                    } while (viewReport != '0');
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
    }
}
