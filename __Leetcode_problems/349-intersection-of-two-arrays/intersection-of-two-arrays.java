class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        if(nums1.length > nums2.length){
            for(int i =0; i< nums1.length; i++){
                set.add(nums1[i]);
            }
            for(int i =0; i< nums2.length; i++){
                if(set.contains(nums2[i]) && !ans.contains(nums2[i])){
                    ans.add(nums2[i]);
                }
            }
        }else{
            for(int i =0; i< nums2.length; i++){
                set.add(nums2[i]);
            }
            for(int i =0; i< nums1.length; i++){
                if(set.contains(nums1[i]) && !ans.contains(nums1[i])){
                    ans.add(nums1[i]);
                }
            }
        }
        int[] array = new int[ans.size()];
        for(int i=0; i< ans.size(); i++){
            array[i] = ans.get(i);
        }
        return array;
    }
}