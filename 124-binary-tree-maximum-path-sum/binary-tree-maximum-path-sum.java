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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int temp = getSum(root);
        return maxi;
    }
    public int getSum(TreeNode root){
        if(root==null) return 0;
        int ls = Math.max(getSum(root.left),0);
        int rs = Math.max(getSum(root.right),0);
        int curr = ls + rs + root.val;
        if(curr>maxi) maxi = curr;
        return root.val+Math.max(ls,rs);
    }
}