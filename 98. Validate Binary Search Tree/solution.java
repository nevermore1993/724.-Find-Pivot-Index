// node A, its value is the max value of its left tree, and the min value of its right tree. A left node must smaller than its 
// parent, and greater than min, a right node must greater than its parent and smaller than max. 
// For left nodes , max is parent's value, min remain the same, for right nodes, min is parent's value, max remain the same. 
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
