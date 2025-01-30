//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        int sum = 0;
        for(int i=0; i< arr.length; i++){
            sum += arr[i];
        }
        return minDiff(arr, sum);
    }
    private int minDiff(int[] arr, int sum){
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];
        for(int i=0; i< n+1; i++){
            t[i][0] = true;
        }
        for(int i=1; i< n+1; i++){
            for(int j=1; j< sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        ArrayList<Integer> vector = new ArrayList<>();
        for(int j=0; j< sum/2 + 1; j++){
            if(t[n][j] == true){
                vector.add(j);
            }
        }
        int mn = Integer.MAX_VALUE;
        for(int i=0; i< vector.size(); i++){
            mn = Math.min(mn, sum -2*(vector.get(i)));
        }
        return mn;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends