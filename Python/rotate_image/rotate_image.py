class Solution(object):
    def rotate(self, matrix):
        self.rotate_boundary(0, matrix)

    def rotate_boundary(self, m, matrix):
        n = len(matrix)-m-1
        if m >= n:
            return
        for i in range(n-m):
            buffer = matrix[m][m+i]
            matrix[m][m+i] = matrix[n-i][m]
            matrix[n-i][m] = matrix[n][n-i]
            matrix[n][n-i] = matrix[m+i][n]
            matrix[m+i][n] = buffer
        self.rotate_boundary(m+1, matrix)