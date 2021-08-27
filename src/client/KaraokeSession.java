/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.LinkedStack;
import adt.StackInterface;
import entity.Session;
import java.util.Scanner;

/**
 *
 * @author Koh Hui Hui
 */
public class KaraokeSession {

    public static void main(String[] args) {

        StackInterface<Session> sessionList = new LinkedStack<Session>();
        Scanner scan = new Scanner(System.in);
        char sesSelection;
        char sesSubMenu = 'n';

        do {
            System.out.println("\nKaraoke Session");
            System.out.println("----------------");
            System.out.println("1.Select Song into Playlist");
            System.out.println("2.Remove Song from Playlist");
            System.out.println("3.Start Session");
            System.out.println("4.Show Playlist");
            System.out.println("5.Vote for Participants");
            System.out.println("6.Generate reports");
            System.out.println("0.Back to Main Menu");
            System.out.print("\nEnter choice: ");
            sesSelection = scan.nextLine().charAt(0);

            switch (sesSelection) {
                case '1':
                    System.out.print("\nSelect Song into Playlist \n\n");
                    break;
                case '2':
                    System.out.print("\nRemove Song from Playlist \n\n");
                    break;
                case '3':
                    System.out.print("\nLet's Start Singing \n\n");
                    break;
                case '4':
                    System.out.print("\nPlaylist \n\n");
                    break;
                case '5':
                    System.out.print("\nVote for Participants \n\n");
                    break;
                case '6':
                    System.out.print("\nReports \n\n");
                    break;
                case '0':
                    break;
                default:
                    sesSubMenu = 'y';
                    System.out.print("\nInvalid input. \nPlease choose an option from the list. \n\n");
            }

            if ((sesSelection != '0') && sesSelection == '1' || sesSelection == '2' || sesSelection == '3' || sesSelection == '4' || sesSelection == '5' || sesSelection == '6') {
                System.out.print("Back to Karaoke Session sub-menu (N to exit): ");
                sesSubMenu = scan.nextLine().charAt(0);
            }
        } while (sesSelection != '0' && Character.toLowerCase(sesSubMenu) != 'n');
    }
}
