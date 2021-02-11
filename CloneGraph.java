
/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

TC O(N) SC O(N)
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.*;

public class CloneGraph {
  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  public Node cloneGraph(Node node) {
    if (node == null)
      return null;
    Map<Integer, Node> map = new HashMap<>();

    return cloneGraphUtil(node, map);
  }

  private Node cloneGraphUtil(Node node, Map<Integer, Node> map) {
    if (map.containsKey(node.val))
      return map.get(node.val);
    Node copyNode = new Node(node.val);
    map.put(node.val, copyNode);
    for (Node neighbor : node.neighbors) {
      copyNode.neighbors.add(cloneGraphUtil(neighbor, map));
    }
    return copyNode;
  }
}
