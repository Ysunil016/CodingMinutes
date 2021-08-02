package _08_LinkedList;

public class KReverse {

  public static void main(String[] args) {
    LinkedList head = new LinkedList(10);
    head.next = new LinkedList(20);
    head.next.next = new LinkedList(30);
    head.next.next.next = new LinkedList(40);
    head.next.next.next.next = new LinkedList(50);
    head.next.next.next.next.next = new LinkedList(60);
    display(head);
    System.out.println();
    head = reverse(head, 3);
    display(head);
  }

  static LinkedList reverse(LinkedList head, int k) {
    if (head == null || head.next == null) return head;

    LinkedList prev = null;
    LinkedList nextNode = null;
    LinkedList current = head;

    int counter = 1;

    while (current != null && counter <= k) {
      nextNode = current.next;
      current.next = prev;
      prev = current;
      current = nextNode;
      counter++;
    }

    if (nextNode != null) {
      head.next = reverse(nextNode, k);
    }

    return prev;
  }


  static void display(LinkedList head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }


}
