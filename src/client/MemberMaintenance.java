/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.SortedLinkedList;
import adt.SortedListInterface;
import entity.Member;

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
        
        System.out.println("=======================================");
        System.out.println("|                                      |");
        System.out.println("|             JY Hospital              |");
        System.out.println("|                                      |");
        System.out.println("|              MAIN MENU               |");
        System.out.println("|          1. Patient Menu             |");
        System.out.println("|          2. Doctor Menu              |");
        System.out.println("|          3. Doctor Duty Menu         |");
        System.out.println("|          4. Exit                     |");
        System.out.println("|                                      |");
        System.out.println("=======================================");
        System.out.print("Enter Your Selection: ");
        choose = input.nextLine().charAt(0);
        

     }
    
}
