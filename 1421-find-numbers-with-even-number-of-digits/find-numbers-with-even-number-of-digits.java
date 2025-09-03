class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            int curr = 0;
            while(num!=0){
                int rem = num % 10;
                num = num/10;
                curr += 1;
            }
            if(curr%2==0){
                count+=1;
            }
        }
        return count;
    }
}