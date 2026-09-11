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
    public int goodNodes(TreeNode root) { 
        return Dfs(root,root.val);
    }
    private int Dfs(TreeNode node,int maxSum){
        if(node == null){
            return 0;
        }
        int count = 0;
        if(node.val>=maxSum){
            count = 1;
            maxSum = node.val;
        }
        int left = Dfs(node.left,maxSum);
        int right = Dfs(node.right,maxSum);
        return left + right + count;
    }
}
