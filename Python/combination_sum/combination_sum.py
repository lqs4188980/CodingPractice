# runtime: 200±20ms
# ??? a peak around 100ms ??? another algorithm?

class Solution(object):
	def combinationSum(self, candidates, target):
		res = []
		candidates = sorted(candidates)
		self.get_combin(0, candidates, target, [], res)
		return res

	def get_combin(self, idx, candidates, target, path, res):
		if target <= 0:
			if target == 0:
				res.append(path)
			return
		for i in xrange(idx, len(candidates)):
			next_path = path + [candidates[i]]
			self.get_combin(i, candidates, target-candidates[i], next_path, res)
