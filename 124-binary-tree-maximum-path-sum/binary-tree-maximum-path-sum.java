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
    public int getPathSum(TreeNode root,int[] maxSum){
        if(root == null){
            return 0;
        }
        int lsum = Math.max(0,getPathSum(root.left,maxSum));
        int rsum  = Math.max(0,getPathSum(root.right,maxSum));
        maxSum[0] = Math.max(maxSum[0],root.val+lsum+rsum);
        return root.val+Math.max(lsum,rsum);
    }
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        getPathSum(root,maxSum);
        return maxSum[0];
    }
}