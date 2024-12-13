class findScore_2593 {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        for (int i = 0; i < n; ++i) {
            minHeap.offer(new int[]{nums[i], i});
        }
        
        Set<Integer> markedIndex = new HashSet<>();
        long sum = 0;
        
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int val = curr[0];
            int index = curr[1];
            
            if (markedIndex.contains(index)) continue;
            
            sum += val;
            markedIndex.add(index);
            markedIndex.add(index - 1);
            markedIndex.add(index + 1);
        }
        
        return sum;
    }
}
