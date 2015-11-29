class Solution(object):
	def plusOne(self, digits):
		carry = 1
		for i in range(len(digits)):
			val = digits[-i-1] + carry
			digits[-i-1] = val % 10
			carry = val / 10
		if carry:
			return [carry] + digits
		else:
			return digits