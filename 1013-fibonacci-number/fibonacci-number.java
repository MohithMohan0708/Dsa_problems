class Solution {
    public int fibo(int n){
        if(n == 0){
            return 0;
        }
        if(n<2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    public int fib(int n) {
        return fibo(n);
    }
}