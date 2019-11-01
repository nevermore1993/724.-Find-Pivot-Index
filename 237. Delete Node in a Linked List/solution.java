// 正常来说，删除节点是将前一个节点直接指向下一个节点。但是这里我们访问不了前一个节点，所以我们能做的是用当前节点来代替下一个节点，
// 然后将下一个节点从链表中删除。
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
