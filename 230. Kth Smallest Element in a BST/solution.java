// 所谓BST就是 binary search tree， 特点是左子树的所有节点都比根节点小，右子树都比根节点大。
// 先利用递归得到左子树的节点个数, 与k比较，判断kth smallest element 在左还是右，继续递归得到结果。

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
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }
        
        return root.val;
    }
    
    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}

// 基本思想就是利用中序遍历，按顺序取出所有元素，然后返回kth元素
// 中序遍历，中序遍历得到的顺序就是大小顺序，记录一个全局变量count，每遍历一个就减1，当count == 0 时，当前节点救赎kth smallest element
class Solution {
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    
    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
}
