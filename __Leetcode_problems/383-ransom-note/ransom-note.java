class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magMap = new HashMap<>();
        for(int i=0; i< magazine.length(); i++){
            magMap.put(magazine.charAt(i), magMap.getOrDefault(magazine.charAt(i),0) + 1);
        }
        // HashMap<Character, Integer> ransMap = new HashMap<>();
        for(int i=0; i< ransomNote.length(); i++){
            if(!magMap.containsKey(ransomNote.charAt(i)) || magMap.get(ransomNote.charAt(i)) < 1){
                return false;
            }
            magMap.put(ransomNote.charAt(i), magMap.get(ransomNote.charAt(i)) - 1);

        }
        // for(Map.Entry<Character, Integer> entry : magMap.entrySet()){
        //     if(!ransMap.containsKey(entry.getKey())){
        //         return false;
        //     }
        //     if(entry.getValue() < ransMap.get(entry.getKey())){
        //         return false;
        //     }
        // }
        return true;
    }
}