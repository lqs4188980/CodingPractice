class Solution(object):
	def getFactors(self, n):
		res = []
		self.helper(res, [], 2, n)
		return res

	def helper(self, res, curr, start, n):
		while start * start <= n:
			if n % start == 0:
				res.append(curr + [start, n//start])
				self.helper(res, curr+[start], start, n//start)
			start += 1

# 32
#  | -> 2 16
#       2  | -> 2 8
#       2       2 | -> 2 4
#       2       2      2 | -> 2 2

# keeping prefixes


