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
    public int amountOfTime(TreeNode root, int start) {
        if(root == null) return 0;
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = null;
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode temp = q.poll();
                if(temp.val == start){
                    node = temp;
                } 
                if(temp.left!=null) {
                    parent.put(temp.left,temp);
                    q.offer(temp.left);
                } 
                if(temp.right!=null){
                    parent.put(temp.right,temp);   
                    q.offer(temp.right); 
                } 
            }
        }
        HashMap<TreeNode,Boolean> vis = new HashMap<>();
        q.offer(node);
        int time = -1;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode temp = q.poll();
                vis.put(temp,true);
                if(temp.left!=null && !vis.containsKey(temp.left)){
                    q.offer(temp.left);
                    vis.put(temp.left,true);
                }
                if(temp.right!=null && !vis.containsKey(temp.right)){
                    q.offer(temp.right);
                    vis.put(temp.right,true);
                }
                if(parent.containsKey(temp) && !vis.containsKey(parent.get(temp))){
                    q.offer(parent.get(temp));
                    vis.put(parent.get(temp),true);
                }
            }
            time+=1;
        }   
        return time;
    }
}