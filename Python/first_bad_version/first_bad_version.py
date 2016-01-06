class Solution(object):
	def firstBadVersion(self, n):
		return bs(0, n-1) + 1
		
	def bs(self, start, end):
		if start == end:
			return start
		median = (start + end) / 2
		if isBadVersion(median+1):
			return self.bs(start, median)
		else:
			self.bs(median+1, end)
