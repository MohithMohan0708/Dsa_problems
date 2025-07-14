/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return getHeight(root)==-1 ? false : true;
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int lh = getHeight(root.left);
        if(lh==-1) return -1;
        int rh = getHeight(root.right);
        if(rh==-1) return -1;
        int diff = Math.abs(lh-rh);
        if(diff>1){
            return -1;
        }
        return 1+Math.max(lh,rh);
    }
}