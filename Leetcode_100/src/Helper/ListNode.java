package Helper;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public void display() {
    ListNode head = this;
    while (head != null) {
      System.out.print(head.val + " -> ");
      head = head.next;
    }
  }
}
