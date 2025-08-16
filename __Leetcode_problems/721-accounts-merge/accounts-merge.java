class Solution {
    class DisjointSet{
        int[] parent, size;
        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int u, int v){
            int ulpU = find(u);
            int ulpV = find(v);
            if(ulpU == ulpV) return;
            if(size[ulpU] < size[ulpV]){
                parent[ulpU] = ulpV;
                size[ulpV] += size[ulpU];
            }else{
                parent[ulpV] = ulpU;
                size[ulpU] += size[ulpV];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                 if(!map.containsKey(mail)){
                    map.put(mail, i);
                }else{
                    ds.union(i, map.get(mail));
                }
            }
        }
        // mergedMap
        HashMap<Integer, List<String>> mergedMails = new HashMap<>();
        for(int i = 0; i < n; i++){
            mergedMails.put(i, new ArrayList<>());
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String mail = entry.getKey();
            int parentIndex = ds.find(entry.getValue());
            mergedMails.get(parentIndex).add(mail);
        }
        // creating answer list
        List<List<String>> ansList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mergedMails.get(i).isEmpty()) continue;
            Collections.sort(mergedMails.get(i));
            List<String> account = new ArrayList<>();
            account.add(accounts.get(i).get(0));
            account.addAll(mergedMails.get(i));
            ansList.add(account);
        }
        return ansList;
    }
}