class Solution {
    public int minSwaps(String s) {
        if(s == ""){
            return 0;
        }
        int swap =0;
        int i =0;
        int j = s.length()-1;
        int openCount =0, closeCount = 0;
        char[] sc = s.toCharArray();
        while(i < j){
            if(sc[j] != '['){
                while(sc[j] != '['){
                    j--;
                }
            }
            if(sc[i] == '['){
                openCount++;
            }else{
                closeCount++;
            }
            if(closeCount > openCount){
                char temp = sc[i];
                sc[i] = sc[j];
                sc[j] = temp;
                swap++;
                openCount++;
                closeCount--;
            }
            i++;
            // j--;
        }
        return swap;
    }
}