package _04_SlidingWindow.Exercise;

import java.util.PriorityQueue;

public class SlidingWindowMax {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
    int[] res = windowMax(arr, 3);
    for (int x : res) System.out.print(x + " ");
  }

  private static int[] windowMax(int[] arr, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i < k; i++) {
      heap.add(arr[i]);
    }

    int[] res = new int[arr.length - k + 1];
    for (int i = k; i <= arr.length; i++) {
      res[i - k] = heap.peek();
      if (i >= k && i < arr.length) {
        heap.add(arr[i]);
        heap.remove(arr[i - k]);
      }
    }

    return res;
  }
}
