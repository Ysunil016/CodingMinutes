package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(100);
    for (List<Integer> level : levelOrder(root)) {
      for (int v : level)
        System.out.print(v + " ");
      System.out.println();
    }
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if(root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      List<Integer> atLevel = new ArrayList<>();
      while (size > 0) {
        TreeNode tNode = queue.poll();
        atLevel.add(tNode.val);

        if (tNode.left != null) queue.add(tNode.left);
        if (tNode.right != null) queue.add(tNode.right);

        size--;
      }
      result.add(atLevel);
    }


    return result;
  }
}
