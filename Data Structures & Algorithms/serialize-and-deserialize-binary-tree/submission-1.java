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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if(root == null){
        return "null";
      }
      return root.val +","+serialize(root.left)+","+serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String>q = new LinkedList<>();
        for(String value:values){
          q.offer(value);
        }
        return treeMaker(q);
    }
    private TreeNode treeMaker(Queue<String>q){
      String value = q.poll();
      if(value.equals("null")){
        return null;
      }
      TreeNode root = new TreeNode(Integer.parseInt(value));
      root.left = treeMaker(q);
      root.right = treeMaker(q);

      return root;
    }
}
