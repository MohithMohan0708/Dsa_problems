/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode temp = q.poll();
                if(temp.left!=null) {
                    parent.put(temp.left,temp);
                    q.offer(temp.left);
                }
                if(temp.right!=null) {
                    parent.put(temp.right,temp);
                    q.offer(temp.right);
                }
            }
        }
        q.offer(target);
        HashMap<TreeNode,Boolean> vis = new HashMap<>();
        vis.put(target,true);
        int l = 0;
        while(!q.isEmpty()){
            int n = q.size();
            if(l==k) break;
            for(int i = 0; i < n;i++){
                TreeNode temp = q.poll();
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
            l++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}