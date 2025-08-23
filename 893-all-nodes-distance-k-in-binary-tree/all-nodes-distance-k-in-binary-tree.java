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
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                    parent.put(node.left,node);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    parent.put(node.right,node);
                }
            }
        }
        q.offer(target);
        HashSet<TreeNode> vis = new HashSet<>();
        vis.add(target);
        int count = 0;
        while(!q.isEmpty()){
            int n = q.size();
            if(count==k) break;
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();
                if(node.left!=null && !vis.contains(node.left)){
                    q.offer(node.left);
                    vis.add(node.left);
                }
                if(node.right!=null && !vis.contains(node.right)){
                    q.offer(node.right);
                    vis.add(node.right);
                }
                if(parent.containsKey(node) && !vis.contains(parent.get(node))){
                    q.offer(parent.get(node));
                    vis.add(parent.get(node));
                }
            }
            count++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}