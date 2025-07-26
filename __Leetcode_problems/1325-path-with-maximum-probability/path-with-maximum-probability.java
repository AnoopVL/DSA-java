class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
        }
        double[] distance = new double[n];
        distance[start] = 1d;
        Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] a : g.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                if (distance[cur] * succProb[index] > distance[neighbor]) {
                    distance[neighbor] = distance[cur] * succProb[index];
                    q.offer(neighbor);
                }
            }
        }
        return distance[end];
    }
}