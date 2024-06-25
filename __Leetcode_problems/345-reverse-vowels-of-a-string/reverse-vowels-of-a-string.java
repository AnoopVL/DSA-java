class Solution {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start =0 ;
        int end  = s.length()-1;
        String vowels = "AEIOUaeiou";

        while(start < end){
            // Move the pointers till we get a vowel
            while(start < end && vowels.indexOf(word[start]) == -1){
                start++;
            }
            while(start < end && vowels.indexOf(word[end]) == -1){
                end--;
            }
            // Swap
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;   
            // Move the pointers
            start++;
            end--;
        }
        String answer = new String(word);
        return answer;
    }
}