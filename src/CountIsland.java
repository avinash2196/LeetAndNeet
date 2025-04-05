public class CountIsland {
        int rows;
        int cols;
        char [][]grid;
        public int numIslands(char[][] grid) {
            if(grid==null || grid.length==0)
                return 0;
            this.grid=grid;
            rows=grid.length;
            cols=grid[0].length;
            int count=0;
            for(int row=0;row<rows;row++){
                for(int col=0;col<cols;col++){
                    if(grid[row][col]=='1'){
                        count++;
                        dfs(row,count);
                    }
                }
            }
            return count;
        }
        void dfs( int row,int col){
            if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]=='0')
                return;

            grid[row][col]='0';
            int []rowOffset={0,1,0,-1};
            int []colOffset={-1,0,1,0};
            for(int d=0;d<4;d++){
                dfs(row+rowOffset[d],col+colOffset[d]);
            }
        }
    public static void main(String[] args){
            CountIsland countIsland=new CountIsland();
            char [][]grid=new char[2][1];
            grid[0][0]='1';
            grid[1][0]='1';
            countIsland.numIslands(grid);
    }
}
