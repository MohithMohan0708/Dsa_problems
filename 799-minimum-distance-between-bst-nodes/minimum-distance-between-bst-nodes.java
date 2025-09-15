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
    public void getInorder(TreeNode root, List<Integer> ans){
        if(root==null) return;
        getInorder(root.left,ans);
        ans.add(root.val);
        getInorder(root.right,ans);
    }
    public int minDiffInBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getInorder(root,ans);
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < ans.size()-1; i++){
            if(Math.abs(ans.get(i)-ans.get(i+1)) < mini){
                mini = Math.abs(ans.get(i)- ans.get(i+1));
            }
        }
        return mini;
    }
}