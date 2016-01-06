class Solution(object):
	def countAndSay(self, n):
		init = "1"
		curr = init
		while n > 1:
			curr = self.get_next(init)
			init = curr
			n -= 1
		return curr

	def get_next(self, curr):
		res = ""
		char = curr[0]
		i = 0
		while i < len(curr):
			j = i
			while j < len(curr) and curr[j] == curr[i]:
				j += 1
			res += str(j-i) + curr[i]
			i = j
		return res

