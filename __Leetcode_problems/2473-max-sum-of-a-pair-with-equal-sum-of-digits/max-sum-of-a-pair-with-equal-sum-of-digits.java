class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int num : nums) {
            int digitSum = sumOfDigits(num);
            map.putIfAbsent(digitSum, new ArrayList<>()); // Initialize list if not present
            map.get(digitSum).add(num); // Add number to list
        }

        for (List<Integer> values : map.values()) {
            if (values.size() > 1) { // Only consider if we have at least two numbers
                // Sort values in descending order
                Collections.sort(values, Collections.reverseOrder());
                // Take the top two numbers with the same digit sum
                ans = Math.max(ans, values.get(0) + values.get(1));
            }
        }

        return ans;
    }
    private int sumOfDigits(int digit) {
        int sum = 0;
        while (digit > 0) {
            sum += digit % 10;
            digit /= 10;
        }
        return sum;
    }

}
