class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do{ 
            slow = findSquare(slow);//we move this pointer by 1 step
            fast = findSquare(findSquare(fast));//we move this pointer by 2 steps
        }while (slow!=fast); 
        if(slow ==1){
            return true;
        }else{
            return false;
        }
    }
    private int findSquare(int num){
        int ans = 0;
        while(num >0){
            int rem = num %10;
            ans += rem*rem;
            num/=10;
        }
        return ans;
    }
}