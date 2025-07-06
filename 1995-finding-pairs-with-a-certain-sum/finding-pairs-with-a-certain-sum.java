class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer,Integer> freqMap;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1.clone();
        this.nums2 = nums2.clone();
        freqMap = new HashMap<Integer,Integer>();
        for(int num : nums2){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int oldVal = nums2[index];
        freqMap.put(oldVal,freqMap.get(oldVal)-1);
        if(freqMap.get(oldVal)==0){
            freqMap.remove(oldVal);
        }
        int newVal = nums2[index]+val;
        nums2[index] = newVal;
        freqMap.put(newVal,freqMap.getOrDefault(newVal,0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int num : nums1){
            int rem = tot - num;
            count += freqMap.getOrDefault(rem,0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */