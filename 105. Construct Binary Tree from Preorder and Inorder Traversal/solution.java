// preorder[0] is root, find preorder[0] in inorder[], let say its inorder[m], so inorder[0 - (m - 1)] is left tree, 
// inorder[(m + 1) - end] is right tree. preorder[1 - (1 + m)] is left tree, the rest of preorder is right tree. so do this 
// recursivly.  dont use systemcopy to create new array, just pass the index of prestart and instart, it will save lots of time
// and space

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        buildChild(root, preorder, inorder);
        
        return root;
        
    }
    
    public void buildChild(TreeNode root, int[] preorder, int[] inorder) {
        int i = 0;
        TreeNode left, right;
        if (preorder.length <= 1 || inorder.length <= 1)
            return;
        
        for (int j = 0; j < inorder.length; j++) {
            if (inorder[j] == root.val) {
                i = j;
                break;
            }
        }
        if (i == 0) {
            left = null;
            right = new TreeNode(preorder[i + 1]);
        } else if (i == preorder.length - 1) {
            left = new TreeNode(preorder[1]);
            right = null;
        } else {
            left = new TreeNode(preorder[1]);
            right = new TreeNode(preorder[i + 1]);
        }
            
            
        int[] newPreLeft = new int[i];
        int[] newPreRight = new int[preorder.length - 1 - i];
        int[] newInLeft = new int[i];
        int[] newInRight = new int[inorder.length - 1 - i];
        
        System.arraycopy(preorder, 1, newPreLeft, 0, i);
        System.arraycopy(inorder, 0, newInLeft, 0, i);
        System.arraycopy(preorder, i + 1, newPreRight, 0, preorder.length - 1 - i);
        System.arraycopy(inorder, i + 1, newInRight, 0, preorder.length - 1 - i);
        
        root.left = left;
        root.right = right;
        buildChild(left, newPreLeft, newInLeft);
        buildChild(right, newPreRight, newInRight);
        return;
              
    }
}


// same idea, better code
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder);
    }
    
    public TreeNode buildTree(int[] preorder, int start, int end, int inStart, int[] inorder){
        if(start >= preorder.length || start > end) return null;
        if(start == end) return new TreeNode(preorder[start]);
        int indexLeft = findIndex(inorder, preorder[start]); //2 , 1
        int length = indexLeft - inStart; //2, 0
        if(length < 0) return null;
        TreeNode root = new TreeNode(preorder[start]);
        if(length > 0){
            root.left = buildTree(preorder, start + 1, start + length, inStart, inorder);
        }
        root.right = buildTree(preorder, start + length + 1, end, indexLeft + 1, inorder);
        return root;
    }
    
    public int findIndex(int[] inorder, int num){
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == num) return i;
        }
        return -1;
    }
}

// different idea, haven't figured out yet
class Solution {
    int preStart = 0;
    int inStart = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, Long.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, long parent) {
        if (inStart == inorder.length || inorder[inStart] == parent) {
            inStart++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart++]);
        root.left = helper(preorder, inorder, root.val);
        root.right = helper(preorder, inorder, parent);
        return root;
    }
}
