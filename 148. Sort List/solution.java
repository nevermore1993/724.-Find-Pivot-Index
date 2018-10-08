// quick sort, manipulate value of nodes at original node list, really slow. During partitioning, use head node's value as
// pivot, keep track of mid node, mid node is the last node with value which is smaller than head's value, at last, swap mid and
// head, then all the nodes before mid have smaller value than mid's value, all the nodes after mid have greater value than
// mid's value
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        ListNode end = head;
        while(end.next != null)
            end = end.next;
        
        quickSort(head, end);
        return head;
    }
    
    public void quickSort(ListNode head, ListNode end) {
        if (head == end || head == null)
            return;
        ListNode mid = partition(head, end);
        quickSort(head, mid);
        quickSort(mid.next, end);
    }
    
    public ListNode partition(ListNode head, ListNode end) {
        if (head == end || head == null)
            return head;
        
        int val = head.val;
        ListNode mid = head, cur = head.next;
        while (cur != null) {
            if (cur.val < val) {
                mid = mid.next;
                int temp = cur.val;
                cur.val = mid.val;
                mid.val = temp;
            }
            cur = cur.next;
        }
        
        head.val = mid.val;
        mid.val = val;
        return mid;
    }
    
}

// quick sort, but create two list to store smaller nodes and greater nodes. much faster
class Solution {
    // 快速排序
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        ListNode pivot = head;
        head = head.next;
        pivot.next = null;
        if (head == null) return pivot;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode p = pivot;
        ListNode s = small;
        ListNode l = large;
        while (head!=null) {
            if (head.val < pivot.val) {
                s.next = head;
                s = s.next;
            } else if (head.val == pivot.val) {
                p.next = head;
                p = p.next;
            } else {
                l.next = head;
                l = l.next;
            }
            head = head.next;
        }
        l.next = null;
        s.next = null;
        p.next = null;
        ListNode ss = sortList(small.next);
        if (ss == null) {
            ss = pivot;    
        } else {
            ListNode sss = ss;
            while (sss.next!=null) {
                sss = sss.next;
            }
            sss.next = pivot;
        }
        p.next = sortList(large.next);
        return ss;
    }
}
