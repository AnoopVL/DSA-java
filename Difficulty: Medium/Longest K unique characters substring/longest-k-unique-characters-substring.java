//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        if(s.length() == 0 ){
            return 0;
        }
        int i=0, j=0;
        int ans=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size() < k){
                j++;
            }
            else if(map.size() == k){
                ans= Math.max(ans, j-i+1);
                j++;
            }
            else if(map.size() > k){
                while(map.size() > k){
                    if(map.containsKey(s.charAt(i))){
                        int freq = map.get(s.charAt(i));
                        freq--;
                        map.put(s.charAt(i), freq);
                    }
                    if(map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        if(map.size() < k){
            return -1;
        }
        return ans;
    }
}
