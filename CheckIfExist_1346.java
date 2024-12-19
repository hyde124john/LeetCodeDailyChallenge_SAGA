class CheckIfExist_1346 {
    public boolean checkIfExist(int[] arr) {
        int n=arr.length;
        Map<Integer, Integer> map=new HashMap();
        for(int i=0; i<n; i++){
            if( map.containsKey(arr[i]*2)){
                return true;
            }
            else if(arr[i]%2==0 && map.containsKey(arr[i]/2)){
                return true;
            }
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);            
        }
        return false;
    }
}
