class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < grid.length; i++){
            for(int  j = 0; j < grid[0].length; j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int median = list.get(list.size()/2);
        int count = 0;
        for(Integer num:list){
            if(Math.abs(num-median)%x != 0){
                return -1;
            }
            count += Math.abs(num-median)/x;
        }
        return count;
    }
}