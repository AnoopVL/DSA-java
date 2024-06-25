class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            if(nums[i] + nums[j] == k) {
                count++;
                i++;
                j--;
            }
            else if(nums[i] + nums[j] > k) j--;
            else i++;
        }
        return count;
    }
}

// TLE
// public int maxOperations(int[] nums, int k) {
    //     int count = 0;
    //     if(nums == null){
    //         return count;
    //     }
    //     ArrayList<Integer> list = IntStream.of(nums)
    //                                             .boxed()
    //                                             .collect(Collectors.toCollection(ArrayList::new));

    //     for (int i = 0; i < list.size(); i++) {
    //         for (int j = i + 1; j < list.size(); j++) { // Start j from i + 1 to avoid using the same element twice
    //             if (list.get(i) + list.get(j) == k) {
    //                 list.remove(j); // Remove the element at j first
    //                 list.remove(i); // Remove the element at i next (since j > i, this order is safe)
    //                 count++;
    //                 // size -= 2; // Decrease size by 2 since we removed 2 elements
    //                 i--; // Adjust i to recheck the current index after removal
    //                 break; // Break out of the inner loop after finding a valid pair
    //             }
    //         }
    //     }
    //     return count;
    // }