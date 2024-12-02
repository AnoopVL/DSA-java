class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] sentArray = sentence.split(" ");
        int n = sentArray.length;
        int sn = searchWord.length();
        for(int i=0; i< n; i++){
            String str = sentArray[i];
            boolean found = false;
            if(str.charAt(0)== searchWord.charAt(0) && str.length() >= sn){
                if(sn == 1) return i+1;
                for(int j=1; j< sn; j++){
                    if(str.charAt(j) != searchWord.charAt(j)){
                        found = false;
                        break;
                    }else{
                        found = true;
                    }
                }
                if(found == true) return i+1;
                // return i+1;
            }
        }
        return -1;
    }
}