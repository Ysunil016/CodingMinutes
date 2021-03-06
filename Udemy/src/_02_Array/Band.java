package _02_Array;

import java.util.Arrays;
import java.util.HashSet;

public class Band {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 9, 3, 0, 18, 5, 2, 10, 7, 12, 6};
    System.out.println(bandLen(arr));
    System.out.println(bandLen2(arr));
    System.out.println(bandLen3(arr));
  }

  // O(NlgN) | O(1)
  private static int bandLen(int[] arr) {
    Arrays.sort(arr);
    int counter = 0;
    int maxLen = 0;

    while (counter < arr.length) {
      int len = 1;

      int lCounter = counter;
      while (lCounter > 0 && arr[lCounter - 1] == (arr[lCounter] - 1)) {
        lCounter--;
        len++;
      }

      int rCounter = counter;
      while (rCounter < arr.length - 1 && arr[rCounter + 1] == (arr[rCounter] + 1)) {
        rCounter++;
        len++;
      }

      if (rCounter > counter) counter = rCounter;
      else counter++;

      maxLen = Math.max(maxLen, len);
    }
    return maxLen;
  }


  // O(N) | O(N)
  private static int bandLen2(int[] arr) {
    HashSet<Integer> elementSet = new HashSet<>();
    for (int x : arr) elementSet.add(x);

    HashSet<Integer> visited = new HashSet<>();

    int maxLen = 0;

    int counter = 0;
    while (counter < arr.length) {
      int currentElement = arr[counter];
      if (!visited.contains(currentElement)) {
        int len = 1;

        int rightElement = currentElement + 1;
        int leftElement = currentElement - 1;
        while (elementSet.contains(rightElement)) {
          visited.add(rightElement);
          rightElement++;
          len++;
        }
        while (elementSet.contains(leftElement)) {
          visited.add(leftElement);
          leftElement--;
          len++;
        }

        maxLen = Math.max(maxLen, len);
      }
      counter++;
    }
    return maxLen;
  }

  // O(N) | O(N)  -> Start Head Strategy

  private static int bandLen3(int[] arr) {
    HashSet<Integer> elementSet = new HashSet<>();
    for (int x : arr) elementSet.add(x);

    int maxLen = 0;

    int counter = 0;
    while (counter < arr.length) {
      int currentElement = arr[counter];

      // Look for Start Head
      if (!elementSet.contains(currentElement - 1)) {
        int len = 1;

        // Finding All Chain Length
        int rightElement = currentElement + 1;
        while (elementSet.contains(rightElement)) {
          rightElement++;
          len++;
        }

        maxLen = Math.max(maxLen, len);
      }
      counter++;
    }
    return maxLen;
  }
}
