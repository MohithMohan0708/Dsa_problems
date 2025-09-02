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
    public boolean dfs(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return targetSum - root.val == 0;
        }
        targetSum -= root.val;
        return dfs(root.left,targetSum) || dfs(root.right,targetSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum);
    }
}