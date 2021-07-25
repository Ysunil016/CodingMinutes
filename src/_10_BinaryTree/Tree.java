package _10_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Tree {
  int val;
  Tree left;
  Tree right;

  Tree(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "Tree{" +
      "val=" + val +
      '}';
  }

  void preOrder() {
    System.out.println(this.val);
    if (this.left != null)
      this.left.preOrder();
    if (this.right != null)
      this.right.preOrder();
  }

  void inOrder() {
    Queue<Tree> queue = new LinkedList<>();
    queue.add(this);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        Tree node = queue.poll();
        System.out.print(node.val + " ");
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
        size--;
      }
      System.out.println();
    }
  }

}
