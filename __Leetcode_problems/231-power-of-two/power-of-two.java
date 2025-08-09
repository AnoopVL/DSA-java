class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1 || n == 2) return true;
        if(n%2 != 0 || n == 0) return false;
        return helper(n);
    }
    private boolean helper(int n){
        if(n == 2) return true;
        if(n % 2 != 0) return false;
        return helper(n/2);
    }
}