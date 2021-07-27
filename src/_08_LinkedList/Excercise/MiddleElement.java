package _08_LinkedList.Excercise;

public class MiddleElement {

  public static void main(String[] args) {
    LinkedList head = new LinkedList(10);
    head.next = new LinkedList(20);
    head.next.next = new LinkedList(30);
    head.next.next.next = new LinkedList(40);
    head.next.next.next.next = new LinkedList(50);
    head.next.next.next.next.next = new LinkedList(60);

    display(head);
    System.out.println();
    LinkedList mid = mid(head);
    System.out.println(mid.val);
  }

  static void display(LinkedList head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  static LinkedList mid(LinkedList head) {
    if (head == null || head.next == null) return head;
    LinkedList slow = head;
    LinkedList fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
