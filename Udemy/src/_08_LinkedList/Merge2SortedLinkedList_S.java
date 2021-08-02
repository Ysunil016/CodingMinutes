package _08_LinkedList;

public class Merge2SortedLinkedList_S {

  public static void main(String[] args) {

    LinkedList head1 = new LinkedList(10);
    head1.next = new LinkedList(20);
    head1.next.next = new LinkedList(30);

    LinkedList head2 = new LinkedList(40);
    head2.next = new LinkedList(50);
    head2.next.next = new LinkedList(60);
    head2.next.next.next = new LinkedList(70);
    head2.next.next.next.next = new LinkedList(80);

    display(merge(head1, head2));
  }

  static void display(LinkedList head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  static LinkedList merge(LinkedList l1, LinkedList l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    LinkedList result;

    if (l1.val < l2.val) {
      result = l1;
      l1 = l1.next;
    } else {
      result = l2;
      l2 = l2.next;
    }

    result.next = merge(l1, l2);

    return result;
  }
}
