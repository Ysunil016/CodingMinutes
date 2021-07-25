package String.Excercise;

public class StringNormalization {
  public static void main(String[] args) {
    String str = "this is so much fun!";
    System.out.println(normalize(str));
  }

  // O(N) | O(N)
  private static String normalize(String str) {
    String[] words = str.split(" ");
    StringBuilder strBuild = new StringBuilder();

    // Normalize Each Word
    for (String word : words) {
      char[] arr = word.toCharArray();
      arr[0] = Character.toUpperCase(arr[0]);
      for (int i = 1; i < arr.length; i++) arr[i] = Character.toLowerCase(arr[i]);

      strBuild.append(String.valueOf(arr));
      strBuild.append(" ");
    }

    // Delete Last Space
    strBuild.deleteCharAt(strBuild.length() - 1);

    return String.valueOf(strBuild);
  }
}
