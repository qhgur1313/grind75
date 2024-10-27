import java.util.ArrayList;
import java.util.List;

public class P46 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result= new ArrayList<>();
    backtrack(result, new ArrayList<>(), nums);
    return result;

  }

  private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
    if (current.size() == nums.length) {
      result.add(new ArrayList<>(current));
    }

    for (int num : nums) {
      if (current.contains(num)) {
        continue;
      }
      current.add(num);
      backtrack(result, current, nums);
      current.remove(current.size() - 1);
    }
  }
}
