package _10_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAtK {
  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.left.right.left = new Tree(7);
    root.right.right = new Tree(6);

    List<Integer> levelNodes = atLevel(root, 2);
    for (int x : levelNodes)
      System.out.print(x + " ");

    System.out.println();

    levelNodes = new ArrayList<>();
    atLevel2(root, 2, levelNodes);
    for (int x : levelNodes)
      System.out.print(x + " ");

  }

  // BFS
  static List<Integer> atLevel(Tree tree, int k) {
    List<Integer> nodesAtLevel = new ArrayList<>();
    Queue<Tree> queue = new LinkedList<>();
    queue.add(tree);

    while (!queue.isEmpty()) {
      int size = queue.size();
      if (k < 0) break;
      while (size > 0) {
        Tree node = queue.poll();
        if (k == 0) nodesAtLevel.add(node.val);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
        size--;
      }
      if (k == 0) break;
      k--;
    }

    return nodesAtLevel;
  }

  // DFS
  static void atLevel2(Tree tree, int k, List<Integer> result) {
    if (tree == null) return;
    if (k == 0) {
      result.add(tree.val);
      return;
    }
    atLevel2(tree.left, k - 1, result);
    atLevel2(tree.right, k - 1, result);
  }
}
