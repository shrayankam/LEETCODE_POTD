class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjLs = new ArrayList<>();
        int V=isConnected.length;

        for(int i=0;i<V;i++){
            adjLs.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int vis[]=new int[V];
        for(int i=0;i<vis.length;i++){
            vis[i]=0;
        }
        int count=0;
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
                count++;
                dfs(i,adjLs,vis);
            }
        }
        return count; 
    }

    public void dfs(int node, List<List<Integer>> adjLs, int vis[]){
        vis[node]=1;
        for(int neighbour:adjLs.get(node)){
            if(vis[neighbour]!=1){
                dfs(neighbour,adjLs,vis);
            }
        }
    }
}