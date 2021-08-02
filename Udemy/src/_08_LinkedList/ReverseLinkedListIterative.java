package _08_LinkedList;

public class ReverseLinkedListIterative {

  public static void main(String[] args) {
    LinkedList head = new LinkedList(10);
    head.next = new LinkedList(20);
    head.next.next = new LinkedList(30);
    head.next.next.next = new LinkedList(40);
    head.next.next.next.next = new LinkedList(50);
    head.next.next.next.next.next = new LinkedList(60);

    display(head);
    System.out.println();
    head = reverse(head);
    display(head);

  }

  static void display(LinkedList head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  static LinkedList reverse(LinkedList head) {
    if (head == null || head.next == null) return head;

    LinkedList prev = null;
    while (head != null) {
      LinkedList next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }

}
