class Solution {
    public boolean rotateString(String s, String goal) {
        int n= s.length();
        for(int i=0; i< s.length(); i++){
            String rotateS = s.substring(i) + s.substring(0,i);
            if(rotateS.equals(goal)){
                return true;
            } 
        }
        return false;
    }
}