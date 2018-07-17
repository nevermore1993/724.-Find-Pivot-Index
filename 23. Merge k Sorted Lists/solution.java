in recursion solution, the first list got merged for k-1 times, second list got merged for k-2 times ..... 
    total merge time  (k-1)k/2
in divide-conquer solution, each list got merged for only log(k) (the depth of Complete Binary Tree with k leaves) times. 
    total merge time  log(k)k


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

// divide and conquer, beats 99.15% of java submissions
/*Approach 5: Merge with Divide And Conquer

Intuition & Algorithm

This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly

    Pair up k\text{k}k lists and merge each pair.

    After the first pairing, k\text{k}k lists are merged into k/2k/2k/2 lists with average 2N/k2N/k2N/k length, 
then k/4k/4k/4, k/8k/8k/8 and so on.

    Repeat this procedure until we get the final sorted linked list.

Thus, we'll traverse almost NNN nodes per pairing and merging, and repeat this procedure about log2k\log_{2}{k}log​2​​k times.*/
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
        
        int length = lists.length;
        int nLength;
        ListNode[] l;
        if (length % 2 == 0)
            nLength = length / 2;
        else
            nLength = length / 2 + 1;
        l = new ListNode[nLength];
        
        for (int i = 0; i < (length / 2); i++) {
            l[i] = mergeTwoLists(lists[i], lists[length - i - 1]);
        }
        if (length % 2 != 0)
            l[nLength - 1] = lists[length / 2];
        return mergeKLists(l);
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
