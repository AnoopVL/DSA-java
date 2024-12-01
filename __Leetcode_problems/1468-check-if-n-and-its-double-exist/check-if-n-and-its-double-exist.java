class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< n; i++){
            // if(!set.contains(arr[i])) set.add(arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }
        for(int i=0; i< n; i++){
            if(arr[i]== 0){
                if(map.get(arr[i]) > 1){
                    return true;
                }else{
                    continue;
                }

            }
            if(map.containsKey(2*arr[i])) return true;
        }
        return false;
    }
}