class Solution {
    public String removeStars(String s) {
       int len = s.length();
        byte[] w = new byte[len];
        s.getBytes(0, len, w, 0);

        int j=0;
        for (byte b : w) {
            if (b == 42)
                j--;
            else
                w[j++] = b;
        }
        System.gc();
        return (new String(w, 0, j));
    }
}

//  StringBuilder ans = new StringBuilder();
//         for(int i = 0; i < s.length(); i++){
//             if(s.charAt(i)!='*'){
//                 ans.append(s.charAt(i));
//             }
//             else{
//                 ans.deleteCharAt(ans.length() -1);
//             }
//         }
//         System.gc();
//         return ans.toString();