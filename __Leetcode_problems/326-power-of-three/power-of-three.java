class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n % 3 != 0 || n == 0) return false;
        return helper(n);
    }
    private boolean helper(int n){
        if(n == 3)return true;
        if(n % 3 != 0) return false;
        if(n < 3) return false;
        return helper(n/3);
    }
}