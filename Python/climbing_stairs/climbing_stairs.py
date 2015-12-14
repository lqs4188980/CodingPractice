class Solution(object):
	def climbStairs(self, n):
		if n < 2:
			return n
		pprev = 1
		prev = 1
		for i in range(2, n):
			val = pprev + prev
			pprev = prev
			prev = val

		return pprev + prev
