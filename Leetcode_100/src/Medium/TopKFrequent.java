package Medium;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {

  public static void main(String[] args) {
    for (int x : topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 3)) {
      System.out.print(x + " ");
    }
  }

  static class Pair {
    public int val;
    public int freq;

    Pair(int v, int f) {
      this.val = v;
      this.freq = f;
    }
  }

  public static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Pair> hash = new HashMap<>();
    for (int x : nums) {
      if (hash.containsKey(x)) {
        hash.get(x).freq++;
      } else {
        hash.put(x, new Pair(x, 1));
      }
    }

    PriorityQueue<Pair> heap = new PriorityQueue<>((A, B) -> B.freq - A.freq);

    for (int key : hash.keySet())
      heap.add(hash.get(key));

    int[] res = new int[k];
    for (int i = 0; i < k; i++)
      res[i] = heap.remove().val;

    return res;
  }
}
