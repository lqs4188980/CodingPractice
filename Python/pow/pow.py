class Solution(object):
	def myPow(self, x, n):
		pos = True
		if n < 0:
			pos = False
			n = -n
		if n == 0:
			return 1.0
		val = self.pow_pos(x, n)
		if pos:
			return val
		else:
			return 1 / val

	def pow_pos(self, x, n):
		if n < 2:
			return x
		val = self.myPow(x, n/2)
		if n % 2 == 1:
			return val * val * x
		else:
			return val * val

