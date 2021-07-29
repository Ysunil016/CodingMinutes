package _16_DynamicProgramming;

public class CountingTrees {

  public static void main(String[] args) {
    int numberOfNodes = 3;
    System.out.println(bstPossible(numberOfNodes));
    System.out.println();
    numberOfNodes = 4;
    System.out.println(bstPossible(numberOfNodes));
    System.out.println();
    numberOfNodes = 3;
    System.out.println(bstPossible(numberOfNodes, new int[numberOfNodes + 1]));
    System.out.println();
    numberOfNodes = 4;
    System.out.println(bstPossible(numberOfNodes, new int[numberOfNodes + 1]));

  }

  // O(Exponential)
  private static int bstPossible(int numberOfNodes) {
    if (numberOfNodes <= 1) return 1;

    // Sitting at Node i, I Check for the Left and Right Possible Combinations.
    int total = 0;
    for (int i = 1; i <= numberOfNodes; i++) {
      total += bstPossible(i - 1) * bstPossible(numberOfNodes - i);
    }

    return total;
  }

  // O(Quadratic)
  private static int bstPossible(int numberOfNodes, int[] mem) {
    if (numberOfNodes <= 1) return 1;

    if (mem[numberOfNodes] != 0) return mem[numberOfNodes];

    // Sitting at Node i, I Check for the Left and Right Possible Combinations.
    int total = 0;
    for (int i = 1; i <= numberOfNodes; i++) {
      total += bstPossible(i - 1) * bstPossible(numberOfNodes - i);
    }

    return mem[numberOfNodes] = total;
  }
}
