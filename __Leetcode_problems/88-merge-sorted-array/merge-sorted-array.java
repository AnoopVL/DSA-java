class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i=0; i< nums1.length; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        m = m-1;
        n = n-1;
        int last = nums1.length -1;
        while(m >= 0 && n >= 0 && last >= 0){
            if(nums2[n] > nums1[m]){
                nums1[last] = nums2[n];
                last--;
                n--;
            }
            else{
                nums1[last] = nums1[m];
                last--;
                m--;
            }
        }
        while (n >= 0) {
            nums1[last] = nums2[n];
            last--;
            n--;
        }
    }
}