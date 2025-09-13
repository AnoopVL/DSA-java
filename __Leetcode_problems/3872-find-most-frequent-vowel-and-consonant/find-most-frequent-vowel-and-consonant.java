class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int freqV = 0;
        int freqC = 0;
        for(char c : s.toCharArray()){
            if(isVowel(c)){
                map.put(c, map.getOrDefault(c, 0) + 1);
                freqV = Math.max(freqV, map.get(c));
            }else{
                map.put(c, map.getOrDefault(c, 0) + 1);
                freqC = Math.max(freqC, map.get(c));
            }
        }   
        return freqV + freqC;
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}