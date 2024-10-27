import java.util.Arrays;

public class P33 {
  public int search(int[] nums, int target) {
    int l = nums.length;
    if (l == 1) {
      if (nums[0] == target) {
        return 0;
      } else {
        return -1;
      }
    }

    int rotatedIndex = findRotatedIndex(nums);
    Arrays.sort(nums);
    int index = Arrays.binarySearch(nums, target);
    if (index < 0) {
      return -1;
    }

    index += rotatedIndex + 1;
    if (index >= l) {
      index -= l;
    }
    return index;
  }

  private int findRotatedIndex(int[] nums) {
    int l = nums.length;

    int left = 0;
    int right = l - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (mid == 0) {
        break;
      }
      int lMid = nums[mid-1];
      int nMid = nums[mid];
      int rMid = nums[mid+1];

      if (lMid < nMid && nMid > rMid) {
        return mid;
      }
      if (nums[left] < nMid && nMid > nums[right]) {
        left = mid + 1;
      } else if (nums[left] > nMid && nMid < nums[right]){
        right = mid;
      } else if (nums[left] < nMid && nMid < nums[right]) {
        return -1;
      }
    }

    if (nums[left] < nums[right]) {
      return right ;
    }
    return left;
  }
}
