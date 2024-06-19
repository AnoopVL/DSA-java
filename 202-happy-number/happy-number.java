class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do{ 
            slow = findSquare(slow);//we move this pointer by 1 step
            fast = findSquare(findSquare(fast));//we move this pointer by 2 steps
            if(fast==1 || slow ==1){
                return true;
            }
        }while (slow!=fast); 
        
            return false;
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