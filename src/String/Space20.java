package String;

public class Space20 {
  public static void main(String[] args) {
    char[] strA = new char[]{'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', ' ', 'a', ' '};
//    char[] strA = new char[]{'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
    char[] res = addSpace20(strA);
    for (char c : res)
      System.out.print(c + " ");
  }

  // O(N) | O(N)
  private static char[] addSpace20(char[] strA) {
    int totalSpace = 0;
    for (char c : strA) if (c == ' ') totalSpace++;
    if (totalSpace == 0) return strA;

    int additionalSpace = totalSpace * 2;
    char[] res = new char[strA.length + additionalSpace];

    int counter = 0;
    int idx = 0;
    while (counter < strA.length) {
      if (strA[counter] != ' ')
        res[idx++] = strA[counter];
      else {
        res[idx] = '%';
        res[idx + 1] = '2';
        res[idx + 2] = '0';
        idx += 3;
      }
      counter++;
    }

    return res;
  }
}
