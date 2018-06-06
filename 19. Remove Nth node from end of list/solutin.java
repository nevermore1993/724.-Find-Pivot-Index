/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode f, s;
        int i = 0;
        f = d;
        s = d;
        
        while(s != null) {
            if(i >= (n + 1)) {
                f = f.next;
            }
            s = s.next;
            i++;
        }
        f.next = f.next.next;
        return d.next;
        
    }
}

//two pointers, first pointer is N nodes ahead of second pointer, move them together, until first pointer points to the end. then second pointer
//will be pointing at the Nth node from end of list.
