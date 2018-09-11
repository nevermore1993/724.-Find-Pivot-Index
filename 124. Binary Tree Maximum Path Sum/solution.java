// for a node, max sum is the max among  node.left.sum | node.right.sum |  node.left.sum + node.right.sum + node.
// recursivly get the result
class Solution {
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    public int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        res = Math.max(res, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}

// similar idea
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int through = left + right + root.val, start = Math.max(Math.max(left, right) + root.val, root.val);
        max = Math.max(Math.max(max, through), start);
        return start;
    }
}
