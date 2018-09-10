/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
// best solution, use level to record index of which to add new value
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0, res);
        //Collections.reverse(res);
        return res;
    }
    
    private void helper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        if (res.size() == level) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);
        return;
    }
}

// my solution, simple recursivly idea, put all nodes in one layer into a list, traversal it, get all it children and value
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null)
            return result;
        List<TreeNode> l = new ArrayList<>();
        l.add(root);
        addLayer(l, result);
        return result;
    }
    
    public void addLayer(List<TreeNode> p, List<List<Integer>> result) {
        List<Integer> r = new ArrayList<>();
        List<TreeNode> l = new ArrayList<>();
        if (p.size() == 0) return;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) != null) {
                r.add(p.get(i).val);
                if (p.get(i).left != null)
                    l.add(p.get(i).left);
                if (p.get(i).right != null)
                    l.add(p.get(i).right);               
            }
        }
        result.add(r);
        addLayer(l, result);
    }
}
