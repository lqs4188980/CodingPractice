class Solution(object):
	def trailingZeroes(self, n):
		# num(2) >> num(5)
		# return num(5)
		result = 0
		tmp = 1
		while 5**tmp <= n:
			result += tmp
			tmp += 1

		return result
