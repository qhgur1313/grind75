import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class P981 {
  class TimeMap {
    LinkedHashMap<Integer, Map<String, String>> timeMap = new LinkedHashMap<>();
    List<Integer> timeList = new ArrayList<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
      timeMap.putIfAbsent(timestamp, new HashMap<>());
      timeMap.get(timestamp).put(key, value);
      timeList.add(timestamp);
    }

    public String get(String key, int timestamp) {
      String result = "";
      int i = getIndexLargestTime(timestamp);
      if (timeList.get(i) > timestamp) {
        return result;
      }

      while (i >= 0) {
        String val = timeMap.get(timeList.get(i)).get(key);
        if (Objects.nonNull(val)) {
          result = val;
          break;
        }
        i--;
      }
      return result;
    }

    private int getIndexLargestTime(int timestamp) {
      int left = 0;
      int right = timeList.size() - 1;

      while (left < right) {
        if (right - left == 1) {
          break;
        }
        int mid = (right + left) / 2;
        if (timeList.get(mid) < timestamp) {
          left = mid + 1;
        } else if (timeList.get(mid) > timestamp) {
          right = mid;
        } else {
          return mid;
        }
      }
      if (timeList.get(right) <= timestamp) {
        return right;
      }
      return left;
    }
  }
}
