# # pip install enum34 before python3.4

# from enum import Enum
# class D(Enum):
# 	right = 0
# 	down = 1
# 	left = 2
# 	up = 3

# class Solution(object):
# 	def __init__(self):
# 		self.matrix = []
# 		self.dir = D.right
# 		self.m = 0

# 	def generateMatrix(self, n):
# 		if n < 1:
# 			return []
# 		self.matrix = [[0 for x in range(n)] for x in range(n)]		
# 		self.m = len(self.matrix)
# 		self.fill(0, 0, 1)
# 		return self.matrix

# 	def fill(self, i, j, num):
# 		while i >= 0 and i < self.m and \
# 				j >= 0 and j < self.m and \
# 				self.matrix[i][j] == 0:
# 			self.matrix[i][j] = num
# 			if num == self.m * self.m:
# 				return
# 			if self.dir == D.right:
# 				j += 1
# 			elif self.dir == D.down:
# 				i += 1
# 			elif self.dir == D.left:
# 				j -= 1
# 			elif self.dir == D.up:
# 				i -= 1
# 			num += 1

# 		if self.dir == D.right:
# 			j -= 1
# 			i += 1
# 			self.dir = D.down
# 		elif self.dir == D.down:
# 			i -= 1
# 			j -= 1
# 			self.dir = D.left
# 		elif self.dir == D.left:
# 			j += 1
# 			i -= 1
# 			self.dir = D.up
# 		elif self.dir == D.up:
# 			i += 1
# 			j += 1
# 			self.dir = D.right

# 		self.fill(i, j, num)
	


class Solution(object):
	def __init__(self):
		self.matrix = []
		self.right = 0
		self.down = 1
		self.left = 2
		self.up = 3
		self.dir = self.right
		self.m = 0

	def generateMatrix(self, n):
		if n < 1:
			return []
		self.matrix = [[0 for x in range(n)] for x in range(n)]		
		self.m = len(self.matrix)
		self.fill(0, 0, 1)
		return self.matrix

	def fill(self, i, j, num):
		while i >= 0 and i < self.m and \
				j >= 0 and j < self.m and \
				self.matrix[i][j] == 0:
			self.matrix[i][j] = num
			if num == self.m * self.m:
				return
			if self.dir == self.right:
				j += 1
			elif self.dir == self.down:
				i += 1
			elif self.dir == self.left:
				j -= 1
			elif self.dir == self.up:
				i -= 1
			num += 1

		if self.dir == self.right:
			j -= 1
			i += 1
			self.dir = self.down
		elif self.dir == self.down:
			i -= 1
			j -= 1
			self.dir = self.left
		elif self.dir == self.left:
			j += 1
			i -= 1
			self.dir = self.up
		elif self.dir == self.up:
			i += 1
			j += 1
			self.dir = self.right

		self.fill(i, j, num)

