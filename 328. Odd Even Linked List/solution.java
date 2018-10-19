// 奇数节点一个链表，偶数节点一个链表，遍历结束后将奇数节点链表的尾指向偶数节点链表的头
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTemp = oddHead;
        ListNode evenTemp = evenHead;
        while (evenTemp != null || oddTemp != null) {
            if (evenTemp.next != null) {
                oddTemp.next = evenTemp.next;
                oddTemp = oddTemp.next;
            } else {
                break;
            }
            if (oddTemp.next != null) {
                evenTemp.next =  oddTemp.next;
                evenTemp = evenTemp.next;
            } else {
                evenTemp.next = null;
                break;
            }
        }
        oddTemp.next = evenHead;
        return oddHead;
    }
}
