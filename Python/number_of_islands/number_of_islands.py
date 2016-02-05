class Solution(object):
    def numIslands(self, grid):
        if len(grid) < 1:
            return 0
        m = len(grid)
        n = len(grid[0])
        visited = [[0 for j in range(n)] for i in range(m)]
        num = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and visited[i][j] == 0:
                    self.bfs(grid, visited, i, j, m, n)
                    num += 1
        return num

    def bfs(self, grid, visited, i , j, m, n):
        q = [(i, j)]
        visited[i][j] = 1
        while q:
            (i, j) = q.pop(0)
            if i-1 >= 0 and i < m:
                if grid[i-1][j] == '1' and visited[i-1][j] == 0:
                    q.append((i-1, j))
                    visited[i-1][j] = 1
            if i+1 >= 0 and i+1 < m:
                if grid[i+1][j] == '1' and visited[i+1][j] == 0:
                    q.append((i+1, j))
                    visited[i+1][j] = 1
            if j-1 >= 0 and j-1 < n:
                if grid[i][j-1] == '1' and visited[i][j-1] == 0:
                    q.append((i, j-1))
                    visited[i][j-1] = 1
            if j+1 >= 0 and j+1 < n:
                if grid[i][j+1] == '1' and visited[i][j+1] == 0:
                    q.append((i, j+1))
                    visited[i][j+1] = 1
