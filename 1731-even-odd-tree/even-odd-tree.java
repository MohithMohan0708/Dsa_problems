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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int l = 0;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode temp = q.poll();
                ans.add(temp.val);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            if(l%2==0){
                if(ans.get(0)%2==0) return false;
                for(int i = 1; i < ans.size(); i++){
                    if(ans.get(i)<=ans.get(i-1) || ans.get(i)%2==0){
                        return false;
                    }
                }
            }
            else{
                if(ans.get(0)%2!=0) return false;
                for(int i = 1; i < ans.size();i++){
                    if(ans.get(i)>=ans.get(i-1) || ans.get(i)%2!=0){
                        return false;
                    }
                }
            }
            l++;
        }
        return true;
    }
}