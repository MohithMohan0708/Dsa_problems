class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<List<Integer>,Integer> map = new HashMap<>();
        int maxi = 0;
        for(int i = 0; i < dominoes.length; i++){
            List<Integer> nums = Arrays.asList(Math.min(dominoes[i][0],dominoes[i][1]),Math.max(dominoes[i][0],dominoes[i][1]));
            map.put(nums,map.getOrDefault(nums,0)+1);
            maxi += map.get(nums)-1;
        }
        return maxi;
    }
}