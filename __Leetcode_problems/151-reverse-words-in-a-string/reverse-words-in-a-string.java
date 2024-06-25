class Solution {
    public String reverseWords(String s) {
        // Split and trim the string
        String[] arr = s.trim().split("\\s+");
        int start = 0;
        int end = arr.length-1;
        // While start and end do not cross, exchange the elements
        while(start < end){
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.join(" ", arr);
    }
}