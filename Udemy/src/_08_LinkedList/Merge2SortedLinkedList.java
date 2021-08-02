package _08_LinkedList;

public class Merge2SortedLinkedList {

  public static void main(String[] args) {
    LinkedList head1 = new LinkedList(10);
    head1.next = new LinkedList(20);
    head1.next.next = new LinkedList(30);

    LinkedList head2 = new LinkedList(40);
    head2.next = new LinkedList(50);
    head2.next.next = new LinkedList(60);

    display(merge(head1, head2));
  }

  static void display(LinkedList head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  static LinkedList merge(LinkedList l1, LinkedList l2) {
    LinkedList resultant = new LinkedList(-1);
    LinkedList result = resultant;

    LinkedList pointerOne = l1;
    LinkedList pointerTwo = l2;

    while (pointerOne != null && pointerTwo != null) {
      if (pointerOne.val < pointerTwo.val) {
        result.next = pointerOne;
        pointerOne = pointerOne.next;
      } else {
        result.next = pointerTwo;
        pointerTwo = pointerTwo.next;
      }
      result = result.next;
    }

    while (pointerOne != null) {
      result.next = pointerOne;
      pointerOne = pointerOne.next;
      result = result.next;
    }

    while (pointerTwo != null) {
      result.next = pointerTwo;
      pointerTwo = pointerTwo.next;
      result = result.next;
    }

    return resultant.next;
  }
}
