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
    public void dfs(TreeNode root, StringBuilder curr, PriorityQueue<String> pq){
        curr.append((char)('a' + root.val));
        if(root.left == null && root.right == null){
            String temp = curr.reverse().toString();
            pq.offer(temp);
            curr.reverse();
        }
        if(root.left!=null) dfs(root.left,curr,pq);
        if(root.right!=null) dfs(root.right,curr,pq);
        curr.deleteCharAt(curr.length()-1);
    }
    public String smallestFromLeaf(TreeNode root) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        StringBuilder curr = new StringBuilder();
        dfs(root,curr,pq);
        return pq.poll();
    }
}