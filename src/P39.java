import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P39 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Map<Integer, List<List<Integer>>> map = new HashMap<>();
    map.put(0, new ArrayList<>(new ArrayList<>()));

    for (int c : candidates) {
      for (int i = 1; i < target + 1; i++) {
        map.putIfAbsent(i, new ArrayList<>());
        List<List<Integer>> dpList = map.get(i);
        int index = i - c;
        if (index == 0) {
          List<Integer> newList = new ArrayList<>();
          newList.add(c);
          dpList.add(newList);
        } else if (index > 0) {
          List<List<Integer>> prevList = map.get(index);
          for (List<Integer> l : prevList) {
            List<Integer> newList = new ArrayList<>(l);
            newList.add(c);
            dpList.add(newList);
          }
        }
      }
    }

    return map.get(target);
  }
}
