class NumMatrix(object):
	def __init__(self, matrix):
		self.matrix = matrix
		if len(self.matrix) < 1:
			return
		for j in range(1, len(self.matrix[0])):
			self.matrix[0][j] = self.matrix[0][j] + self.matrix[0][j-1]
		for i in range(1, len(self.matrix)):
			self.matrix[i][0] = self.matrix[i][0] + self.matrix[i-1][0]
		for i in range(1, len(self.matrix)):
			for j in range(1, len(self.matrix[0])):
				self.matrix[i][j] = self.matrix[i][j] + self.matrix[i][j-1] + self.matrix[i-1][j] - self.matrix[i-1][j-1]


	def sumRegion(self, row1, col1, row2, col2):
		#+---+---+
		#| 1 | 2 |
		#+---+---+
		#| 3 | 4 |
		#+---+---+
		if self.matrix == []:
			return 0
		area_1234 = self.matrix[row2][col2]
		if row1 > 0 and col1 > 0:
			area_1 = self.matrix[row1-1][col1-1]
		else:
			area_1 = 0
		if row1 > 0:
			area_12 = self.matrix[row1-1][col2]
		else:
			area_12 = 0
		if col1 > 0:
			area_13 = self.matrix[row2][col1-1]
		else:
			area_13 = 0
		return area_1234 - area_12 - area_13 + area_1

