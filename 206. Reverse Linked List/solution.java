// cur = null， next = head，开始遍历。先保存next.next，然后将next的next指向cur，接着更新next。先记录下下一个结点，和前一个
// 结点，然后让当前节点指向前一个结点，再更新当前节点为原本的下一个结点，实现逆转
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode next, cur;
        cur = null;
        next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        return cur;
    }
}

// 也可以用stack，先顺序入栈，再出栈，则得到逆序链表
