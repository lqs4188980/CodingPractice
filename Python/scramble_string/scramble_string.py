class Solution(object):
	def isScramble(self, s1, s2):
		if not s1 or not s2 or len(s1) != len(s2):
			return False
		if s1 == s2:
			return True
		if sorted(s1) != sorted(s2):
			return False
		for i in range(1, len(s1)):
			if self.isScramble(s1[:i], s2[:i]) and \
				self.isScramble(s1[i:], s2[i:]):
				return True
			if self.isScramble(s1[:i], s2[-i:]) and \
				self.isScramble(s1[i:], s2[:-i]):
				return True
		return False

# &*%(^&%$#%@#Q$#%I*&%$#@@#$^%$%
# for i in range(1, len(s)): s[:i], s[-i:]  !!!!!! [start, end)
# for i in range(len(s)): s[i], s[~i]