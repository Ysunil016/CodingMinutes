package String;

import java.util.ArrayList;

public class KeySort {

  public static void main(String[] args) {
    ArrayList<String> stress = new ArrayList<>();
    stress.add("23 130 67");
    stress.add("43 195 67");
    stress.add("56 132 76");
    stress.add("98 154 23");

    sortKey(stress, 2, true);

    for (String str : stress) {
      System.out.println(str);
    }
    System.out.println();
    sortKey(stress, 2, false);
    for (String str : stress) {
      System.out.println(str);
    }
  }

  // O(NLgN)
  private static void sortKey(ArrayList<String> Stress, int col, boolean isNumeric) {
    if (isNumeric)
      Stress.sort(
        (A, B) -> {
          return Integer.parseInt(A.split(" ")[col - 1]) - Integer.parseInt(B.split(" ")[col - 1]);
        });
    else
      Stress.sort(
        (A, B) -> {
          return B.split(" ")[col - 1].compareTo(A.split(" ")[col - 1]);
        });
  }
}
