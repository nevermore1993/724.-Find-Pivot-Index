/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // just like Q.102, add a parameter to indicate layer index.
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null)
            return result;
        List<TreeNode> l = new ArrayList<>();
        l.add(root);
        addLayer(l, result, 1);
        return result;
    }
    
    public void addLayer(List<TreeNode> p, List<List<Integer>> result, int layer) {
        List<Integer> r = new ArrayList<>();
        List<TreeNode> l = new ArrayList<>();
        if (p.size() == 0) return;
        for (int i = 0; i < p.size(); i++) {
            if (layer % 2 == 0)
                r.add(p.get(p.size() - 1 - i).val);
            else
                r.add(p.get(i).val);
            if (p.get(i).left != null)
                l.add(p.get(i).left);
            if (p.get(i).right != null)
                l.add(p.get(i).right);  
        }
        result.add(r);
        addLayer(l, result, layer + 1);
    }
}
