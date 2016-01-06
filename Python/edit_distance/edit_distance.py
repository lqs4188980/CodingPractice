class Solution(object):
	def minDistance(self, word1, word2):
		m = len(word1)
		n = len(word2)
		if m < 1:
			return n
		if n < 1:
			return m
		matrix = [[0] * (n+1) for i in range(m+1)]
		for i in range(m+1):
			matrix[i][0] = i
		for j in range(n+1):
			matrix[0][j] = j
		for i in range(1,m+1):
			for j in range(1,n+1):
				plus = 1 if word1[i-1] != word2[j-1] else 0
				matrix[i][j] = min(matrix[i-1][j] + 1, \
							matrix[i][j-1] + 1, \
							matrix[i-1][j-1] + plus)
		return matrix[-1][-1]
