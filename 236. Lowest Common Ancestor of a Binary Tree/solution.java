// 遍历根节点的左子树，右子树，如果最终left或者right有一个是空的，说明p,q都在另外一颗子树上，如果都不是空的，说明分布在两棵子树上，则结果就是
// 根。如果不在某颗树上，递归的终点往上返回的都是null，只有遇到p,q才返回当前节点。
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
