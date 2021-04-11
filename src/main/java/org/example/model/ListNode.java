package org.example.model;



public class ListNode {

      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
            String nextString = "";
            if(next==null) {
                  nextString = "null";
            } else {
                  nextString = String.valueOf(next.val);
            }

            return "val = "+ val+" , next =" + nextString;
      }
}
