class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int freqV = 0;
        int freqC = 0;
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                freqV = Math.max(freqV, map.get(s.charAt(i)));
            }else{
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                freqC = Math.max(freqC, map.get(s.charAt(i)));
            }
        }   
        // if(freqV == 0 || freqC == 0) return 0;
        return freqV + freqC;
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}