package _03_String.Excercise;

public class RunLengthEncoding {
  public static void main(String[] args) {
    System.out.println(encode("AAAAAAAABBBBBBBCCCCCCCLLLLLLMMMMMM"));
  }

  static String encode(String str) {
    StringBuilder stringBuilder = new StringBuilder();

    char currentChar = str.charAt(0);
    stringBuilder.append(str.charAt(0));
    int charCount = 1;
    for (int i = 1; i < str.length(); i++) {
      if (currentChar == str.charAt(i)) {
        charCount++;
      } else {
        stringBuilder.append(charCount);
        charCount = 1;
        currentChar = str.charAt(i);
        stringBuilder.append(currentChar);
      }
    }
    stringBuilder.append(charCount);

    return new String(stringBuilder);
  }
}
