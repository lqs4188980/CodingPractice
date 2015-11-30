# yay!! beats 100%

class NumMatrix(object):
	def __init__(self, matrix):
		self.matrix = matrix
		self.row_dp = []
		if len(matrix) == 0:
			return
		self.m = len(matrix)
		self.n = len(matrix[0])
		for i in range(self.m):
			sum = 0
			self.row_dp.append([])
			for j in range(self.n):
				sum += matrix[i][j]
				self.row_dp[i].append(sum)

	def update(self, row, col, val):
		if self.row_dp == []:
			return
		diff = val - self.matrix[row][col]
		self.matrix[row][col] = val
		for j in range(col, self.n):
			self.row_dp[row][j] += diff

	def sumRegion(self, row1, col1, row2, col2):
		# +---+---+
		# | 1 | 2 |
		# +---+---+
		# | 3 | 4 |
		# +---+---+
		if self.row_dp == []:
			return
		area_1234 = 0
		for i in range(row2+1):
			area_1234 += self.row_dp[i][col2]
		area_12 = 0
		for i in range(row1):
			area_12 += self.row_dp[i][col2]
		area_3 = 0
		if col1 > 0:
			for i in range(row1, row2+1):
				area_3 += self.row_dp[i][col1-1]

		return area_1234 - area_3 - area_12