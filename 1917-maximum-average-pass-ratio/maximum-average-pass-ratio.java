class Tuple{
    int pass;
    int total;
    double passratio;
    Tuple(double passratio, int pass, int total){
        this.passratio = passratio;
        this.pass = pass;
        this.total = total;
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> Double.compare(b.passratio,a.passratio));
        int n = classes.length;
        for(int[] cls : classes){
            int pass = cls[0];
            int total = cls[1];
            double gain = calculateGain(pass,total);
            pq.offer(new Tuple(gain,pass,total));
        }
        while(extraStudents-- > 0){
            Tuple t = pq.peek();
            pq.remove();
            int pass = t.pass;
            int total = t.total;
            pq.offer(
                new Tuple(
                    calculateGain(pass+1,total+1),
                    pass+1,
                    total+1
                )
            );
        }
        double totalavg = 0;
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            totalavg += (double) (t.pass)/(t.total);
        }
        return (totalavg)/(n);
    }
    public double calculateGain(int pass, int total){
        return(
            (double) (pass+1) / (total+1) -
            (double) (pass)/(total)
        );
    }
}