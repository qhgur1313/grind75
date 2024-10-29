import java.util.ArrayList;
import java.util.List;

public class P57 {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      return new int[][] {{newInterval[0], newInterval[1]}};
    }
    List<int[]> list = new ArrayList<>();
    int index = 0;
    while (index < intervals.length && newInterval[0] > intervals[index][1]) {
      list.add(intervals[index]);
      index++;
    }

    if (index == intervals.length || newInterval[1] < intervals[index][0]) {
      list.add(newInterval);
    } else {
      int newStart = Math.min(intervals[index][0], newInterval[0]);
      int newEnd = Math.max(intervals[index][1], newInterval[1]);
      index++;
      for (; index < intervals.length; index++) {
        if (!(intervals[index][0] <= newEnd)) {
          break;
        } else {
          newEnd = Math.max(intervals[index][1], newEnd);
        }
      }
      list.add(new int[] {newStart, newEnd});
    }
    for (; index < intervals.length; index++) {
      list.add(intervals[index]);
    }

    return list.toArray(new int[list.size()][2]);
  }
}
