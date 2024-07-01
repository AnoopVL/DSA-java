class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length <3){
            return false;
        }
        boolean consecutive = false;
        for(int i = 0; i< arr.length-2; i++){
            if(arr[i]%2!=0 && arr[i+1]%2!=0 && arr[i+2]%2!=0){
                consecutive = true;
                break;
            }
        }
        return consecutive;
    }
}