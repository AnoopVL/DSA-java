class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = words.length;
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i< allowed.length(); i++){
            set.add(allowed.charAt(i));
        }
        for(String str: words){
            char[] strChr =  str.toCharArray();
            for(int i=0; i< strChr.length; i++){
                if(!set.contains(strChr[i])){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}