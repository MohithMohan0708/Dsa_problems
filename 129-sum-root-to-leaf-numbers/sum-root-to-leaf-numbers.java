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
    public void dfs(TreeNode root, List<Integer> curr, List<List<Integer>> ans){
        curr.add(root.val);
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(curr));
        }
        if(root.left!=null) dfs(root.left,curr,ans);
        if(root.right!=null) dfs(root.right,curr,ans);
        curr.remove(curr.size()-1);
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(root,curr,ans);
        int total = 0;
        for(List<Integer> temp : ans){
            int num = 0;
            for(int item : temp){
                num = num * 10 + item;
            }
            total += num;
        }
        return total;
    }
}