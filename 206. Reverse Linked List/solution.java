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


// 递归实现。递归实现的难点在于递归只能返回子串的头元素，我们需要的是将已经逆序好的子串的尾指向当前元素。实际上当前元素的next指向的就是
// 已经逆序好的子串的尾，我们可以通过这个关系实现子串和当前元素的连接。
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
