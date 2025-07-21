class Solution {
    final int modulo = 1000000007;
    public int countPairs(int[] arr) {
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        outer: for(int num : arr){
            int power = 1;
            inner: for(int i = 0; i < 22; i++){
                if(map.containsKey(power - num)){
                    ans += map.get(power - num);
                    ans %= modulo;
                }
                power *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) ans;
    }
}