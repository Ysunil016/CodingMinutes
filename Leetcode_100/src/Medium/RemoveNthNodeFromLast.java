package Medium;

import Helper.ListNode;

public class RemoveNthNodeFromLast {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(6);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(5);

    head.display();
    System.out.println();

    ListNode afterRemovingFromLast = removeNthFromEnd(head, 3);
    afterRemovingFromLast.display();
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode finalResult = head;

    ListNode slow = head;
    ListNode fast = head;

    while (n-- > 0) {
      fast = fast.next;
    }

    ListNode prev = null;
    while (fast != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next;
    }

    if (prev != null) prev.next = slow.next;
    else return head.next;

    return finalResult;
  }
}
