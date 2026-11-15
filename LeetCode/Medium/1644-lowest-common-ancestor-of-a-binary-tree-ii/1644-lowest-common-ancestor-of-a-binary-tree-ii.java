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
    private int present = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = dfs(root, p, q);
        return (present == 2)? ans : null;
    }
    
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;

        //recurse into BOTH subtrees first, so a target nested under the other
        TreeNode left = dfs(root.left, p , q);
        TreeNode right = dfs(root.right, p, q);
        
        //case 1: root itself is one of the targets
        if(root == q || root == p) {
            present++; // FIX: record existence
            return root;
        }

        
        //case 2 right is the ancestor
        // case 3 left is the ancestor 
        if(left != null && right != null) return root;

        return (left != null) ? left : right;
        //case 4 retr
        
    }
}