/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.SortedLinkedList;
import adt.SortedListInterface;
import entity.Member;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Loh Xin Yi
 */
public class MemberMaintenance {

    public static void main(String[] args) {
        
        SortedListInterface<Member> memberList = new SortedLinkedList<>();
        
        memberList.insert(new Member(1001,"Aurora", "A", "010-0000000", "Female", 100));
        memberList.insert(new Member(1002,"Bob", "B", "011-1111111", "Male", 700));
        memberList.insert(new Member(1003,"Cara", "C", "012-2222222", "Female", 300));
        memberList.insert(new Member(1004,"Daniel", "D", "013-3333333", "Male", 400));
        memberList.insert(new Member(1005,"Eva", "E", "014-4444444", "Female", 300));
         
        System.out.println("memberList: \n" + memberList);
        
        Scanner scan = new Scanner(System.in);
        char selection;
        
        do{

            System.out.println("\n\n𝓜𝓾𝓼𝓲𝓬 𝓑𝓵𝓲𝓼𝓼      ");
            System.out.println("_________________________________");
            System.out.println("            Main Menu            "); 
            System.out.println("_________________________________");
            System.out.println("1.      Member Maintenance");
            System.out.println("2.      Song Maintenance");
            System.out.println("3.      Session Schedule");
            System.out.println("0.      Exit");
            System.out.println("_________________________________");
            
            System.out.print("Enter choice: ");
            selection = scan.nextLine().charAt(0);
            
            switch(selection){
                case '1':
                    char option;
                    
                    do{
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
                        
                        switch(option){
                            case '1':
                                System.out.println("\n\nMember List");
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                System.out.println("     ID   First Name    Last name          Mobile     Gender                 Join Date     Reward Points");
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                System.out.print(memberList);
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                break;
                                
                            case '2':
                                break;
                                
                            case '3':
                                
                                int updateID;
                                Member updateEntry = new Member();
                                System.out.print("Enter Member ID : ");
                                
                                try {
                                    
                                    updateID = scan.nextInt();
                                    updateEntry.setiD(updateID);
                                    
                                    if(memberList.found(updateEntry)){
                                        
                                    }else{
                                        System.out.println("Member ID not found.");
                                    }

                                } catch (InputMismatchException a) {
                                    System.out.println("Must enter numbers.");
                                    scan.next();
                                }
                                
                                break;
                                
                            case '4':
                                
                                int removeID;
                                Member removeEntry = new Member();
                                System.out.print("Enter Member ID : ");
                                
                                try {
                                    removeID = scan.nextInt();
                                    removeEntry.setiD(removeID);
                                    
                                    if(memberList.found(removeEntry)){
                                        if(memberList.delete(removeEntry)){
                                            System.out.println("Delete Successfully.");
                                        }else{
                                            System.err.println("Delete Failed.");
                                        }
                                    }else{
                                        System.err.println("Member ID not found.");
                                    }

                                } catch (InputMismatchException a) {
                                    System.err.println("Must enter numbers.");
                                }
                                scan.nextLine();
                                break;
                                
                            case '0':
                                break;
                            default:
                                System.out.print("Incorrect Input, Please try again.\n\n");
                        }
                        
                    }while(Character.compare(option,'0') != 0);
                    
                    break;
                case '2':
                    System.out.print("Song Maintenance");
                    break;
                case '3':
                    System.out.print("Session Schedule");
                    break;
                case '0':
                    System.out.print("Bye ^^ ");
                default:
                    System.out.print("Incorrect Input, Please try again.\n\n");
            }
        
        }while(Character.compare(selection,'0') != 0);

     }
    
}
