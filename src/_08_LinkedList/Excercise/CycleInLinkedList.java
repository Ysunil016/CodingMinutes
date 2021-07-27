package _08_LinkedList.Excercise;

public class CycleInLinkedList {

  public static void main(String[] args) {

    LinkedList head = new LinkedList(10);
    head.next = new LinkedList(20);
    head.next.next = new LinkedList(30);
    head.next.next.next = new LinkedList(40);
    head.next.next.next.next = new LinkedList(50);
    head.next.next.next.next.next = new LinkedList(60);
//    head.next.next.next.next.next.next = head.next.next.next;

    System.out.println(hasCycle(head));
  }

  static boolean hasCycle(LinkedList head) {
    LinkedList slow = head.next;
    LinkedList fast = head.next.next;
    if (slow.next == null) return false;
    if (fast.next == null) return false;

    while (fast != null && slow != fast) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast == null) return false;

    return true;
  }
}
