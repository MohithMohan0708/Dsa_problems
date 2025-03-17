class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int validIndex = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++){
            int new_x = points[i][0];
            int new_y = points[i][1];
            if(x==new_x || y==new_y){
                int man_dist = Math.abs(x-new_x) + Math.abs(y-new_y);
                if(man_dist < minDist){
                    minDist = man_dist;
                    validIndex = i;
                }
            }
        }
        return validIndex;
    }
}