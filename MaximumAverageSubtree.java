/*
Given the root of a binary tree, find the maximum average value of any subtree of that tree.

(A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)
    5
  /   \
6       4

Input: [5,6,1]
Output: 6.00000

Time : O(n) Space : O(N)
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
}

public class MaximumAverageSubtree {
  private double avgMax = 0;

  public double maximumAverageSubtree(TreeNode root) {
    dfs(root);
    return avgMax;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftChild = dfs(node.left);
    int rightChild = dfs(node.right);
    int number = leftChild + rightChild + 1;
    if (leftChild != 0) {
      node.val += node.left.val;
    }
    if (rightChild != 0) {
      node.val += node.right.val;
    }
    avgMax = Math.max(avgMax, (double) node.val / number);

    return number;
  }
}
