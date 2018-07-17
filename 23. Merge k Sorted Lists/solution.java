// just recursivly merge every list just beats 14% of java submissions
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) 
            return null;
        if (lists.length == 1)
            return lists[0];
        ListNode result = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
             result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pointer;
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else {
            if (l1.val > l2.val) {
            dummyHead.next = l2;
            l2 = l2.next;
        } else {
            dummyHead.next = l1;
            l1 = l1.next;
        }
        pointer = dummyHead.next;
        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pointer.next = l2;
                l2 = l2.next;
            } else {
                pointer.next = l1;
                l1 = l1.next;
            }
            pointer = pointer.next;
        }
        if (l1 == null) {
            pointer.next = l2;
        } else {
            pointer.next = l1;
        }
        return dummyHead.next;
        }
        
    }
}
