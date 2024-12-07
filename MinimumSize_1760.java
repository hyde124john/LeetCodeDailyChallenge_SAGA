class MinimumSize_1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int l =0, r =0;
        for(int num : nums) r = Math.max(r, num);
        int ans = r;
        while(l <= r){
            int mid = (l+r)/2;
            if(isPossible(mid, nums, maxOperations))
            {
                ans = mid;
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return ans;
    }
    static boolean isPossible(int maxBallsInBag,int[] nums, int maxOperation){
        int totalOperations = 0;
        for(int num: nums)
        {
            int operations = (int)Math.ceil((double)num / maxBallsInBag) - 1;
            totalOperations += operations;
            if(totalOperations > maxOperation){
                return false;
            }
        }
        return true;
    }
}
