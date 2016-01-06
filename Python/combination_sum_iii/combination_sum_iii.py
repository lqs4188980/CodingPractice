class Solution(object):
	def combinationSum3(self, k, n):
		if k < 1:
			return []
		res = []
		self.helper(k, n, [], 1, res)
		return res

	def helper(self, k, n, curr, idx, res):
		if n <= 0:
			if n == 0 and k == 0:
				res.append(curr)
			return 
		for i in range(idx, 10):
			_curr = curr + [i]
			self.helper(k-1, n-i, _curr, i+1, res)

