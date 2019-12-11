/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) 
            return l2;
        else if (l2 == null) 
            return l1;
        ListNode dummy = new ListNode(0);
        ListNode pointer;
        // pointer1 = l1;
        // pointer2 = l2;
        
        if (l1.val <= l2.val) {
            dummy.next = l1;
            l1 = l1.next;
        } else {
            dummy.next = l2;
            l2 = l2.next;
        }
        pointer = dummy.next;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                pointer = pointer.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            while (l2 != null) {
                pointer.next = l2;
                pointer = pointer.next;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                pointer.next = l1;
                pointer = pointer.next;
                l1 = l1.next;
            }
        }
        
        return dummy.next;
    }
}

// 递归调用
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode pointer = null;
        
        if (l1.val <= l2.val) {
            pointer = l1;
            l1 = l1.next;
        } else {
            pointer = l2;
            l2 = l2.next;
        }
        
        pointer.next = mergeTwoLists(l1, l2);
        
        return pointer;
    }
}
