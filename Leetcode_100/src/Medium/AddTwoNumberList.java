package Medium;

import Helper.ListNode;

public class AddTwoNumberList {

  public static void main(String[] args) {
    ListNode L1 = new ListNode(1);
    L1.next = new ListNode(2);
    L1.next.next = new ListNode(3);
    L1.next.next.next = new ListNode(6);
    L1.next.next.next.next = new ListNode(4);
    L1.next.next.next.next.next = new ListNode(5);
    L1.display();
    System.out.println();

    ListNode L2 = new ListNode(1);
    L2.next = new ListNode(2);
    L2.next.next = new ListNode(3);
    L2.next.next.next = new ListNode(6);
    L2.next.next.next.next = new ListNode(4);
    L2.next.next.next.next.next = new ListNode(5);
    L2.display();
    System.out.println();

    ListNode Result = addTwoNumbers(L1, L2);
    Result.display();
  }


  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode resultPlaceHolder = new ListNode(-1);
    ListNode result = resultPlaceHolder;

    int carry = 0;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      if (sum >= 10) carry = sum / 10;
      else carry = 0;
      result.next = new ListNode(sum % 10);
      result = result.next;
      l1 = l1.next;
      l2 = l2.next;
    }

    while (l1 != null) {
      int sum = l1.val + carry;
      if (sum >= 10) carry = sum / 10;
      else carry = 0;
      result.next = new ListNode(sum % 10);
      result = result.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      int sum = l2.val + carry;
      if (sum >= 10) carry = sum / 10;
      else carry = 0;
      result.next = new ListNode(sum % 10);
      result = result.next;
      l2 = l2.next;
    }

    if (carry != 0) {
      result.next = new ListNode(carry);
    }

    return resultPlaceHolder.next;

  }
}
