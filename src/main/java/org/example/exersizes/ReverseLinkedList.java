package org.example.exersizes;


import org.example.model.ListNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (head !=null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }

        return prev;
    }

}
