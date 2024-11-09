class Solution {
    public boolean isCircularSentence(String sentence) {
        // sentence = sentence.toLowerCase();
        String[] sentArray = sentence.split(" ");
        if(sentArray.length == 1){
            if(sentArray[0].charAt(0) != sentArray[0].charAt(sentArray[0].length() -1)){
                return false;
            }
            return true;
        }
        if(sentArray[0].charAt(0) != sentArray[sentArray.length -1].charAt((sentArray[sentArray.length -1]).length() -1)){
            return false;
        }
        
        for(int i=1; i < sentArray.length; i++){
            if(sentArray[i].charAt(0) != sentArray[i-1].charAt(sentArray[i-1].length() -1)){
                return false;
            }
            if(i != sentArray.length -1){
                if(sentArray[i].charAt(sentArray[i].length() -1) != sentArray[i+1].charAt(0)){
                    return false;
                }
            }
        }
        return true;

    }
}