class MaxCount_2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int num: banned){
            set.add(num);
        }
        int sum = 0;
        int c = 0;
        for(int i =1; i <= n; i ++){
            if(set.contains(i)){
                continue;
            }
            if(sum + i > maxSum){
                break;
            }
            sum += i;
            c ++;
        }
        return c;
    }
}
