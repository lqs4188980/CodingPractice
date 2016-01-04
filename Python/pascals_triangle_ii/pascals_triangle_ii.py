# 1:    1
# 2:   1 1
# 3:  1 2 1
# 4: 1 3 3 1
class Solution(object):
	def getRow(self, rowIndex):
		row = [0] * (rowIndex + 1)
		row[0] = 1
		for i in range(rowIndex + 1):
			prev = 0
			for j in range(i+1):
				tmp = row[j]
				row[j] += prev
				prev = tmp
		return row
