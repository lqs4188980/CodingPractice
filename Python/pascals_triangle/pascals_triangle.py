class Solution(object):
    def generate(self, numRows):
        # !!
        res = [[1] * l for l in range(1, numRows+1)]
        for i in range(1, numRows):
            res[i][0] = 1
            for j in range(1, i+1):
                prev = res[i-1][j-1]
                curr = 0 if j == i else res[i-1][j]
                res[i][j] = prev + curr
        return res
