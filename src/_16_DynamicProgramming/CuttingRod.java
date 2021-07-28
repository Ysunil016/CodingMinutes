package _16_DynamicProgramming;

import java.util.Arrays;

public class CuttingRod {

  public static void main(String[] args) {
//    int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
    int[] price = new int[]{3, 5, 8, 9, 10, 17, 17, 20};
    int totalLen = 8;
    System.out.println(cutRod(price, price.length - 1, totalLen));
    System.out.println();
    System.out.println(cutRod2(price, totalLen));
    System.out.println();
    int[][] mem = new int[price.length + 1][totalLen + 1];
    for (int[] x : mem) Arrays.fill(x, -1);
    System.out.println(cutRod3(price, price.length - 1, totalLen, mem));
  }

  static int cutRod(int[] price, int pos, int totalLen) {
    if (totalLen <= 0 || pos == 0) return 0;

    if (pos <= totalLen) {
      return Math.max(
        price[pos - 1] + cutRod(price, pos, totalLen - pos),
        cutRod(price, pos - 1, totalLen)
      );
    } else {
      return cutRod(price, pos - 1, totalLen);
    }
  }

  static int cutRod2(int[] price, int totalLen) {
    if (totalLen <= 0) return 0;

    int maxLen = Integer.MIN_VALUE;
    for (int i = 0; i < totalLen; i++) {
      int cut = i + 1;
      int currentMax = price[i] + cutRod2(price, totalLen - cut);
      maxLen = Math.max(maxLen, currentMax);
    }
    return maxLen;
  }

  static int cutRod3(int[] price, int pos, int totalLen, int[][] mem) {
    if (totalLen <= 0 || pos == 0) return 0;

    if (mem[pos][totalLen] != -1) return mem[pos][totalLen];

    if (pos <= totalLen) {
      mem[pos][totalLen] = Math.max(
        price[pos - 1] + cutRod(price, pos, totalLen - pos),
        cutRod(price, pos - 1, totalLen)
      );
    } else {
      mem[pos][totalLen] = cutRod(price, pos - 1, totalLen);
    }
    return mem[pos][totalLen];
  }
}
