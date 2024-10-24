import java.util.LinkedList;

public class P20 {
  public boolean isValid(String s) {
    LinkedList<Character> charList = new LinkedList<>();
    for (char par : s.toCharArray()) {
      if (par == '(' || par == '{' || par == '[') {
        charList.add(par);
      } else {
        if (charList.isEmpty()) {
          return false;
        }
        if (par == ')') {
          if (charList.get(charList.size() - 1) != '(') {
            return false;
          }
        } else if (par == '}') {
          if (charList.get(charList.size() - 1) != '{') {
            return false;
          }
        } else if (par == ']') {
          if (charList.get(charList.size() - 1) != '[') {
            return false;
          }
        }
        charList.remove(charList.size() - 1);
      }
    }
    return charList.isEmpty();
  }
}
