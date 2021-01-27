/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
Time: O(n) and space: O(n)

*/
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

public class IsBalanced {
  private boolean balanced = true;
    
  public boolean isBalanced(TreeNode root) {
      
      return height(root) != -1;
  }
  
  private int height(TreeNode node){
      if(node == null){
          return 0;
      }
      int left = height(node.left);
      int right = height(node.right);
      if(left == -1 || right == -1 || Math.abs(left - right) > 1){
          return -1;
      }
      return Math.max(left, right) + 1;
  }
}
