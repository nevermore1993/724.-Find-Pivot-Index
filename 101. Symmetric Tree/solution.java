// this was easy, but I made it complex first, all we need to do is to recusivly compare left.left == right.right and 
// left.right == right.left.    First I was intended to construct a string with its inorder traversal, but its didnt work,
// some cases wont fit.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        
        return isEqual(root.left, root.right);
    }
    
    public boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        
        return (left.val == right.val) && isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }
}
