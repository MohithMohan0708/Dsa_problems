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
    public TreeNode getNode(int inSt, int inEnd, int preSt, int preEnd, int[] inorder,int[] preorder, HashMap<Integer,Integer> inMap){
        if(preSt>preEnd || inSt > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preSt]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inSt;
        root.left = getNode(inSt,inRoot-1,preSt+1,preSt+numsLeft,inorder,preorder,inMap);
        root.right = getNode(inRoot+1,inEnd,preSt+numsLeft+1,preEnd,inorder,preorder,inMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i  = 0; i < inorder.length; i++){
            inMap.put(inorder[i],i);
        }
        return getNode(0,inorder.length-1,0,preorder.length-1,inorder,preorder,inMap);
    }
}