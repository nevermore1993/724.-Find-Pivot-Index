// 正常来说，删除节点是将前一个节点直接指向下一个节点。但是这里我们访问不了前一个节点，所以先将当前节点和下一个节点的值交换，接着再删除下一个节点。
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
