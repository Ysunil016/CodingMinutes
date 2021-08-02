package _16_DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
  public static void main(String[] args) {
    int[] denoms = new int[]{1, 3, 7, 10, 7, 8};
    int target = 15;

    System.out.println(minCoinChange(denoms, target, denoms.length - 1));
    System.out.println();

    int[][] mem = new int[denoms.length + 1][target + 1];
    for (int[] x : mem) Arrays.fill(x, -1);
    System.out.println(minCoinChange(denoms, target, denoms.length - 1, mem));

    System.out.println();

    System.out.println(minCoinChange2(denoms, target, 0));
    System.out.println();
    System.out.println(minCoinChange3(denoms, target));
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

  // Another Way
  static int minCoinChange2(int[] denoms, int amount, int idx) {
    if (amount < 0 || idx < 0) return infinite;
    if (amount == 0) return 0;

    int minCoin = infinite;

    for (int i = idx; i < denoms.length; i++) {
      minCoin = Math.min(minCoin, 1 + minCoinChange2(denoms, amount - denoms[i], i));
    }

    return minCoin;
  }

  static int minCoinChange3(int[] denoms, int amount) {
    int[] dp = new int[amount + 1];
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int c : denoms) {
        if (i - c >= 0 && dp[i - c] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - c] + 1);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }


}
