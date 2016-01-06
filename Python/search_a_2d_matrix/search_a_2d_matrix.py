class Solution(object):
	def searchMatrix(self, matrix, target):
		idx_row = self.search_row(0, len(matrix)-1, matrix, target)
		return self.search_col(0, len(matrix[idx_row])-1, matrix[idx_row], target)

	def search_row(self, start, end, matrix, target):
		if start == end:
			if matrix[start][0] > target:
				return start - 1
			else:
				return start
		median = (start + end) // 2
		if matrix[median][0] == target:
			return median
		if matrix[median][0] > target:
			return self.search_row(start, median, matrix, target)
		else:
			return self.search_row(median+1, end, matrix, target)

	def search_col(self, start, end, row, target):
		if start == end:
			if row[start] != target:
				return False
			else:
				return True
		median = (start + end) // 2
		if row[median] == target:
			return True
		if row[median] > target:
			return self.search_col(start, median, row, target)
		else:
			return self.search_col(median+1, end, row, target)
		
		
