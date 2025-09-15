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
    public void getSum(TreeNode root, int targetSum, int currSum, List<List<Integer>> ans, List<Integer> curr){
        if(root == null){
            return;
        }
        currSum += root.val;
        curr.add(root.val);
        if((root.left==null) && (root.right==null) && (currSum == targetSum)){
            ans.add(new ArrayList<>(curr));
        }
        getSum(root.left,targetSum,currSum,ans,curr);
        getSum(root.right,targetSum,currSum,ans,curr);
        curr.remove(curr.size()-1);
        currSum -= root.val;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        getSum(root,targetSum,0,ans,curr);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
        return ans;
    }
}