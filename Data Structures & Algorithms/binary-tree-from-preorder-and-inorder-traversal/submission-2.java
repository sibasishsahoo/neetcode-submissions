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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return build(preorder,inorder,0,inorder.length-1); 
    }
    TreeNode build(int[]preorder,int[]inorder,int instart,int inend){
        if(instart>inend){
            return null;
        }
        int rootnode = preorder[preIndex++];
        TreeNode root = new TreeNode(rootnode);
        int inindex = instart;
        while(inorder[inindex]!=rootnode){
            inindex++;
        }
        root.left = build(preorder,inorder,instart,inindex-1);
        root.right = build(preorder,inorder,inindex+1,inend);

        return root;
        
    }
}
