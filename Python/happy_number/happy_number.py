class Solution(object):
	def isHappy(self, n):
		table = set()
		s = str(n)
		table.add(s)
		while s != '1':
			n_s = str(sum([int(c) ** 2 for c in s]))
			if n_s in table:
				return False
			table.add(n_s)
			s = n_s

		return True