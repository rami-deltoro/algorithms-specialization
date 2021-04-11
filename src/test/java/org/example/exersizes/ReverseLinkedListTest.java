package org.example.exersizes;

import org.example.model.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    @Test
    void reverseList() {

        ListNode head = new ListNode(0);

        ListNode currentItem = head;
        for(int i=1;i<5;i++) {
            ListNode next = new ListNode(i);
            currentItem.next = next;
            currentItem = currentItem.next;
        }

        currentItem = head;
        while (currentItem!=null) {
            System.out.println("before = "+currentItem.val);
            currentItem = currentItem.next;
        }

        ListNode headR = reverseLinkedList.reverseList(head);

        currentItem = headR;
        while (currentItem!=null) {
            System.out.println("After = "+currentItem.val);
            currentItem = currentItem.next;
        }

    }

    @Test
    void reverseListRecursive() {

        ListNode head = new ListNode(0);

        ListNode currentItem = head;
        for(int i=1;i<5;i++) {
            ListNode next = new ListNode(i);
            currentItem.next = next;
            currentItem = currentItem.next;
        }

        currentItem = head;
        while (currentItem!=null) {
            System.out.println("before = "+currentItem.val);
            currentItem = currentItem.next;
        }

        ListNode headR = reverseLinkedList.reverseListRecursive(head);

        currentItem = headR;
        while (currentItem!=null) {
            System.out.println("After = "+currentItem.val);
            currentItem = currentItem.next;
        }

    }
}