class Solution(object):
	def canWinNim(self, n):
		# nim[1] = 1
		# nim[2] = 1
		# nim[3] = 1
		# nim[4] = 0
		# nim[5] = 1
		# nim[6] = 1
		# nim[7] = 1
		# nim[8] = 0
		return n % 4 != 0