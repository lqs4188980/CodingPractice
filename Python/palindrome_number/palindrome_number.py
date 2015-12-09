class Solution(object):
	def isPalindrome(self, x):
		if x < 0:
			return False
		if x < 10:
			return True
		c = [0]
		first_digit = self.first_digit(x, c)
		if first_digit != x % 10:
			return False
		x -= first_digit*10**c[0]
		y = x
		while y > 0:
			y //= 10
			c[0] -= 1
		x //= 10
		while c[0] != 0:
			if x % 10 != 0:
				return False
			x //= 10
			c[0] -= 1
		return self.isPalindrome(x)

	def first_digit(self, x, count):
		while x >= 10:
			x //= 10
			count[0] += 1
		return x
