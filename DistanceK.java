
/*
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]
*/
import java.util.*;

// public class TreeNode {
//   int val;
//   TreeNode left;
//   TreeNode right;

//   TreeNode(int x) {
//     val = x;
//   }
// }

public class DistanceK {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    List<Integer> res = new ArrayList<>();
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    buildParentMap(root, root, parentMap);
    Set<TreeNode> visited = new HashSet<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(target);
    visited.add(target);
    int level = 0;

    while (q.size() > 0) {
      int size = q.size();
      if (K == level) {
        return buildList(q);
      }
      for (int i = 0; i < size; i++) {
        TreeNode curNode = q.poll();
        if (curNode.left != null && !visited.contains(curNode.left)) {
          q.add(curNode.left);
          visited.add(curNode.left);
        }
        if (curNode.right != null && !visited.contains(curNode.right)) {
          q.add(curNode.right);
          visited.add(curNode.right);
        }
        TreeNode parentNode = parentMap.get(curNode);
        if (!visited.contains(parentNode)) {
          q.add(parentNode);
          visited.add(parentNode);
        }
      }
      level++;
    }

    return res;

  }

  private List<Integer> buildList(Queue<TreeNode> q) {
    List<Integer> lst = new ArrayList<>();
    while (q.size() > 0) {
      lst.add(q.poll().val);
    }
    return lst;
  }

  private void buildParentMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
    if (root == null) {
      return;
    }

    map.put(root, parent);
    buildParentMap(root.left, root, map);
    buildParentMap(root.right, root, map);
  }
}
