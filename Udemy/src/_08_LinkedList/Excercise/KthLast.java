package _08_LinkedList.Excercise;

public class KthLast {

  public static void main(String[] args) {
    LinkedList head = new LinkedList(10);
    head.next = new LinkedList(20);
    head.next.next = new LinkedList(30);
    head.next.next.next = new LinkedList(40);
    head.next.next.next.next = new LinkedList(50);
    head.next.next.next.next.next = new LinkedList(60);

    display(head);
    System.out.println();
    LinkedList fromLast = fromLast(head, 5);
    System.out.println(fromLast.val);
  }

  static void display(LinkedList head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  static LinkedList fromLast(LinkedList head, int k) {
    if (head == null) return null;
    LinkedList temp = head;
    LinkedList fromLast = head;
    int counter = 0;

    while (temp != null) {
      if (counter >= k) fromLast = fromLast.next;
      temp = temp.next;
      counter++;
    }

    return fromLast;
  }
}
