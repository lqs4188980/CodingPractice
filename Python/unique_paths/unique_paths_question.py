class Solution(object):
    def uniquePaths(self, m, n):
        if m < 1 or n < 1:
            return 0
        table = []
        for i in range(m):
            table.append([])
            for j in range(n):
                if i == 0 or j == 0:
                    val = 1
                else:
                    val = table[i-1][j] + table[i][j-1]
                table[i].append(val)
        return table[m-1][n-1]
