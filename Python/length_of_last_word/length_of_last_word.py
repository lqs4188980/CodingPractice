class Solution(object):
	def lengthOfLastWord(self, s):
		s = s.strip()
		if s.rfind(' '):
			return len(s) - s.rfind(' ') - 1
		else:
			return 0
			