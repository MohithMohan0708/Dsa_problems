class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int rem = n/7;
        if(n<7){
            for(int i = 1; i <= n; i++){
                total += i;
            }
            return total;
        }
        int first = 1;
        int curr = 0;
        while(curr < rem){
            for(int i = first; i < first + 7; i++){
                total += i;
            }
            first+=1;
            curr+=1;
        }
        for(int i = first; i < first+n-(rem*7);i++){
            total+=i;
        }
        return total;
    }
}