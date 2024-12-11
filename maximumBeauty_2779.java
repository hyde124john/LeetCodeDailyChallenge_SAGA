class maximumBeauty_2779{
//Sliding Window
    public int maximumBeauty(int[] nums, int k) {
       int maxCount = 0, winCount = 0, l = 0, n = nums.length;
       Arrays.sort(nums);
       for (int r = 0; r < n; r++) {
        winCount++;
        while (nums[r] - nums[l] > 2 * k) {
            winCount--;
            l++;
        }
        maxCount = Math.max(maxCount, winCount);
        }
       return maxCount; 
    }
}
