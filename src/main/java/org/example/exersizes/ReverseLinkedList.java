package org.example.exersizes;


import lombok.extern.slf4j.Slf4j;
import org.example.model.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
@Slf4j
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

    public ListNode reverseListRecursive(ListNode head) {
        return reverseList(head,null);
       //return head;
    }

    private ListNode reverseList(ListNode head,ListNode previous) {
        if(head==null) {
            return previous;
        }

        ListNode nextTemp = head.next;
        head.next = previous;
        previous=head;
        return reverseList(nextTemp,previous);
    }


}
