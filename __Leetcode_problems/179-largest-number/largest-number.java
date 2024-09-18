class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrs = Arrays.stream(nums)
                                 .mapToObj(String::valueOf)
                                 .toArray(String[]::new);
        
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));
        
        String result = String.join("", numStrs);
        
        if (result.charAt(0) == '0') {
            return "0";
        }
        
        return result;
    }
}