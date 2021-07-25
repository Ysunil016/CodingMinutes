package _10_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderPrint {

  static class Tree {
    int val;
    Tree left;
    Tree right;

    Tree(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    Tree root = new Tree(1);
    root.left = new Tree(2);
    root.right = new Tree(3);
    root.left.left = new Tree(4);
    root.left.right = new Tree(5);
    root.left.right.left = new Tree(7);
    root.right.right = new Tree(6);

    printOrderLevel(root);
  }

  private static void printOrderLevel(Tree root) {
    Queue<Tree> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        Tree node = queue.poll();
        System.out.print(node.val+" ");
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
        size--;
      }
      System.out.println();
    }
  }
}
