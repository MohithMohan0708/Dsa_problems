class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] count1 = new int[101];
        int[] count2 = new int[101];
        int[] count3 = new int[101];
        List<Integer> ans = new ArrayList<Integer>();
        for(int num: nums1){
            count1[num]+=1;
        }
        for(int num: nums2){
            count2[num]+=1;
        }
        for(int num: nums3){
            count3[num]+=1;
        }
        for(int i = 1; i < 101; i++){
            if((count1[i]!=0 && count2[i]!=0) || (count2[i]!=0 && count3[i]!=0) || (count3[i]!=0 && count1[i]!=0)){
                ans.add(i);
            }
        }
        return ans;
    }
}