class Solution {
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}}; 
    int totalr = 0;
    int totalc = 0;
    public void solve(char[][] grid) {
        totalr = grid.length; 
        totalc = grid[0].length; 

        for(int r: new int[]{0,totalr-1}) {
            for(int j=0; j<totalc; ++j) {
                if(grid[r][j] == 'O') {
                    dfs(grid, r, j, 'J'); 
                }
            }
        }

        for(int c: new int[]{0, totalc-1}) {
            for(int j=1; j<totalr-1; ++j) {
                if(grid[j][c] == 'O') {
                    dfs(grid, j, c, 'J'); 
                }
            }
        }

        for(int i=0; i<totalr; ++i) {
            for(int j=0; j<totalc; ++j) {
                if(grid[i][j] == 'J') {
                    grid[i][j] = 'O';
                } else if(grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] grid, int r, int c, char fill) {
        grid[r][c] = fill; 
        for(int[] dir: dirs) {
            if(isValid(r+dir[0], c+dir[1]) && grid[r+dir[0]][c+dir[1]] == 'O')
                dfs(grid, r+dir[0], c+dir[1], fill); 
        }
    }

    private boolean isValid(int r, int c) {
        if(r >= 0 && r < totalr && c >= 0 && c < totalc)
            return true;
        return false; 
    }

    }