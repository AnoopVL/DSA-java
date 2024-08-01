class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        String s=""; 
        int age=0;
        for(String str: details){
            s= str.substring(11, 13);
            age=Integer.parseInt(s);
            if(age>60){
                count++;
            }
        }

        return count;
    }
}