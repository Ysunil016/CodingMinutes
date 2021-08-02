package _10_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBuild {

  public static void main(String[] args) {
    int[] levelOrder = new int[]{1, 2, 3, 4, 5, -1, 6, -1, -1, 7, -1, -1, -1, -1, -1};
    Tree tree = buildTree(levelOrder);
    tree.inOrder();
  }

  private static Tree buildTree(int[] levelOrder) {
    Queue<Tree> queue = new LinkedList<>();
    Tree root = new Tree(levelOrder[0]);
    queue.add(root);
    int left = 1;
    int right = 2;
    while (!queue.isEmpty() && left < levelOrder.length) {
      Tree cNode = queue.poll();
      if (levelOrder[left] != -1) {
        cNode.left = new Tree(levelOrder[left]);
        queue.add(cNode.left);
      }
      if (levelOrder[right] != -1) {
        cNode.right = new Tree(levelOrder[right]);
        queue.add(cNode.right);
      }
      left = right + 1;
      right += 2;
    }
    return root;
  }
}
