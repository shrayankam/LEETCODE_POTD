class Solution {

    private void dfs(int sr, int sc, int color, int initalColor,int[][] ans,int[][] image,int delRows[],int delCols[],int n,int m){
        ans[sr][sc]=color;
        for(int i=0;i<4;i++){
            int nRow=delRows[i]+sr;
            int nCol=delCols[i]+sc;
            
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && image[nRow][nCol]==initalColor && ans[nRow][nCol]!=color){
                dfs(nRow,nCol,color,initalColor,ans,image,delRows,delCols,n,m);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int ans[][]=new int[n][m];
        ans=image;
        int initialColor=image[sr][sc];
        int delRows[]={-1,0,1,0};
        int delCols[]={0,1,0,-1};
        dfs(sr,sc,color,initialColor,ans,image,delRows,delCols,n,m);
        return ans;
    }
}