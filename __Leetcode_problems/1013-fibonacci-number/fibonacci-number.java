class Solution {
    Map<Integer, Integer> integerMap = new HashMap<>();
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (integerMap.containsKey(n)) {
            return integerMap.get(n);
        }

        int val = fib(n - 1) + fib(n - 2);
        integerMap.put(n, val);
        return val;
    }
}