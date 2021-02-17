/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

*/

public class IsValidBST {

  public boolean isValidBST(TreeNode root) {
    return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }

  private boolean dfs(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }

    if (node.val >= min || node.val <= max) {
      return false;
    }
    return dfs(node.left, node.val, max) && dfs(node.right, min, node.val);
  }
}
