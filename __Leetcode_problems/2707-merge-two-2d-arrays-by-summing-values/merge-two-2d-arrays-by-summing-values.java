class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums1.length; i++){
            map.put(nums1[i][0], map.getOrDefault(nums1[i][0], 0) + nums1[i][1]);
        }
        for(int i=0; i< nums2.length; i++){
            map.put(nums2[i][0], map.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }

        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort(Map.Entry.comparingByKey());
        int[][] ansList = new int[map.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> mapEntry: mapList){
            ansList[index][0] = mapEntry.getKey();
            ansList[index][1] = mapEntry.getValue();
            index++;
        }

        return ansList;
    }
}