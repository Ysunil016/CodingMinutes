package _16_DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
  public static void main(String[] args) {
    int[] denoms = new int[]{1, 3, 7, 10};
    int target = 15;

    System.out.println(minCoinChange(denoms, target, denoms.length - 1));
    System.out.println();

    int[][] mem = new int[denoms.length + 1][target + 1];
    for (int[] x : mem) Arrays.fill(x, -1);
    System.out.println(minCoinChange(denoms, target, denoms.length - 1, mem));
  }

  static int infinite = 50000;

  // O(Exponential)
  static int minCoinChange(int[] denoms, int amount, int idx) {
    if (amount < 0 || idx < 0) return infinite;
    if (amount == 0) return 0;

    return Math.min(
      1 + minCoinChange(denoms, amount - denoms[idx], idx),
      minCoinChange(denoms, amount, idx - 1)
    );
  }

  // O(N*A) (Mem) - Recursion
  static int minCoinChange(int[] denoms, int amount, int idx, int[][] mem) {
    if (amount < 0 || idx < 0) return infinite;
    if (amount == 0) return 0;

    if (mem[idx][amount] != -1) return mem[idx][amount];

    mem[idx][amount] = Math.min(
      1 + minCoinChange(denoms, amount - denoms[idx], idx),
      minCoinChange(denoms, amount, idx - 1)
    );

    return mem[idx][amount];
  }

}
