import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P56 {
  public int[][] merge(int[][] intervals) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] startArr = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      startArr[i] = intervals[i][0];
      Integer end = map.get(intervals[i][0]);
      if (end != null) {
        end = Math.max(end, intervals[i][1]);
      } else {
        end = intervals[i][1];
      }
      map.put(intervals[i][0], end);
    }

    Arrays.sort(startArr);
    List<int[]> list = new ArrayList<>();
    int index = 0;

    while (index <= intervals.length - 1) {
      int startNum = startArr[index];
      int endNum = map.get(startNum);
      index++;
      while (index <= intervals.length - 1) {
        int tmp = startArr[index];
        if (tmp <= endNum) {
          endNum = Math.max(map.get(tmp), endNum);
          index++;
        } else {
          break;
        }
      }

      list.add(new int[] {startNum, endNum});
    }

    int[][] result = new int[list.size()][2];

    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }

    return result;
  }
}
