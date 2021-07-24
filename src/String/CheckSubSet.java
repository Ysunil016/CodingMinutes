package String;

public class CheckSubSet {

  public static void main(String[] args) {
    String original = "codingminutes";
    String key = "cines";
    System.out.println(isSubset(original, key));
  }

  // O(N) | O(1)
  private static boolean isSubset(String original, String key) {
    int oPointer = 0;
    int kPointer = 0;
    while (oPointer < original.length() && kPointer < key.length()) {
      if (original.charAt(oPointer) == key.charAt(kPointer)) kPointer++;
      oPointer++;
    }
    return kPointer == key.length();
  }
}
