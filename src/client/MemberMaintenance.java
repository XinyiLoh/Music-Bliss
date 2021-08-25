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
        
        memberList.insert(new Member("Ja", "Tan", "010-1111111", "Male", 100));
        memberList.insert(new Member("J", "n", "010-1111111", "Male", 700));
        memberList.insert(new Member("k", "Tn", "010-1111111", "Male", 300));
        memberList.insert(new Member("ck", "T", "010-1111111", "Male", 400));
         
        System.out.println("memberList: \n" + memberList);
         
     }
    
}
