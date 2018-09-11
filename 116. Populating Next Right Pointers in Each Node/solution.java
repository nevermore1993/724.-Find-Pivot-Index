// set next layer by layer, pass parent node as parameter.  right.next = parent.next.left
// for its perfect binary tree, so parent.next.left must exist if parent.next.right exists.
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        
        helper(root.left, root.right, root);
    }
    
    public void helper(TreeLinkNode left, TreeLinkNode right, TreeLinkNode parent) {
        if (left != null)
            left.next = right;
        if (right != null && parent.next != null)
            right.next = parent.next.left;
           
        if (left != null)
            helper(right.left, right.right, right);
        if (right != null)
            helper(left.left, left.right, left);
    }
}
