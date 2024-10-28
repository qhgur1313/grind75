public class P53 {
  public int maxSubArray(int[] nums) {
    int currentMax = nums[0];
    int globalMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentMax = Math.max(nums[i], currentMax + nums[i]);
      globalMax = Math.max(globalMax, currentMax);
    }
    return globalMax;
  }
}
