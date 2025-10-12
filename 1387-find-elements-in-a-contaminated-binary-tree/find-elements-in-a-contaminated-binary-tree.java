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
class FindElements {
    HashSet<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        if(root!=null){
            set.add(0);
            root.val = 0;
            bfs(root);
        }
    }
    public void bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            TreeNode node = q.poll();
            set.add(node.val);
            if(node.left!=null){
                node.left.val = node.val * 2 + 1;
                q.offer(node.left);
            }
            if(node.right!=null){
                node.right.val = node.val * 2 + 2;
                q.offer(node.right);
            }
        }
    }
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */