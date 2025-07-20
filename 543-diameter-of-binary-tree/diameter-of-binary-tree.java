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
    public int getDiameter(TreeNode root,int[] diameter){
        if(root==null){
            return 0;
        }
        int lt = getDiameter(root.left,diameter);
        int rt = getDiameter(root.right,diameter);
        diameter[0] = Math.max(diameter[0],lt+rt);
        return 1 + Math.max(lt,rt);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int[] diameter = new int[1];
        diameter[0] = 0;
        int ans = getDiameter(root,diameter);
        return diameter[0];
    }
}