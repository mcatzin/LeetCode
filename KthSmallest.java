/*
Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree

*/

import java.util.PriorityQueue;

class KthSmallest {
  public int kthSmallest(TreeNode root, int k) {
    PriorityQueue<TreeNode> maxHeap = new PriorityQueue<>((a, b) -> b.val - a.val);
    dfs(root, k, maxHeap);

    int result = maxHeap.poll().val;

    return result;
  }

  private void dfs(TreeNode node, int k, PriorityQueue<TreeNode> maxHeap) {
    if (node == null) {
      return;
    }
    maxHeap.offer(node);

    while (maxHeap.size() > k) {
      maxHeap.poll();
    }
    dfs(node.left, k, maxHeap);
    dfs(node.right, k, maxHeap);
  }
}