class IsArraySpecial_3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = 1;
        // Generating Prefix Sum Array
        for(int i = 1; i < n ; i ++){
            // Checking Parity O E O E
            if((nums[i] & 1) == (nums[i-1] & 1)){
                prefixSum[i] = 1;
            }
            else{
                prefixSum[i] = prefixSum[i - 1] + 1;
            }
        }
        // comparing queries with range of values to return boolean values
        boolean[] ans = new boolean[queries.length];
        int index = 0;
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            int range = end - start + 1;
            if(prefixSum[end] >= range){
                ans[index ++] = true;
            }
            else{
                ans[index ++] = false;
            }
        }
        return ans;
    }
}
