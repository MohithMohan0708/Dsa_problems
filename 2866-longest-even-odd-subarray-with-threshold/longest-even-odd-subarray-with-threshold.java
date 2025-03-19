class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int st = 0;
        while(st<nums.length && (nums[st]%2!=0 || nums[st]>threshold))
        st++;

        int ws = st<nums.length?1:0;
        for(int et = st+1;et<nums.length;et++){
            if(nums[et]%2==nums[et-1]%2 || nums[et]>threshold)
            {
                st = et;
                continue;
            }

            while(st<nums.length && (nums[st]%2!=0 || nums[st]>threshold)){
                st++;
            }

            ws = Math.max(ws, et-st+1);
        }
        return ws;
    }
}