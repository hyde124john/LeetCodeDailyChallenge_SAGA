class findTargetSumWays_494 {
    HashMap<String,Long> mem = new HashMap<String,Long>();
    public long ways(int[] nums,int n,int sum,int S,int pos)
    {
        if(n==pos)
            return sum==S?1:0;
        String key = Integer.toString(pos) + "*" + Integer.toString(sum);
        if(mem.containsKey(key))
            return mem.get(key);
            
        long val = ways(nums,n,sum+nums[pos],S,pos+1) + ways(nums,n,sum-nums[pos],S,pos+1);
        mem.put(key,val);
        return val;
    }
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        if(n==0)
            return 0;
        
        return (int)(ways(nums,n,nums[0],S,1) + ways(nums,n,-nums[0],S,1));
    }
}
