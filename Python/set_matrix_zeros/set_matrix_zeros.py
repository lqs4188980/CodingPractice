class Solution(object):
    def setZeroes(self, matrix):
        if len(matrix) < 1 or len(matrix[0]) < 1:
            return
        m = len(matrix)
        n = len(matrix[0])

        first_col = False
        for i in range(1, m):
            if matrix[i][0] == 0:
                first_col = True

        first_row = False
        for j in range(1, n):
            if matrix[0][j] == 0:
                first_row = True

        if matrix[0][0] == 0:
            first_col = True
            first_row = True

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[0][j] = 0
                    matrix[i][0] = 0

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][0] == 0 \
                        or matrix[0][j] == 0:
                    matrix[i][j] = 0

        if first_col:
            for i in range(m):
                matrix[i][0] = 0

        if first_row:
            for j in range(n):
                matrix[0][j] = 0
