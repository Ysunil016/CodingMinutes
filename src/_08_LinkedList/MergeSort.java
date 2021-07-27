package _08_LinkedList;

public class MergeSort {
  public static void main(String[] args) {
    LinkedList head2 = new LinkedList(70);
    head2.next = new LinkedList(50);
    head2.next.next = new LinkedList(10);
    head2.next.next.next = new LinkedList(30);
    head2.next.next.next.next = new LinkedList(40);

    display(head2);
    System.out.println();
    head2 = mergeSort(head2);
    display(head2);
  }

  private static LinkedList mergeSort(LinkedList head) {
    if (head == null || head.next == null) return head;

    LinkedList mid = getMid(head);
    LinkedList left = mergeSort(head);
    LinkedList right = mergeSort(mid);
    return merge(left, right);
  }

  private static LinkedList getMid(LinkedList head) {
    if (head == null || head.next == null) return null;
    LinkedList slow = head;
    LinkedList fast = head;
    LinkedList prevNode = null;
    while (fast != null && fast.next != null) {
      prevNode = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prevNode.next = null;

    return slow;
  }

  static void display(LinkedList head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  static LinkedList merge(LinkedList left, LinkedList right) {
    if (left == null) return right;
    if (right == null) return left;

    LinkedList node;
    if (left.val < right.val) {
      node = left;
      left = left.next;
    } else {
      node = right;
      right = right.next;
    }
    node.next = merge(left, right);

    return node;
  }
}
