package String.Excercise;

public class PalindromeBreak {
  public static void main(String[] args) {
    System.out.println(breakString("abccba"));
    System.out.println(breakString("a"));
    System.out.println(breakString("aa"));
    System.out.println(breakString("aba"));
  }

  static String breakString(String str) {
    char[] charArray = str.toCharArray();
    if (charArray.length == 1) return "";
    boolean changed = false;

    for (int i = 0; i < str.length() / 2; i++) {
      if (charArray[i] != 'a') {
        charArray[i] = 'a';
        changed = true;
        break;
      }
    }

    if (!changed)
      if (charArray[charArray.length - 1] != 'a') charArray[charArray.length - 1] = 'a';
      else charArray[charArray.length - 1] = 'b';

    return String.valueOf(charArray);
  }
}
